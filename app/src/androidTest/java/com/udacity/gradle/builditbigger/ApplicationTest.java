package com.udacity.gradle.builditbigger;

import android.test.AndroidTestCase;
import android.test.UiThreadTest;
import android.text.TextUtils;

import java.util.concurrent.CountDownLatch;

public class ApplicationTest extends AndroidTestCase implements SyncInterface {

    private CountDownLatch countDownLatch;
    private String requestResponse;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        requestResponse = null;
        countDownLatch = new CountDownLatch(1);
    }

    @UiThreadTest
    public void testEndpointsAsyncTask() throws InterruptedException {
        EndpointsAsyncTask endpointsAsyncTask = new EndpointsAsyncTask();
        endpointsAsyncTask.listener = this;
        endpointsAsyncTask.execute();

        countDownLatch.await();

        assertFalse(TextUtils.isEmpty(requestResponse));
    }

    @Override
    public void onTaskCompleted(String asyncResult){
        countDownLatch.countDown();
        requestResponse = asyncResult;
    }
}