package com.payoneer.paymentapp;


import static org.junit.Assert.assertEquals;

import androidx.annotation.Nullable;
import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.Observer;

import com.google.gson.Gson;
import com.payoneer.paymentapp.utils.LiveDataTestUtil;
import com.payoneer.paymentapp.utils.TestUtils;
import com.payoneer.paymentapp.model.PaymentsResponse;
import com.payoneer.paymentapp.network.Resource;
import com.payoneer.paymentapp.repository.Repository;
import com.payoneer.paymentapp.utils.Constants;
import com.payoneer.paymentapp.viewmodel.PaymentsViewModel;

import org.junit.After;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.IOException;

import retrofit2.Call;

@RunWith(MockitoJUnitRunner.class)
public class PaymentsViewModelTest {
    @Rule
    public TestRule rule = new InstantTaskExecutorRule();
    private PaymentsViewModel paymentsViewModel;
    private final LiveDataTestUtil<Resource<PaymentsResponse>> liveDataTestUtil = new LiveDataTestUtil<>();
    private Observer<Resource<PaymentsResponse>> observer;
    private Resource<PaymentsResponse> resource;

    String responseString = TestUtils.PAYMENT_RESPONSE;
    Gson gson = new Gson();
    PaymentsResponse paymentsResponse = gson.fromJson(responseString, PaymentsResponse.class);


    private void setUp(int code, @Nullable Object body, String type) {
        Call fakeCall;
        if(type.equals(Constants.SUCCESS)) {
            fakeCall = TestUtils.fakeSuccessCall(body, code);
        } else {
            fakeCall = TestUtils.fakeErrorCall(body, code);
        }

        Repository repository = Mockito.mock(Repository.class);
        Mockito.when(repository.getPayments()).thenReturn(fakeCall);
        paymentsViewModel = new PaymentsViewModel(repository);
        observer = paymentsResponseResource -> {};
        paymentsViewModel.paymentsList().observeForever(observer);
    }

    @After
    public void tearDown() {
        paymentsViewModel.paymentsList().removeObserver(observer);
    }

    @Test
    public void response_returns_successStatus() throws InterruptedException {
        setUp(Constants.successCode, paymentsResponse, Constants.SUCCESS);

        paymentsViewModel.getPayments();
        resource = liveDataTestUtil.getValue(paymentsViewModel.paymentsList());

        Assert.assertEquals(Resource.Status.SUCCESS, resource.status);
    }

    @Test
    public void response_returns_correctData() throws InterruptedException {
        setUp(Constants.successCode, paymentsResponse, Constants.SUCCESS);

        paymentsViewModel.getPayments();
        resource = liveDataTestUtil.getValue(paymentsViewModel.paymentsList());

        Assert.assertEquals("American Express", resource.data.getNetworks().getApplicable().get(0).getLabel());
    }

    @Test
    public void emptyResponse_returns_emptyResultMessage() throws InterruptedException, IOException {
        setUp(Constants.emptyResourceCode, null, Constants.SUCCESS);

        paymentsViewModel.getPayments();
        resource = liveDataTestUtil.getValue(paymentsViewModel.paymentsList());

        assertEquals(Constants.emptyResultMessage, resource.message);
    }

    @Test
    public void noResourceResponse_returns_noResourceMessage() throws InterruptedException, IOException {
        setUp(Constants.noResourceCode, null, Constants.ERROR);

        paymentsViewModel.getPayments();
        resource = liveDataTestUtil.getValue(paymentsViewModel.paymentsList());

        assertEquals(Constants.noResourceMessage, resource.message);
    }

    @Test
    public void responseTimeout_returns_timeoutMessage() throws InterruptedException, IOException {
        setUp(Constants.timeoutCode, null, Constants.ERROR);

        paymentsViewModel.getPayments();
        resource = liveDataTestUtil.getValue(paymentsViewModel.paymentsList());

        assertEquals(Constants.timeoutMessage, resource.message);
    }

    @Test
    public void serverError_returns_serverMessage() throws InterruptedException, IOException {
        setUp(Constants.serverErrorCode, null, Constants.ERROR);

        paymentsViewModel.getPayments();
        resource = liveDataTestUtil.getValue(paymentsViewModel.paymentsList());

        assertEquals(Constants.serverErrorMessage, resource.message);
    }

    @Test
    public void otherError_returns_errorMessage() throws InterruptedException, IOException {
        setUp(504, null, Constants.ERROR);

        paymentsViewModel.getPayments();
        resource = liveDataTestUtil.getValue(paymentsViewModel.paymentsList());

        assertEquals(Constants.errorMessage, resource.message);
    }
}
