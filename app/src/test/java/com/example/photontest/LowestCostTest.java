package com.example.photontest;

import com.example.photontest.model.LowestCost;
import com.example.photontest.model.Result;
import com.example.photontest.util.Constants.Samples;
import com.example.photontest.util.Constants.ResultCode;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LowestCostTest {

    private LowestCost lowestCost;

    @Before
    public void init() {
        lowestCost = new LowestCost();
    }

    @Test
    public void testSample2() {
        Result result = lowestCost.calculateLowestCost(Samples.SAMPLE_1_INPUT);
        assertEquals(Samples.SAMPLE_1_VALID, result.isValid());
        assertEquals(Samples.SAMPLE_1_COST, result.getCost());
        assertEquals(Samples.SAMPLE_1_PATH, result.getPath());
    }

    @Test
    public void testSample6() {
        Result result = lowestCost.calculateLowestCost(Samples.SAMPLE_6_INPUT);
        assertEquals(ResultCode.ERROR_INPUT, result.getErrorCode());
    }

    @Test
    public void testSample7_NoInputOrLessThanMinRows() {
        Result result = lowestCost.calculateLowestCost(Samples.SAMPLE_7_INPUT);
        assertEquals(ResultCode.ERROR_EMPTY, result.getErrorCode());
    }

    @Test
    public void testSample14_lessThanMinCols() {
        Result result = lowestCost.calculateLowestCost(Samples.SAMPLE_14_INPUT);
        assertEquals(ResultCode.ERROR_COLS, result.getErrorCode());
    }

    @Test
    public void testSample15_moreThanMaxCols() {
        Result result = lowestCost.calculateLowestCost(Samples.SAMPLE_15_INPUT);
        assertEquals(ResultCode.ERROR_COLS, result.getErrorCode());
    }

}
