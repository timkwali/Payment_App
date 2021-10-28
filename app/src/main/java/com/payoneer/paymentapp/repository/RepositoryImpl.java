package com.payoneer.paymentapp.repository;

import com.payoneer.paymentapp.model.PaymentsResponse;
import com.payoneer.paymentapp.network.ApiService;
import com.payoneer.paymentapp.network.Resource;

import javax.inject.Inject;

import retrofit2.Call;


public class RepositoryImpl implements Repository {
    private final ApiService apiService;
    private Resource<PaymentsResponse> resource;
    @Inject
    public RepositoryImpl (ApiService apiService) {
        this.apiService = apiService;
    }

    @Override
    public Call<PaymentsResponse> getPayments() {
        return apiService.getPayments();
    }
}
