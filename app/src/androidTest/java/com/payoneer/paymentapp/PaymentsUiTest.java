package com.payoneer.paymentapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.IdlingRegistry;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.jakewharton.espresso.OkHttp3IdlingResource;
import com.payoneer.paymentapp.ui.MainActivity;
import com.payoneer.paymentapp.utils.Constants;
import com.payoneer.paymentapp.utils.FileReader;
import com.payoneer.paymentapp.utils.OkHttpProvider;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;
import java.util.Objects;

import dagger.hilt.android.testing.HiltAndroidRule;
import dagger.hilt.android.testing.HiltAndroidTest;
import okhttp3.mockwebserver.Dispatcher;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;

@RunWith(AndroidJUnit4.class)
@HiltAndroidTest
public class PaymentsUiTest {
    @Rule
    public HiltAndroidRule hiltAndroidRule = new HiltAndroidRule(this);
    private MockWebServer mockWebServer = new MockWebServer();

    @Before
    public void setup() throws IOException {
        mockWebServer.start(8080);
        IdlingRegistry.getInstance().register(OkHttp3IdlingResource.create(
                "okhttp",
                OkHttpProvider.getOkHttpClient()
        ));
    }

    @After
    public void teardown() throws IOException {
        mockWebServer.shutdown();
    }


    private void setUpMockWebServer(int code, @Nullable String body) {
        mockWebServer.setDispatcher(new Dispatcher() {
            @NonNull
            @Override
            public MockResponse dispatch(@NonNull RecordedRequest recordedRequest) {
                MockResponse mockResponse = null;
                try {
                    mockResponse = new MockResponse()
                            .setResponseCode(code)
                            .setBody(Objects.requireNonNull(FileReader.readStringFromFile(body)));
                } catch (IOException exception) {
                    exception.printStackTrace();
                }
                return mockResponse;
            }
        });
    }

    @Test
    public void successfulResponse_shows_correctSnackBar_fromRecyclerView() {
        setUpMockWebServer(Constants.successCode, "success_response.json");

        ActivityScenario.launch(MainActivity.class);

        Espresso.onView(ViewMatchers.withId(R.id.home_fragment))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
        Espresso.onView(ViewMatchers.withId(R.id.payments_rv))
                .check(ViewAssertions.matches(ViewMatchers.withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)))
                .perform(RecyclerViewActions.actionOnItemAtPosition(0, ViewActions.click()));
        Espresso.onView(ViewMatchers.withId(com.google.android.material.R.id.snackbar_text))
                .check(ViewAssertions.matches(ViewMatchers.withText("American Express")));
    }

    @Test
    public void emptyResponse_returns_emptyResultSnackBar() {
        setUpMockWebServer(Constants.emptyResourceCode, null);

        ActivityScenario.launch(MainActivity.class);

        Espresso.onView(ViewMatchers.withId(R.id.home_fragment))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
        Espresso.onView(ViewMatchers.withId(com.google.android.material.R.id.snackbar_text))
                .check(ViewAssertions.matches(ViewMatchers.withText(Constants.errorHeading + "\n"+ Constants.emptyResultMessage)));
    }

    @Test
    public void noResourceResponse_returns_noResourceSnackBar() {
        setUpMockWebServer(Constants.noResourceCode, null);

        ActivityScenario.launch(MainActivity.class);

        Espresso.onView(ViewMatchers.withId(R.id.home_fragment))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
        Espresso.onView(ViewMatchers.withId(com.google.android.material.R.id.snackbar_text))
                .check(ViewAssertions.matches(ViewMatchers.withText(Constants.errorHeading + "\n"+ Constants.noResourceMessage)));
    }

    @Test
    public void responseTimeout_returns_timeoutSnackBar() {
        setUpMockWebServer(Constants.timeoutCode, null);

        ActivityScenario.launch(MainActivity.class);

        Espresso.onView(ViewMatchers.withId(R.id.home_fragment))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
        Espresso.onView(ViewMatchers.withId(com.google.android.material.R.id.snackbar_text))
                .check(ViewAssertions.matches(ViewMatchers.withText(Constants.errorHeading + "\n"+ Constants.timeoutMessage)));
    }

    @Test
    public void serverError_returns_serverErrorSnackBar() {
        setUpMockWebServer(Constants.serverErrorCode, null);

        ActivityScenario.launch(MainActivity.class);

        Espresso.onView(ViewMatchers.withId(R.id.home_fragment))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
        Espresso.onView(ViewMatchers.withId(com.google.android.material.R.id.snackbar_text))
                .check(ViewAssertions.matches(ViewMatchers.withText(Constants.errorHeading + "\n"+ Constants.serverErrorMessage)));
    }

    @Test
    public void otherError_returns_errorMessageSnackBar() {
        setUpMockWebServer(504, null);

        ActivityScenario.launch(MainActivity.class);

        Espresso.onView(ViewMatchers.withId(R.id.home_fragment))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
        Espresso.onView(ViewMatchers.withId(com.google.android.material.R.id.snackbar_text))
                .check(ViewAssertions.matches(ViewMatchers.withText(Constants.errorHeading + "\n"+ Constants.errorMessage)));
    }

    @Test
    public void swipeToRefresh_refreshesTheApp() {
        setUpMockWebServer(Constants.successCode, "success_response.json");

        ActivityScenario.launch(MainActivity.class);

        Espresso.onView(ViewMatchers.withId(R.id.home_fragment))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
        Espresso.onView(ViewMatchers.withId(R.id.payments_rv))
                .check(ViewAssertions.matches(ViewMatchers.withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));

        Espresso.onView(ViewMatchers.withId(R.id.swipe_refresh))
                .perform(ViewActions.swipeDown());

        Espresso.onView(ViewMatchers.withId(R.id.payments_rv))
                .perform(RecyclerViewActions.actionOnItemAtPosition(0, ViewActions.click()));
        Espresso.onView(ViewMatchers.withId(com.google.android.material.R.id.snackbar_text))
                .check(ViewAssertions.matches(ViewMatchers.withText("American Express")));
    }
}
