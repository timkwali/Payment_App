package com.payoneer.paymentapp.viewmodel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.payoneer.paymentapp.model.PaymentsResponse;
import com.payoneer.paymentapp.network.Resource;
import com.payoneer.paymentapp.repository.Repository;
import com.payoneer.paymentapp.utils.Utils;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@HiltViewModel
public class PaymentsViewModel extends ViewModel {
    private final Repository repository;
    @Inject
    public PaymentsViewModel(Repository repository) { this.repository = repository; }

    private final MutableLiveData<Resource<PaymentsResponse>> _paymentsList = new MutableLiveData<Resource<PaymentsResponse>>();
    public LiveData<Resource<PaymentsResponse>> paymentsList() {
        return _paymentsList;
    }

    public void getPayments() {
        _paymentsList.setValue(Resource.loading(null));
        repository.getPayments().enqueue(new Callback<PaymentsResponse>() {
            @Override
            public void onResponse(Call<PaymentsResponse> call, Response<PaymentsResponse> response) {
                PaymentsResponse responseBody = response.body();
                int responseCode = response.code();
                Resource resource = Utils.getResource(responseCode, responseBody);
                _paymentsList.setValue(resource);
            }

            @Override
            public void onFailure(Call<PaymentsResponse> call, Throwable throwable) {
                Resource resource;
                String message = throwable.getMessage();
                if(message != null) {
                    Log.e("errorTag", "getPayments: " + message);
                    resource = Resource.error(message, throwable);
                } else {
                    resource = Resource.error("Check your network connection.", null);
                }
                _paymentsList.setValue(resource);
            }
        });
    }
}
