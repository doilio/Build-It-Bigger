package com.udacity.gradle.builditbigger;

import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(MainActivity.class);

    private CountDownLatch countDownLatch = new CountDownLatch(1);


    /**
     * Test Passes if String is not Null and Not Empty
     */
    @Test
    public void testResultEmpty() throws InterruptedException, ExecutionException {
        EndpointsAsyncTask endpointsAsyncTask = new EndpointsAsyncTask();
        endpointsAsyncTask.execute();

        countDownLatch.countDown();

        countDownLatch.await();

        String joke = endpointsAsyncTask.get();

        assertNotNull(joke); // Not null

        assertFalse(joke.isEmpty()); // not Empty
    }

}