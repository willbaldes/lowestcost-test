package com.example.photontest;

import com.example.photontest.model.LowestCost;
import com.example.photontest.ui.MainContract;
import com.example.photontest.ui.MainPresenter;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class MainPresenterTest {

    @InjectMocks
    MainPresenter presenter;

    @Mock
    MainContract.View mainViewMock;

    @Mock
    LowestCost lowestCostMock;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSuccessValidMatrix() {

    }

    @Test
    public void testSuccessInvalidMatrix(){

    }

    @Test
    public void testErrorInvalidInput() {

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

}
