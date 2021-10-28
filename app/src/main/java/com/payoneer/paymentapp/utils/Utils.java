package com.payoneer.paymentapp.utils;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import android.view.View;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.facebook.shimmer.ShimmerFrameLayout;
import com.google.android.material.snackbar.Snackbar;
import com.payoneer.paymentapp.R;
import com.payoneer.paymentapp.network.Resource;

public class Utils {
    public static void showSnackBar(
            String message,
            int duration,
            View view
    ) {
        Snackbar.make(view, message, duration).show();
    }

    public static <T> Resource getResource(int responseCode, T responseBody) {
        switch (responseCode) {
            case Constants.successCode: {
                Resource resource = Resource.success(responseBody);
                return resource;
            }
            case Constants.emptyResourceCode: {
                Resource resource = Resource.error(Constants.emptyResultMessage, null);
                return resource;
            }
            case Constants.noResourceCode: {
                Resource resource = Resource.error(Constants.noResourceMessage, null);
                return resource;
            }
            case Constants.timeoutCode: {
                Resource resource = Resource.error(Constants.timeoutMessage, null);
                return resource;
            }
            case Constants.serverErrorCode: {
                Resource resource = Resource.error(Constants.serverErrorMessage, null);
                return resource;
            }
            default: {
                Resource resource = Resource.error(Constants.errorMessage, null);
                return resource;
            }
        }
    }

    public static void showProgressBar(ProgressBar progressBar) {
        ObjectAnimator animator = ObjectAnimator.ofFloat(progressBar, View.TRANSLATION_Y, -250.0F);
        animator.setDuration(500);
        animator.start();
    }

    public static void hideProgressBar(ProgressBar progressBar) {
            ObjectAnimator animator = ObjectAnimator.ofFloat(progressBar, View.TRANSLATION_Y, 250.0F);
            animator.setDuration(1500);
            animator.start();
    }

    public static void startShimmer(ShimmerFrameLayout shimmerFrameLayout) {
        shimmerFrameLayout.setVisibility(View.VISIBLE);
        shimmerFrameLayout.startShimmer();
    }

    public static void stopShimmer(ShimmerFrameLayout shimmerFrameLayout) {
        shimmerFrameLayout.setVisibility(View.GONE);
        shimmerFrameLayout.stopShimmer();
    }

    @SuppressLint("MissingPermission")
    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (cm == null) return false;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            NetworkCapabilities cap = cm.getNetworkCapabilities(cm.getActiveNetwork());
            if (cap == null) return false;
            return cap.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET);
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Network[] networks = cm.getAllNetworks();
            for (Network n: networks) {
                NetworkInfo nInfo = cm.getNetworkInfo(n);
                if (nInfo != null && nInfo.isConnected()) return true;
            }
        } else {
            NetworkInfo[] networks = cm.getAllNetworkInfo();
            for (NetworkInfo nInfo: networks) {
                if (nInfo != null && nInfo.isConnected()) return true;
            }
        }
        return false;
    }

    public static void setupToolbar(Toolbar toolbar, String title, AppCompatActivity activity, Boolean setBackButton) {
        activity.setSupportActionBar(toolbar);
        androidx.appcompat.app.ActionBar actionBar = activity.getSupportActionBar();
        if(actionBar != null) {
            if(setBackButton) {
                actionBar.setDisplayHomeAsUpEnabled(true);
                actionBar.setHomeAsUpIndicator(R.drawable.ic_arrow_back_24);
                toolbar.setNavigationOnClickListener(view -> {

                });
            }
            toolbar.setTitleTextColor(activity.getResources().getColor(R.color.white));
            actionBar.setTitle(title);
        }
    }
}
