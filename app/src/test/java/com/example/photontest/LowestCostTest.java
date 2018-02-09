package com.example.photontest;

import com.example.photontest.model.LowestCost;
import com.example.photontest.model.Result;
import com.example.photontest.util.Constants.ResultCode;
import com.example.photontest.util.Constants.Samples;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LowestCostTest {

    private LowestCost lowestCost;
    private Result result;

    @Before
    public void init() {
        lowestCost = new LowestCost();
        result = null;
    }

    @Test
    public void testSample2() {
        result = lowestCost.calculateLowestCost(Samples.SAMPLE_2_INPUT);
        assertEquals(Samples.SAMPLE_2_VALID, result.isValid());
        assertEquals(Samples.SAMPLE_2_COST, result.getCost());
        assertEquals(Samples.SAMPLE_2_PATH, result.getPath());
    }

    @Test
    public void testSample3() {
        result = lowestCost.calculateLowestCost(Samples.SAMPLE_3_INPUT);
        assertEquals(Samples.SAMPLE_3_VALID, result.isValid());
        assertEquals(Samples.SAMPLE_3_COST, result.getCost());
        assertEquals(Samples.SAMPLE_3_PATH, result.getPath());
    }

    @Test
    public void testSample4() {
        result = lowestCost.calculateLowestCost(Samples.SAMPLE_4_INPUT);
        assertEquals(Samples.SAMPLE_4_VALID, result.isValid());
        assertEquals(Samples.SAMPLE_4_COST, result.getCost());
        assertEquals(Samples.SAMPLE_4_PATH, result.getPath());
    }

    @Test
    public void testSample5() {
        result = lowestCost.calculateLowestCost(Samples.SAMPLE_5_INPUT);
        assertEquals(Samples.SAMPLE_5_VALID, result.isValid());
        assertEquals(Samples.SAMPLE_5_COST, result.getCost());
        assertEquals(Samples.SAMPLE_5_PATH, result.getPath());
    }

    @Test
    public void testSample6_badInput() {
        result = lowestCost.calculateLowestCost(Samples.SAMPLE_6_INPUT);
        assertEquals(ResultCode.ERROR_INPUT, result.getErrorCode());
    }

    @Test
    public void testSample8() {
        result = lowestCost.calculateLowestCost(Samples.SAMPLE_8_INPUT);
        assertEquals(Samples.SAMPLE_8_VALID, result.isValid());
        assertEquals(Samples.SAMPLE_8_COST, result.getCost());
        assertEquals(Samples.SAMPLE_8_PATH, result.getPath());
    }

    @Test
    public void testSample9() {
        result = lowestCost.calculateLowestCost(Samples.SAMPLE_9_INPUT);
        assertEquals(Samples.SAMPLE_9_VALID, result.isValid());
        assertEquals(Samples.SAMPLE_9_COST, result.getCost());
        assertEquals(Samples.SAMPLE_9_PATH, result.getPath());
    }

    @Test
    public void testSample10() {
        result = lowestCost.calculateLowestCost(Samples.SAMPLE_10_INPUT);
        assertEquals(Samples.SAMPLE_10_VALID, result.isValid());
        assertEquals(Samples.SAMPLE_10_COST, result.getCost());
        assertEquals(Samples.SAMPLE_10_PATH, result.getPath());
    }

    @Test
    public void testSample11() {
        result = lowestCost.calculateLowestCost(Samples.SAMPLE_11_INPUT);
        assertEquals(Samples.SAMPLE_11_VALID, result.isValid());
        assertEquals(Samples.SAMPLE_11_COST, result.getCost());
        assertEquals(Samples.SAMPLE_11_PATH, result.getPath());
    }

    @Test
    public void testSample12() {
        result = lowestCost.calculateLowestCost(Samples.SAMPLE_12_INPUT);
        assertEquals(Samples.SAMPLE_12_VALID, result.isValid());
        assertEquals(Samples.SAMPLE_12_COST, result.getCost());
        assertEquals(Samples.SAMPLE_12_PATH, result.getPath());
    }

    @Test
    public void testSample13() {
        result = lowestCost.calculateLowestCost(Samples.SAMPLE_13_INPUT);
        assertEquals(Samples.SAMPLE_13_VALID, result.isValid());
        assertEquals(Samples.SAMPLE_13_COST, result.getCost());
        assertEquals(Samples.SAMPLE_13_PATH, result.getPath());
    }

    @After
    public void tearDown() {
        lowestCost = null;
        result = null;
    }

}
