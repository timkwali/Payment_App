package com.payoneer.paymentapp.utils;

import androidx.test.platform.app.InstrumentationRegistry;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;

import kotlin.io.TextStreamsKt;

public class FileReader {
    public static String readStringFromFile(String fileName) throws IOException {
        if(fileName == null) return "";
        try {
            InputStream inputStream = (InstrumentationRegistry.getInstrumentation().getTargetContext().getApplicationContext())
                    .getAssets().open(fileName);
            StringBuilder builder = new StringBuilder();
            InputStreamReader reader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
            TextStreamsKt.readLines((Reader)reader).forEach(s -> builder.append(s));
            return builder.toString();
        } catch (IOException exception) {
            throw exception;
        }
    }
}
