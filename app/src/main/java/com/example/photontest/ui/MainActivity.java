package com.example.photontest.ui;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.example.photontest.R;
import com.example.photontest.app.PhotonApp;
import com.example.photontest.di.components.DaggerMainViewComponent;
import com.example.photontest.di.modules.MainViewModule;
import com.example.photontest.model.Result;
import com.example.photontest.util.EspressoIdlingResource;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    private static final String ROWS_DELIMITER = "\n";
    private static final String COLS_DELIMITER = " ";
    private static final String TAG = MainActivity.class.getSimpleName() + "_TAG";

    @BindView(R.id.input_et) EditText inputET;
    @BindView(R.id.valid_tv) TextView validTV;
    @BindView(R.id.cost_tv) TextView costTV;
    @BindView(R.id.path_tv) TextView pathTV;
    @BindView(R.id.error_tv) TextView errorTV;
    @BindView(R.id.submit) Button submitBT;
    @BindView(R.id.reset) Button resetBT;

    @Inject MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initDagger();
        initViews();
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
        submitBT.setEnabled(true);
        errorTV.setText(error);
        errorTV.setVisibility(View.VISIBLE);
        EspressoIdlingResource.decrement();
    }

    @Override
    public void showResult(Result result) {
        submitBT.setEnabled(true);
        validTV.setText(result.isValid());
        costTV.setText(String.valueOf(result.getCost()));
        pathTV.setText(result.getPath());
    }

    @OnClick(R.id.submit) void calculate() {
        EspressoIdlingResource.increment();
        submitBT.setEnabled(false);
        resetBT.setEnabled(true);
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
            Log.d(TAG, "parseInput: rows " + rowCount);
            int columnCount = rows[0].split(COLS_DELIMITER).length;
            input = new Object[rowCount][columnCount];
            for(int row = 0; row < rowCount; row++) {
                String[] items = rows[row].split(COLS_DELIMITER);
                for(int col = 0; col < columnCount; col++) {
                    input[row][col] = items[col];
                    Log.d(TAG, "parseInput: " + items[col]);
                }
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

    private void initViews() {
        inputET.setRawInputType(Configuration.KEYBOARD_QWERTY);
    }
}
