package com.example.photontest.model;

import com.example.photontest.util.Constants.ResultCode;
import com.example.photontest.util.Constants.DomainSpecs;

public class LowestCost {

    private int[][] costMatrix;
    private int ROWS, COLS;
    private int[] path;
    private int cost;

    public Result calculateLowestCost(Object[][] inputMatrix) {
        Result result;
        int resultCode = validateInput(inputMatrix);
        switch (resultCode) {
            case ResultCode.ERROR_EMPTY:
                result = new Result(resultCode);
                break;
            case ResultCode.ERROR_INPUT:
                result = new Result(resultCode);
                break;
            case ResultCode.ERROR_COLS:
                result = new Result(resultCode);
                break;
            case ResultCode.ERROR_ROWS:
                result = new Result(resultCode);
                break;
            case ResultCode.RESULT_OK:
                result = processPaths();
                break;
            default:
                result = new Result(ResultCode.ERROR_STATE);
        }
        return result;

    }

    private Result processPaths() {
        Result result = null;
        int entry = findEntryPoint();
        boolean isValid = true;
        if(entry >= 0) {
            path[0] = entry + 1;
            cost = costMatrix[entry][0];
            for (int cols = 1; cols < COLS; cols++) {
                entry = findNextMin(entry, cols);
                int tempSum = cost + costMatrix[entry][cols];
                if (tempSum <= 50) {
                    cost = tempSum;
                    path[cols] = entry + 1;
                } else {
                    isValid = false;
                    break;
                }
            }
            result = new Result(cost, path, isValid);
        } else {
            result = new Result(0, null, false);
        }
        return result;
    }

    private int findNextMin(int entry, int cols) {
        int index = 0;
        int topRightIndex = entry - 1 < 0 ? ROWS - 1 : entry - 1;
        int bottomRightIndex = entry + 1 == ROWS ? 0 : entry + 1;
        int topRight = costMatrix[topRightIndex][cols];
        int right = costMatrix[entry][cols];
        int bottomRight = costMatrix[bottomRightIndex][cols];
        if(topRight <= right && topRight < bottomRight) {
            index = topRightIndex;
        }
        if(right < topRight && right < bottomRight) {
            index = entry;
        }
        if(bottomRight<topRight && bottomRight < right) {
            index = bottomRightIndex;
        }
        return index;
    }

    private int findEntryPoint(){
        int index = -1;
        int min = DomainSpecs.MAX_COST;
        for(int i = 0; i<ROWS; i++) {
            if(costMatrix[i][0] < min) {
                min = costMatrix[i][0];
                index = i;
            }
        }
        return index;
    }

    private int validateInput(Object[][] inputMatrix) {
        if(inputMatrix != null) {
            ROWS = inputMatrix.length;
            if(ROWS > DomainSpecs.MAX_ROWS) {
                return ResultCode.ERROR_ROWS;
            }
            COLS = inputMatrix[0].length;
            if(COLS < DomainSpecs.MIN_COLS || COLS > DomainSpecs.MAX_COLS) {
                return ResultCode.ERROR_COLS;
            }
            try {
                costMatrix = new int[ROWS][COLS];
                path = new int[COLS];
                for (int rows = 0; rows < ROWS; rows++) {
                    for (int cols = 0; cols < COLS; cols++) {
                        costMatrix[rows][cols] = (Integer) inputMatrix[rows][cols];
                    }
                }
                return ResultCode.RESULT_OK;
            } catch (ClassCastException e) {
                e.printStackTrace();
                return ResultCode.ERROR_INPUT;
            }
        } else {
            return ResultCode.ERROR_EMPTY;
        }
    }

}
