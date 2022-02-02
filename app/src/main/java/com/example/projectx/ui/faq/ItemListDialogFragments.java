package com.example.projectx.ui.faq;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import com.example.projectx.databinding.FragmentItemListDialogFragmentsListDialogBinding;
import com.example.projectx.databinding.FragmentItemListDialogFragmentsListDialogItemBinding;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
/*
import com.example.projectx.R;
import com.example.projectx.ui.faq.databinding.FragmentItemListDialogFragmentsListDialogItemBinding;
import com.example.projectx.ui.faq.databinding.FragmentItemListDialogFragmentsListDialogBinding;
*/
/**
 * <p>A fragment that shows a list of items as a modal bottom sheet.</p>
 * <p>You can show this modal bottom sheet from your activity like this:</p>
 * <pre>
 *     ItemListDialogFragments.newInstance(30).show(getSupportFragmentManager(), "dialog");
 * </pre>
 */
public class ItemListDialogFragments extends BottomSheetDialogFragment {

    // TODO: Customize parameter argument names
    private static final String ARG_ITEM_COUNT = "item_count";
    private FragmentItemListDialogFragmentsListDialogBinding binding;
    // TODO: Customize parameters
    public static ItemListDialogFragments newInstance(int itemCount) {
        final ItemListDialogFragments fragment = new ItemListDialogFragments();
        final Bundle args = new Bundle();
        args.putInt(ARG_ITEM_COUNT, itemCount);
        fragment.setArguments(args);
        return fragment;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentItemListDialogFragmentsListDialogBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        final RecyclerView recyclerView = (RecyclerView) view;
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new ItemAdapter(getArguments().getInt(ARG_ITEM_COUNT)));
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
    private class ViewHolder extends RecyclerView.ViewHolder {
        final TextView text;
        ViewHolder(FragmentItemListDialogFragmentsListDialogItemBinding binding) {
            super(binding.getRoot());
            text = binding.text;
        }
    }
    private class ItemAdapter extends RecyclerView.Adapter<ViewHolder> {
        private final int mItemCount;
        ItemAdapter(int itemCount) {
            mItemCount = itemCount;
        }
        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new ViewHolder(FragmentItemListDialogFragmentsListDialogItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
        }
        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            holder.text.setText(String.valueOf(position));
        }
        @Override
        public int getItemCount() {
            return mItemCount;
        }
    }
}