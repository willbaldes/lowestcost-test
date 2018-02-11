package com.example.photontest.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.example.photontest.R;
import com.example.photontest.app.PhotonApp;
import com.example.photontest.di.components.DaggerMainViewComponent;
import com.example.photontest.di.modules.MainViewModule;
import com.example.photontest.model.Result;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    private static final String ROWS_DELIMITER = "";
    private static final String COLS_DELIMITER = " ";

    @BindView(R.id.input_et) EditText inputET;
    @BindView(R.id.valid_tv) TextView validTV;
    @BindView(R.id.cost_tv) TextView costTV;
    @BindView(R.id.path_tv) TextView pathTV;
    @BindView(R.id.error_tv) TextView errorTV;

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
        errorTV.setText(error);
    }

    @Override
    public void showResult(Result result) {

    }

    @OnClick(R.id.submit) void calculate() {
        mainPresenter.calculateLowestCost(parseInput());
    }

    @OnClick(R.id.reset) void reset() {

    }

    private Object[][] parseInput() {
        String userInput = inputET.getText().toString();
        Object[][] input;
        if(userInput.isEmpty()) {
            return null;
        } else {
            String[] rows = userInput.split(ROWS_DELIMITER);
            int rowCount = rows.length;
            int columnCount = rows[0].split(COLS_DELIMITER).length;
            input = new Object[rowCount][columnCount];
            for(int row = 0; row < rowCount; row++) {
                Object[] items = rows[row].split(COLS_DELIMITER);
                System.arraycopy(items, 0, input[row], 0, columnCount);
            }
            return input;
        }
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
