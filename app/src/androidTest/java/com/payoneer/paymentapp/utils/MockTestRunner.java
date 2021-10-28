package com.payoneer.paymentapp.utils;

import android.app.Application;
import android.content.Context;

import androidx.test.runner.AndroidJUnitRunner;

import dagger.hilt.android.testing.HiltTestApplication;

public class MockTestRunner extends AndroidJUnitRunner {
    @Override
    public Application newApplication(ClassLoader classLoader, String className, Context context)
            throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        return super.newApplication(classLoader, HiltTestApplication.class.getName(), context);
    }
}
