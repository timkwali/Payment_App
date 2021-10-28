package com.payoneer.paymentapp.di;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.components.SingletonComponent;
import dagger.hilt.testing.TestInstallIn;
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import retrofit2.Converter;
import retrofit2.Retrofit;

@Module
@TestInstallIn(
        components = SingletonComponent.class,
        replaces = RetrofitModule.class
)
public class TestRetrofitModule {
    @Provides
    @Singleton
    public static Retrofit provideRetrofitService(Converter.Factory converterFactory) {
        return new Retrofit.Builder()
                .baseUrl("http://127.0.0.1:8080")
                .addConverterFactory(converterFactory)
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build();
    }
}
