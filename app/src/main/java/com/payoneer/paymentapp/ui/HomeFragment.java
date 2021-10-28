package com.payoneer.paymentapp.ui;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.Toolbar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.facebook.shimmer.ShimmerFrameLayout;
import com.payoneer.paymentapp.R;
import com.payoneer.paymentapp.adapters.PaymentRvAdapter;
import com.payoneer.paymentapp.databinding.FragmentHomeBinding;
import com.payoneer.paymentapp.model.ApplicableItem;
import com.payoneer.paymentapp.model.PaymentsResponse;
import com.payoneer.paymentapp.network.Resource;
import com.payoneer.paymentapp.utils.ClickListener;
import com.payoneer.paymentapp.utils.Constants;
import com.payoneer.paymentapp.utils.Utils;
import com.payoneer.paymentapp.viewmodel.PaymentsViewModel;

import java.util.List;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class HomeFragment extends Fragment implements ClickListener<ApplicableItem> {
    public HomeFragment() {}
    private FragmentHomeBinding binding;
    private PaymentsViewModel paymentsViewModel;
    private PaymentRvAdapter paymentsAdapter;
    private boolean rvContainsData = false;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

            paymentsViewModel = new ViewModelProvider(requireActivity()).get(PaymentsViewModel.class);
            if(savedInstanceState == null) {
                if(Utils.isNetworkAvailable(requireContext())) {
                    paymentsViewModel.getPayments();
                } else {
                    binding.swipeRefresh.setRefreshing(false);
                    Utils.showSnackBar( Constants.errorHeading + "\n" + "Please check you internet connection.", Constants.longDuration, requireView());
                }
            } else {
                rvContainsData = savedInstanceState.getBoolean(Constants.RV_CONTAINS_DATA);
            }
        getData();
        setUpSwipeRefresh();
        Toolbar toolbar = view.findViewById(R.id.toolbar);
        Utils.setupToolbar(toolbar, getString(R.string.app_name), (AppCompatActivity) requireActivity(), false);
        setHasOptionsMenu(true);
    }

    private void getData() {
        paymentsViewModel.paymentsList().observe(this, new Observer<Resource<PaymentsResponse>>() {
            @Override
            public void onChanged(Resource<PaymentsResponse> paymentsResponseResource) {
                if(paymentsResponseResource != null) {
                    String message = paymentsResponseResource.message;
                    Resource.Status status = paymentsResponseResource.status;

                    switch (status) {
                        case LOADING: {
                            if(!rvContainsData) {
                                Utils.showSnackBar("FETCHING DATA...", Constants.shortDuration, requireView());
                                binding.paymentsRv.setVisibility(View.GONE);
                                Utils.startShimmer(binding.shimmerViewContainer);
                            }
                            break;
                        }
                        case SUCCESS: {
                            setUpViews();
                            if(paymentsResponseResource.data != null) {
                                List<ApplicableItem> applicableItems = paymentsResponseResource.data.getNetworks().getApplicable();
                                setUpRecyclerView(applicableItems);
                                rvContainsData = true;
                            } else  {
                                rvContainsData = false;
                                Utils.showSnackBar( Constants.errorHeading + "\n" + message, Constants.longDuration, requireView());
                            }
                            break;
                        }
                        case ERROR: {
                            setUpViews();
                            rvContainsData = false;
                            if(binding.paymentsRv.getAdapter() != null && binding.paymentsRv.getAdapter().getItemCount() != 0) {
                                rvContainsData = true;
                            }
                            if(!rvContainsData) {
                                binding.shimmerViewContainer.setVisibility(View.VISIBLE);
                            }
                            Utils.showSnackBar(Constants.errorHeading + "\n" + message, Constants.longDuration, requireView());
                            break;
                        }
                    }
                }
            }
        });
    }

    private void setUpRecyclerView(List<ApplicableItem> applicableItems) {
        paymentsAdapter = new PaymentRvAdapter(applicableItems, this);
        binding.paymentsRv.setAdapter(paymentsAdapter);
        binding.paymentsRv.setLayoutManager(new LinearLayoutManager(requireContext()));
    }

    @Override
    public void onItemClick(ApplicableItem item, int position) {
        Utils.showSnackBar(item.getLabel(), Constants.shortDuration, requireView());
    }

    private void setUpSwipeRefresh() {
        binding.swipeRefresh.setOnRefreshListener(() -> {
            if(Utils.isNetworkAvailable(requireContext())) {
                paymentsViewModel.getPayments();
            } else {
                binding.shimmerViewContainer.stopShimmer();
                binding.swipeRefresh.setRefreshing(false);
                Utils.showSnackBar( Constants.errorHeading + "\n" + "Please check you internet connection.", Constants.longDuration, requireView());
            }
        });
    }

    private void setUpViews() {
        Utils.hideProgressBar(binding.progressBar);
        Utils.stopShimmer(binding.shimmerViewContainer);
        binding.swipeRefresh.setRefreshing(false);
        binding.paymentsRv.setVisibility(View.VISIBLE);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.menu_items, menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.menu_refresh) {
            if(Utils.isNetworkAvailable(requireContext())) {
                if(rvContainsData) {
                    Utils.showProgressBar(binding.progressBar);
                }
                new Handler().postDelayed(() -> paymentsViewModel.getPayments(), 500);
            } else {
                binding.shimmerViewContainer.stopShimmer();
                Utils.showSnackBar( Constants.errorHeading + "\n" + "Please check you internet connection.", Constants.longDuration, requireView());
            }
            return true;
        } else {
            super.onOptionsItemSelected(item);
            return false;
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean(Constants.RV_CONTAINS_DATA, rvContainsData);
    }
}