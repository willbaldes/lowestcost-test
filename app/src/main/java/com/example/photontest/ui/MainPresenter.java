package com.example.photontest.ui;

import com.example.photontest.helper.ResourceHelper;
import com.example.photontest.model.LowestCost;
import com.example.photontest.model.Result;
import com.example.photontest.util.Constants;

import javax.inject.Inject;

public class MainPresenter implements MainContract.Presenter {

    private MainContract.View mainView;
    private LowestCost lowestCost;

    @Inject ResourceHelper resourceHelper;

    @Inject
    MainPresenter(MainContract.View mainView) {
        this.mainView = mainView;
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
        Result result = lowestCost.calculateLowestCost(inputMatrix);
        if(result.getErrorCode() == Constants.ResultCode.RESULT_OK) {
            mainView.showResult(result);
        } else {
            String text = resourceHelper.getStringError(result.getErrorCode());
            mainView.showError(text);
        }
    }

}
