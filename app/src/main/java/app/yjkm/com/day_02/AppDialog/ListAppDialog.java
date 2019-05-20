package app.yjkm.com.day_02.AppDialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.*;
import android.widget.TextView;
import app.yjkm.com.day_02.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 一个有列表的dialog
 */
public class ListAppDialog extends BaseFragmentDialog {
    public View mView;
    private RecyclerView mDialogListRv;
    private MyAdapter mAdapter;

    public List<String> mList = new ArrayList<>();
    private Context mContext;

    public static ListAppDialog getInstance(List<String> list) {
        ListAppDialog dialog = new ListAppDialog();
        Bundle bundle = new Bundle();
        bundle.putStringArrayList("list", (ArrayList<String>) list);
        dialog.setArguments(bundle);
        return dialog;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mContext = inflater.getContext();
        if (mView == null) {
            mView = inflater.inflate(R.layout.dialog_list, null);
        }
        return mView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mDialogListRv = view.findViewById(R.id.dialog_list_rv);

        mList = getArguments().getStringArrayList("list");

        mDialogListRv.setLayoutManager(new GridLayoutManager(getActivity(),1));
        mAdapter = new MyAdapter();
        mDialogListRv.setAdapter(mAdapter);
    }



    @Override
    public void onStart() {
        super.onStart();
        setHeight();
    }


    private void setHeight() {

        Dialog dialog = getDialog();
        if (dialog == null) {
            return;
        }
        Window window = dialog.getWindow();
        if (window == null) {
            return;
        }
        int itemCount = mAdapter.getItemCount();

        DisplayMetrics displayMetrics = mContext.getResources().getDisplayMetrics();
        WindowManager.LayoutParams attributes = window.getAttributes();
        int maxHeight = (int) (displayMetrics.heightPixels * 0.6);
        if (itemCount > 5) {
            attributes.height = maxHeight;
        }
        attributes.width = (int) (displayMetrics.widthPixels * 0.6);
        window.setAttributes(attributes);

    }



    public void showDialog(FragmentManager fm) {
        show(fm, "ListAppDialog");
    }

    class MyAdapter extends RecyclerView.Adapter<VH> {

        @Override
        public VH onCreateViewHolder(ViewGroup viewGroup, int i) {
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_dialog_list, null);
            VH vh = new VH(view);
            return vh;
        }

        @Override
        public void onBindViewHolder(VH vh, int i) {
            String item = mList.get(i);
            vh.mItem_dialog_list_tv.setText(item);
        }

        @Override
        public int getItemCount() {
            return mList == null ? 0 : mList.size();
        }
    }

    class VH extends RecyclerView.ViewHolder {

        public TextView mItem_dialog_list_tv;

        public VH(View itemView) {
            super(itemView);
            mItem_dialog_list_tv = itemView.findViewById(R.id.item_dialog_list_tv);
        }
    }
}
