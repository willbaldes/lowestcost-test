package com.example.photontest.helper;

import android.content.Context;

import com.example.photontest.R;
import com.example.photontest.util.Constants;

import javax.inject.Inject;

public class ResourceHelper {

    private Context context;

    @Inject
    public ResourceHelper(Context context) {
        this.context = context;
    }

    public String getStringError(int errorCode) {
        String error;
        switch (errorCode) {
            case Constants.ResultCode.ERROR_COLS:
                error = context.getResources().getString(R.string.error_cols);
                break;
            case Constants.ResultCode.ERROR_ROWS:
                error = context.getResources().getString(R.string.error_rows);
                break;
            case Constants.ResultCode.ERROR_EMPTY:
                error = context.getResources().getString(R.string.error_empty);
                break;
            case Constants.ResultCode.ERROR_INPUT:
                error = context.getResources().getString(R.string.error_input);
                break;
            default:
                error = context.getResources().getString(R.string.error_state);
                break;
        }
        return error;
    }

}
