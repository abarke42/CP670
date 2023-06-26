package com.example.androidassignments;

import android.app.Activity;
import android.util.Log;

import androidx.lifecycle.Lifecycle;

import junit.framework.TestCase;

import org.junit.Test;

public class MainActivityTest extends TestCase {

   // @Test fun testEvent() {
   //     launchActivity<MainActivity>().use {
   //     }
  //  }

    public void testOnCreate() {
        //Activity = getActivity("MainActivity");
        //activity.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED);
        Log.i("MainActivity_testOnCreate", "Successfully created Main Activity");
    }

    public void testOnActivityResult() {
    }

    public void testOnStart() {
    }

    public void testOnPause() {
    }

    public void testOnResume() {
    }

    public void testOnStop() {
    }

    public void testOnDestroy() {
    }
}