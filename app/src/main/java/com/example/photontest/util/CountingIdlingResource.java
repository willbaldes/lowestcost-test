package com.example.photontest.util;

import android.support.test.espresso.IdlingResource;

import java.util.concurrent.atomic.AtomicInteger;

public class CountingIdlingResource implements IdlingResource {

    private String resourceName;
    private AtomicInteger counter = new AtomicInteger(0);
    private volatile ResourceCallback resourceCallback;

    CountingIdlingResource(String resourceName) {
        this.resourceName = resourceName;
    }

    @Override
    public String getName() {
        return resourceName;
    }

    @Override
    public boolean isIdleNow() {
        return counter.get() == 0 ;
    }

    @Override
    public void registerIdleTransitionCallback(ResourceCallback callback) {
        resourceCallback = callback;
    }

    void increment() {
        counter.getAndIncrement();
    }

    void decrement() {
        int countValue = counter.decrementAndGet();

        if(countValue == 0) {
            if(resourceCallback != null) {
                resourceCallback.onTransitionToIdle();
            }
        }

        if(countValue < 0) {
            // corrupt counter
            throw new IllegalArgumentException("Corrupted counter");
        }
    }

}
