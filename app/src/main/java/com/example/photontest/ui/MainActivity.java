package com.example.photontest.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.photontest.R;
import com.example.photontest.app.PhotonApp;
import com.example.photontest.di.components.DaggerMainViewComponent;
import com.example.photontest.di.modules.MainViewModule;
import com.example.photontest.model.Result;

import javax.inject.Inject;

import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    @Inject MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initDagger();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mainPresenter.bind();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mainPresenter.unbind();
    }

    @Override
    public void showError(String error) {

    }

    @Override
    public void showResult(Result result) {

    }

    void calculate() {
        // TODO Add validation then call
        mainPresenter.calculateLowestCost(null);
    }

    private void initDagger() {
        DaggerMainViewComponent
                .builder()
                .appComponent(PhotonApp.getAppComponent())
                .mainViewModule(new MainViewModule(this))
                .build()
                .inject(this);
    }
}
