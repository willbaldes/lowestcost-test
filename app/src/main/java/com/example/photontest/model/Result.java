package com.example.photontest.model;

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

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int[] getPath() {
        return path;
    }

    public void setPath(int[] path) {
        this.path = path;
    }

    public String isValid() {
        return isValid ? "YES" : "NO";
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }
}
