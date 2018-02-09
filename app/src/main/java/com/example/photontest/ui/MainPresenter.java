package com.example.photontest.ui;

import com.example.photontest.helper.ResourceHelper;
import com.example.photontest.model.LowestCost;
import com.example.photontest.model.Result;
import com.example.photontest.util.Constants.ResultCode;
import com.example.photontest.util.Constants.DomainSpecs;

import javax.inject.Inject;

public class MainPresenter implements MainContract.Presenter {

    private MainContract.View mainView;
    private LowestCost lowestCost;
    private ResourceHelper resourceHelper;

    @Inject
    MainPresenter(MainContract.View mainView, ResourceHelper resourceHelper) {
        this.mainView = mainView;
        this.resourceHelper = resourceHelper;
    }

    @Override
    public void bind() {
        lowestCost = new LowestCost();
    }

    @Override
    public void unbind() {
        lowestCost = null;
    }

    @Override
    public void calculateLowestCost(Object[][] inputMatrix) {
        int resultCode = validateInput(inputMatrix);
        switch (resultCode) {
            case ResultCode.RESULT_OK:
                processResult(lowestCost.calculateLowestCost(inputMatrix));
                break;
            case ResultCode.ERROR_EMPTY:
            case ResultCode.ERROR_COLS:
            case ResultCode.ERROR_ROWS:
                processError(resultCode);
                break;
            default:
                processError(ResultCode.ERROR_STATE);
        }
    }

    private void processError(int resultCode) {
        mainView.showError(resourceHelper.getStringError(resultCode));
    }

    private void processResult(Result result) {
        if (result.getErrorCode() == ResultCode.RESULT_OK) {
            mainView.showResult(result);
        } else {
            processError(result.getErrorCode());
        }
    }

    private int validateInput(Object[][] inputMatrix) {
        if(inputMatrix == null) {
            return ResultCode.ERROR_EMPTY;
        } else {
            if(inputMatrix.length > DomainSpecs.MAX_ROWS) {
                return ResultCode.ERROR_ROWS;
            }
            if(inputMatrix[0].length < DomainSpecs.MIN_COLS || inputMatrix[0].length > DomainSpecs.MAX_COLS) {
                return ResultCode.ERROR_COLS;
            }
            return ResultCode.RESULT_OK;
        }
    }

}
