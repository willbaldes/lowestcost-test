package com.example.photontest.util;

public class EspressoIdlingResource {

    private static final String RESOURCE = "COUNTER";

    private static CountingIdlingResource countingIdlingResource = new CountingIdlingResource(RESOURCE);

    public static void increment() {
        countingIdlingResource.increment();
    }

    public static void decrement() {
        countingIdlingResource.decrement();
    }

    public static CountingIdlingResource getCountingIdlingResource() {
        return countingIdlingResource;
    }

}
