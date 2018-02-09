package com.example.photontest.ui;

import com.example.photontest.base.BasePresenter;
import com.example.photontest.base.BaseView;
import com.example.photontest.model.Result;

public interface MainContract {

    interface View extends BaseView {

        void showResult(Result result);

    }

    interface Presenter extends BasePresenter {

        void calculateLowestCost(Object[][] inputMatrix);

    }

}
