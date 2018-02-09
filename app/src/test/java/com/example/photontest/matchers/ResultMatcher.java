package com.example.photontest.matchers;

import com.example.photontest.model.Result;
import org.mockito.ArgumentMatcher;


public class ResultMatcher implements ArgumentMatcher<Result> {

    private final Result expected;

    public ResultMatcher(Result expected) {
        this.expected = expected;
    }

    @Override
    public boolean matches(Result actual) {
        return actual.getCost() == expected.getCost() &&
                actual.getPath().equals(expected.getPath()) &&
                actual.isValid().equals(expected.isValid());
    }

}
