package app.yjkm.com.day_02.AppDialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.view.*;
import app.yjkm.com.day_02.R;

/**
 * APP加载dialog
 */
public class LoadingAppDialog extends BaseFragmentDialog {

    public View mView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mView == null) {
            mView = inflater.inflate(R.layout.dialog_loading, null);
        }
        return mView;
    }

    @Override
    public void onStart() {
        super.onStart();
        setCanceledOnTouchOutside(false);
        setOnKeyListener();
    }

    public void showDialog(FragmentManager fm) {
        show(fm, "LoadingAppDialog");
    }

}
