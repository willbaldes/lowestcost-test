package com.example.photontest;

import com.example.photontest.model.LowestCost;
import com.example.photontest.model.Result;
import com.example.photontest.util.Constants;

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
        Result result = lowestCost.calculateLowestCost(Constants.SAMPLE_1_INPUT);
        assertEquals(Constants.SAMPLE_1_VALID, result.isValid());
        assertEquals(Constants.SAMPLE_1_COST, result.getCost());
        assertEquals(Constants.SAMPLE_1_PATH, result.getPath());
    }
}
