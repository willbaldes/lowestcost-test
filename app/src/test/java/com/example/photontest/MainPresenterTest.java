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
        testResult = new Result();
    }

    @Test
    public void testSuccessValidMatrix() {

    }

    @Test
    public void testSuccessInvalidMatrix(){

    }

    @Test
    public void testErrorInvalidInput() {
        testResult.setErrorCode(ResultCode.ERROR_INPUT);
        when(resourceHelperMock.getStringError(testResult.getErrorCode())).thenReturn("INPUT");
        presenter.calculateLowestCost(Samples.SAMPLE_6_INPUT);
        verify(mainViewMock).showError("INPUT");
    }

    @Test
    public void testErrorEmptyInput() {
        testResult.setErrorCode(ResultCode.ERROR_EMPTY);
        when(resourceHelperMock.getStringError(ResultCode.ERROR_EMPTY)).thenReturn("EMPTY");
        presenter.calculateLowestCost(Samples.SAMPLE_7_INPUT);
        verify(mainViewMock).showError("EMPTY");
    }

    @Test
    public void testErrorInvalidInputRows() {
        testResult.setErrorCode(ResultCode.ERROR_ROWS);
        when(resourceHelperMock.getStringError(testResult.getErrorCode())).thenReturn("ROWS");
        presenter.calculateLowestCost(Samples.SAMPLE_16_INPUT);
        verify(mainViewMock).showError("ROWS");
    }

    @Test
    public void testErrorInvalidInputColsLessThanMin() {
        testResult.setErrorCode(ResultCode.ERROR_COLS);
        when(resourceHelperMock.getStringError(testResult.getErrorCode())).thenReturn("COLS");
        presenter.calculateLowestCost(Samples.SAMPLE_14_INPUT);
        verify(mainViewMock).showError("COLS");
    }

    @Test
    public void testErrorInvalidInputColsMoreThanMax() {
        testResult.setErrorCode(ResultCode.ERROR_COLS);
        when(resourceHelperMock.getStringError(testResult.getErrorCode())).thenReturn("COLS");
        presenter.calculateLowestCost(Samples.SAMPLE_15_INPUT);
    }

    @After
    public void tearDown() {
        presenter.unbind();
        testResult = null;
    }

}
