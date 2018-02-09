package com.example.photontest.util;

public final class Constants {

    public static class DomainSpecs {
        public static final int MIN_ROWS = 1;
        public static final int MAX_ROWS = 10;
        public static final int MIN_COLS = 5;
        public static final int MAX_COLS = 100;
        public static final int MAX_COST = 50;
    }

    public static class ResultCode {
        public static final int RESULT_OK = 0;
        public static final int ERROR_EMPTY = 1;
        public static final int ERROR_INPUT = 2;
        public static final int ERROR_ROWS = 3;
        public static final int ERROR_COLS = 4;
        public static final int ERROR_STATE = 5;
    }

    public static class Samples {
        public static final Object[][] SAMPLE_1_INPUT = {
                {3, 4, 1, 2, 8, 6},
                {6, 1, 8, 2, 7, 4},
                {5, 9, 3, 9, 9, 5},
                {8, 4, 1, 3, 2, 6},
                {3, 7, 2, 8, 6, 4}
        };
        public static final String SAMPLE_1_VALID = "YES";
        public static final int SAMPLE_1_COST = 16;
        public static final String SAMPLE_1_PATH = "[1, 2, 3, 4, 4, 5]";

        public static final Object[][] SAMPLE_6_INPUT = {
                {5, 4, "H", 2, 5},
                {8, "M", 7, 1, 6},
                {5, 7,   5, 3, 7}
        };
    }
}
