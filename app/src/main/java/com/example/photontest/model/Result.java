package com.example.photontest.model;

import java.util.Arrays;

public class Result {
    private int cost;
    private int[] path;
    private boolean isValid;
    private int errorCode;

    public Result(int errorCode) {
        this.errorCode = errorCode;
    }

    public Result(int cost, int[] path, boolean isValid) {
        this.cost = cost;
        this.path = path;
        this.isValid = isValid;
    }

    public int getCost() {
        return cost;
    }

    public String getPath() {
        if(path != null) {
            int j = 0;
            for( int i=0;  i<path.length;  i++ ) {
                if (path[i] != 0)
                    path[j++] = path[i];
            }
            int [] newArray = new int[j];
            System.arraycopy(path, 0, newArray, 0, j );
            return Arrays.toString(newArray);
        } else {
            return "[]";
        }
    }

    public String isValid() {
        return isValid ? "YES" : "NO";
    }

    public int getErrorCode() {
        return errorCode;
    }

}
