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

        public static final Object[][] SAMPLE_2_INPUT = {
                {3, 4, 1, 2, 8, 6},
                {6, 1, 8, 2, 7, 4},
                {5, 9, 3, 9, 9, 5},
                {8, 4, 1, 3, 2, 6},
                {3, 7, 2, 1, 2, 3}
        };
        public static final String SAMPLE_2_VALID = "YES";
        public static final int SAMPLE_2_COST = 11;
        public static final String SAMPLE_2_PATH = "[1, 2, 1, 5, 4, 5]";

        public static final Object[][] SAMPLE_3_INPUT = {
                {19, 10, 19, 10, 19},
                {21, 23, 20, 19, 12},
                {20, 12, 20, 11, 10}
        };
        public static final String SAMPLE_3_VALID = "NO";
        public static final int SAMPLE_3_COST = 48;
        public static final String SAMPLE_3_PATH = "[1, 1, 1]";

        public static final Object[][] SAMPLE_4_INPUT = {
                {5, 8, 5, 3, 5}
        };
        public static final String SAMPLE_4_VALID = "YES";
        public static final int SAMPLE_4_COST = 26;
        public static final String SAMPLE_4_PATH = "[1, 1, 1, 1, 1]";

        public static final Object[][] SAMPLE_5_INPUT = {
                {5},
                {8},
                {5},
                {3},
                {5}
        };

        public static final String SAMPLE_5_VALID = "YES";
        public static final int SAMPLE_5_COST = 3;
        public static final String SAMPLE_5_PATH = "[4]";

        public static final Object[][] SAMPLE_6_INPUT = {
                {5, 4, "H", 2, 5},
                {8, "M", 7, 1, 6},
                {5, 7,   5, 3, 7}
        };

        public static final Object[][] SAMPLE_7_INPUT = null;

        public static final Object[][] SAMPLE_8_INPUT = {
                {69, 10, 19, 10, 19},
                {51, 23, 20, 19, 12},
                {60, 12, 20, 11, 10}
        };
        public static final String SAMPLE_8_VALID = "NO";
        public static final int SAMPLE_8_COST = 0;
        public static final String SAMPLE_8_PATH = "[]";

        public static final Object[][] SAMPLE_9_INPUT = {
                {60, 3, 3, 6},
                {6, 3, 7, 9},
                {5, 6, 8, 3}
        };
        public static final String SAMPLE_9_VALID = "YES";
        public static final int SAMPLE_9_COST = 14;
        public static final String SAMPLE_9_PATH = "[3, 2, 1, 3]";

        public static final Object[][] SAMPLE_10_INPUT = {
                {6,3,-5,9},
                {-5,2,4,10},
                {3,-2,6,10},
                {6,-1,-2,10}
        };
        public static final String SAMPLE_10_VALID = "YES";
        public static final int SAMPLE_10_COST = 0;
        public static final String SAMPLE_10_PATH = "[2, 3, 4, 1]";

        public static final Object[][] SAMPLE_14_INPUT = {
                {5, 4, "H"},
                {8, "M", 7},
                {5, 7,   5}
        };

        public static final Object[][] SAMPLE_15_INPUT = {
                {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}
        };

        public static final Object[][] SAMPLE_16_INPUT = {
                {1},
                {2},
                {3},
                {4},
                {5},
                {6},
                {7},
                {8},
                {9},
                {0},
                {1}
        };
    }
}
