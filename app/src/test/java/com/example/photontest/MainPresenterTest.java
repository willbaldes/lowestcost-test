package com.example.photontest;

import com.example.photontest.helper.ResourceHelper;
import com.example.photontest.model.LowestCost;
import com.example.photontest.model.Result;
import com.example.photontest.ui.MainContract;
import com.example.photontest.ui.MainPresenter;
import com.example.photontest.util.Constants.Samples;
import com.example.photontest.util.Constants.ResultCode;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MainPresenterTest {

    @InjectMocks MainPresenter presenter;

    @Mock MainContract.View mainViewMock;
    @Mock LowestCost lowestCostMock;
    @Mock ResourceHelper resourceHelperMock;

    private Result testResult;

    @Before
    public void init() {
        presenter.bind();
    }

    @Test
    public void testSuccessValidMatrix() {

    }

    @Test
    public void testSuccessInvalidMatrix(){

    }

    @Test
    public void testErrorInvalidInput() {
        testResult = new Result(ResultCode.ERROR_INPUT);
        when(lowestCostMock.calculateLowestCost(Samples.SAMPLE_6_INPUT)).thenReturn(testResult);
        when(resourceHelperMock.getStringError(testResult.getErrorCode())).thenReturn("INPUT");
        presenter.calculateLowestCost(Samples.SAMPLE_6_INPUT);
        verify(mainViewMock).showError("INPUT");
    }

    @Test
    public void testErrorEmptyInput() {
        testResult = new Result(ResultCode.ERROR_EMPTY);
        when(lowestCostMock.calculateLowestCost(Samples.SAMPLE_7_INPUT)).thenReturn(testResult);
        when(resourceHelperMock.getStringError(ResultCode.ERROR_EMPTY)).thenReturn("EMPTY");
        presenter.calculateLowestCost(Samples.SAMPLE_7_INPUT);
        verify(mainViewMock).showError("EMPTY");
    }

    @Test
    public void testErrorInvalidInputRows() {

    }

    @Test
    public void testErrorInvalidInputColsLessThanMin() {

    }

    @Test
    public void testErrorInvalidInputColsMoreThanMax() {

    }

    @After
    public void tearDown() {
        presenter.unbind();
        testResult = null;
    }

}
