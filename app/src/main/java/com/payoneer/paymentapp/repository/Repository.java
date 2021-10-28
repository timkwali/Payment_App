package com.payoneer.paymentapp.repository;

import com.payoneer.paymentapp.model.PaymentsResponse;

import retrofit2.Call;

public interface Repository {
    Call<PaymentsResponse> getPayments();
}
