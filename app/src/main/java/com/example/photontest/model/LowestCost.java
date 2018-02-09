package com.example.photontest.model;

import com.example.photontest.util.Constants.ResultCode;
import com.example.photontest.util.Constants.DomainSpecs;

public class LowestCost {

    private int[][] costMatrix;
    private int ROWS, COLS;

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
        return null;
    }

    private int validateInput(Object[][] inputMatrix) {
        if(inputMatrix != null) {
            ROWS = inputMatrix.length;
            if(ROWS < DomainSpecs.MIN_ROWS || ROWS > DomainSpecs.MAX_ROWS) {
                return ResultCode.ERROR_ROWS;
            }
            COLS = inputMatrix[0].length;
            if(COLS < DomainSpecs.MIN_COLS || COLS > DomainSpecs.MAX_COLS) {
                return ResultCode.ERROR_COLS;
            }
            try {
                costMatrix = new int[ROWS][COLS];
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
