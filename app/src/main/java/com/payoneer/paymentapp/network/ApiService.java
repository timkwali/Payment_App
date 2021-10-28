package com.payoneer.paymentapp.network;

import com.payoneer.paymentapp.model.PaymentsResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("listresult.json")
    Call<PaymentsResponse> getPayments();
}
