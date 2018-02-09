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
        Result result = lowestCost.calculateLowestCost(Samples.SAMPLE_2_INPUT);
        assertEquals(Samples.SAMPLE_2_VALID, result.isValid());
        assertEquals(Samples.SAMPLE_2_COST, result.getCost());
        assertEquals(Samples.SAMPLE_2_PATH, result.getPath());
    }

    @Test
    public void testSample3() {
        Result result = lowestCost.calculateLowestCost(Samples.SAMPLE_3_INPUT);
        assertEquals(Samples.SAMPLE_3_VALID, result.isValid());
        assertEquals(Samples.SAMPLE_3_COST, result.getCost());
        assertEquals(Samples.SAMPLE_3_PATH, result.getPath());
    }

    @Test
    public void testSample4() {
        Result result = lowestCost.calculateLowestCost(Samples.SAMPLE_4_INPUT);
        assertEquals(Samples.SAMPLE_4_VALID, result.isValid());
        assertEquals(Samples.SAMPLE_4_COST, result.getCost());
        assertEquals(Samples.SAMPLE_4_PATH, result.getPath());
    }

    @Test
    public void testSample5() {
        Result result = lowestCost.calculateLowestCost(Samples.SAMPLE_5_INPUT);
        assertEquals(Samples.SAMPLE_5_VALID, result.isValid());
        assertEquals(Samples.SAMPLE_5_COST, result.getCost());
        assertEquals(Samples.SAMPLE_5_PATH, result.getPath());
    }

    @Test
    public void testSample6_badInput() {
        Result result = lowestCost.calculateLowestCost(Samples.SAMPLE_6_INPUT);
        assertEquals(ResultCode.ERROR_INPUT, result.getErrorCode());
    }

    @Test
    public void testSample7_noInputOrLessThanMinRows() {
        Result result = lowestCost.calculateLowestCost(Samples.SAMPLE_7_INPUT);
        assertEquals(ResultCode.ERROR_EMPTY, result.getErrorCode());
    }

    @Test
    public void testSample8() {
        Result result = lowestCost.calculateLowestCost(Samples.SAMPLE_8_INPUT);
        assertEquals(Samples.SAMPLE_8_VALID, result.isValid());
        assertEquals(Samples.SAMPLE_8_COST, result.getCost());
        assertEquals(Samples.SAMPLE_8_PATH, result.getPath());
    }

    @Test
    public void testSample9() {
        Result result = lowestCost.calculateLowestCost(Samples.SAMPLE_9_INPUT);
        assertEquals(Samples.SAMPLE_9_VALID, result.isValid());
        assertEquals(Samples.SAMPLE_9_COST, result.getCost());
        assertEquals(Samples.SAMPLE_9_PATH, result.getPath());
    }

    @Test
    public void testSample10() {
        Result result = lowestCost.calculateLowestCost(Samples.SAMPLE_10_INPUT);
        assertEquals(Samples.SAMPLE_10_VALID, result.isValid());
        assertEquals(Samples.SAMPLE_10_COST, result.getCost());
        assertEquals(Samples.SAMPLE_10_PATH, result.getPath());
    }

    @Test
    public void testSample11() {
        Result result = lowestCost.calculateLowestCost(Samples.SAMPLE_11_INPUT);
        assertEquals(Samples.SAMPLE_11_VALID, result.isValid());
        assertEquals(Samples.SAMPLE_11_COST, result.getCost());
        assertEquals(Samples.SAMPLE_11_PATH, result.getPath());
    }

    @Test
    public void testSample13() {
        Result result = lowestCost.calculateLowestCost(Samples.SAMPLE_13_INPUT);
        assertEquals(Samples.SAMPLE_13_VALID, result.isValid());
        assertEquals(Samples.SAMPLE_13_COST, result.getCost());
        assertEquals(Samples.SAMPLE_13_PATH, result.getPath());
    }

    // TODO - Refactor to presentation validation
//    @Test
//    public void testSample14_lessThanMinCols() {
//        Result result = lowestCost.calculateLowestCost(Samples.SAMPLE_14_INPUT);
//        assertEquals(ResultCode.ERROR_COLS, result.getErrorCode());
//    }

    // TODO - Refactor to presentation validation
//    @Test
//    public void testSample15_moreThanMaxCols() {
//        Result result = lowestCost.calculateLowestCost(Samples.SAMPLE_15_INPUT);
//        assertEquals(ResultCode.ERROR_COLS, result.getErrorCode());
//    }

    // TODO - Refactor to presentation validation
//    @Test
//    public void testSample16_moreThanMaxRows() {
//        Result result = lowestCost.calculateLowestCost(Samples.SAMPLE_16_INPUT);
//        assertEquals(ResultCode.ERROR_ROWS, result.getErrorCode());
//    }

}
