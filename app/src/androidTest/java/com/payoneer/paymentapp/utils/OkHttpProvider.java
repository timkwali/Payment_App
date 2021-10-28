package com.payoneer.paymentapp.utils;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

public class OkHttpProvider {
    // Timeout for the network requests
    private static Long REQUEST_TIMEOUT = 3L;
    private static OkHttpClient okHttpClient = null;

    public static OkHttpClient getOkHttpClient() {
        if(okHttpClient == null) {
            OkHttpClient okHttpClient = new OkHttpClient.Builder()
                    .readTimeout(REQUEST_TIMEOUT, TimeUnit.SECONDS)
                    .connectTimeout(REQUEST_TIMEOUT, TimeUnit.SECONDS)
                    .build();
            OkHttpProvider.okHttpClient = okHttpClient;
            return okHttpClient;
        } else {
            return okHttpClient;
        }
    }
}
