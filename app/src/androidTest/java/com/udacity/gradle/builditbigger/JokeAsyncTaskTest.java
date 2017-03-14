package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.util.Pair;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import static android.support.test.InstrumentationRegistry.getContext;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.fail;

/**
 * Created by toddskinner on 3/14/17.
 * Source: https://discussions.udacity.com/t/writing-tests-for-async-task/25482/9
 */

@RunWith(AndroidJUnit4.class)
public class JokeAsyncTaskTest implements AsyncResponse {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class);

    @Test
    public void testAsyncTask() {
        AsyncResponse delegate = null;
        EndpointsAsyncTask asyncTask = new EndpointsAsyncTask();
        asyncTask.delegate = this;
        asyncTask.execute(new Pair<Context, String>(getContext(), ""));
        try {
            String joke = asyncTask.get(30, TimeUnit.SECONDS);
            assertNotNull(joke);
            assertFalse(joke.length() == 0);
        } catch (InterruptedException e) {
            fail("Interruption Exception");
        } catch (ExecutionException e) {
            fail("Execution Exception");
        } catch (TimeoutException e) {
            fail("Timed out");
        }
    }

    @Override
    public void processFinish(String output) {

    }
}
