package com.example.photontest.model;

import com.example.photontest.util.Constants.DomainSpecs;
import com.example.photontest.util.Constants.ResultCode;

public class LowestCost {

    private int[][] costMatrix;
    private int ROWS, COLS;
    private int[] path;

    public Result calculateLowestCost(Object[][] inputMatrix) {
        Result result = new Result();
        int resultCode = validateInput(inputMatrix);
        switch (resultCode) {
            case ResultCode.ERROR_INPUT:
                result.setErrorCode(resultCode);
                break;
            case ResultCode.RESULT_OK:
                result = processPaths();
                break;
        }
        return result;
    }

    private Result processPaths() {
        Result result;
        int entry = findEntryPoint();
        boolean isValid = true;
        if (entry >= 0) {
            path[0] = entry + 1;
            int cost = costMatrix[entry][0];
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
        result.setErrorCode(ResultCode.RESULT_OK);
        return result;
    }

    private int findNextMin(int entry, int cols) {
        int index = 0;
        int topRightIndex = entry - 1 < 0 ? ROWS - 1 : entry - 1;
        int bottomRightIndex = entry + 1 == ROWS ? 0 : entry + 1;
        int topRight = costMatrix[topRightIndex][cols];
        int right = costMatrix[entry][cols];
        int bottomRight = costMatrix[bottomRightIndex][cols];
        if ((topRight <= right) && (topRight <= bottomRight)) {
            index = topRightIndex;
        }
        if ((right < topRight) && (right < bottomRight)) {
            index = entry;
        }
        if ((bottomRight < topRight) && (bottomRight < right)) {
            index = bottomRightIndex;
        }
        return index;
    }

    private int findEntryPoint() {
        int index = -1;
        int min = DomainSpecs.MAX_COST;

        for (int i = 0; i < ROWS; i++) {
            if (costMatrix[i][0] < min) {
                min = costMatrix[i][0];
                index = i;
            }
        }

        if (COLS > 1 && index != -1) {
            int topRightIndex = index - 1 < 0 ? ROWS - 1 : index - 1;
            int bottomRightIndex = index + 1 == ROWS ? 0 : index + 1;
            int topRight = costMatrix[topRightIndex][1];
            int right = costMatrix[index][1];
            int bottomRight = costMatrix[bottomRightIndex][1];
            if (topRight >= DomainSpecs.MAX_COST && right >= DomainSpecs.MAX_COST && bottomRight >= DomainSpecs.MAX_COST) {
                for (int i = 0; i < ROWS; i++) {
                    if (costMatrix[i][0] > min && costMatrix[i][0] < DomainSpecs.MAX_COST) {
                        min = costMatrix[i][0];
                        index = i;
                    }
                }
            }
        }

        return index;
    }

    private int validateInput(Object[][] inputMatrix) {
        ROWS = inputMatrix.length;
        COLS = inputMatrix[0].length;
        try {
            costMatrix = new int[ROWS][COLS];
            path = new int[COLS];
            for (int rows = 0; rows < ROWS; rows++) {
                for (int cols = 0; cols < COLS; cols++) {
                    if(inputMatrix[rows][cols] instanceof String) {
                        // Should execute when input comes from UI
                        costMatrix[rows][cols] = Integer.parseInt((String) inputMatrix[rows][cols]);
                    } else {
                        // Should execute for direct testing
                        costMatrix[rows][cols] = (Integer) inputMatrix[rows][cols];
                    }
                }
            }
            return ResultCode.RESULT_OK;
        } catch (ClassCastException | NumberFormatException e) {
            e.printStackTrace();
            return ResultCode.ERROR_INPUT;
        }
    }

}
