package com.payoneer.paymentapp.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.payoneer.paymentapp.R;
import com.payoneer.paymentapp.databinding.PaymentsItemBinding;
import com.payoneer.paymentapp.model.ApplicableItem;
import com.payoneer.paymentapp.utils.ClickListener;

import java.util.List;

public class PaymentRvAdapter extends RecyclerView.Adapter<PaymentRvAdapter.PaymentViewHolder> {
    private List<ApplicableItem> paymentItemsList;
    private ClickListener<ApplicableItem> listener;
    public PaymentRvAdapter(List<ApplicableItem> applicableItemsList, ClickListener<ApplicableItem> listener) {
        this.paymentItemsList = applicableItemsList;
        this.listener = listener;
    }

    public static class PaymentViewHolder extends RecyclerView.ViewHolder {
        PaymentsItemBinding binding;
        public  PaymentViewHolder(PaymentsItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
        public void bind(ApplicableItem applicableItem, ClickListener<ApplicableItem> listener) {
            binding.paymentNameTv.setText(applicableItem.getLabel());
            Glide.with(binding.getRoot())
                    .load(applicableItem.getLinks().getLogo())
                    .centerInside()
                    .error(R.drawable.ic_credit_card_24)
                    .into(binding.paymentLogoIv);

            itemView.setOnClickListener(view -> {
                listener.onItemClick(applicableItem, getAdapterPosition());
            });
        }
    }

    @NonNull
    @Override
    public PaymentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        PaymentsItemBinding binding = PaymentsItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new PaymentViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull PaymentViewHolder holder, int position) {
        ApplicableItem currentItem = paymentItemsList.get(position);
        holder.bind(currentItem, listener);
    }

    @Override
    public int getItemCount() {
        return paymentItemsList.size();
    }
}
