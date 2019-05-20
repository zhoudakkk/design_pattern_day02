package app.yjkm.com.day_02.AppDialog;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import app.yjkm.com.day_02.R;

/**
 * 大图dialog
 */
public class ImageAppDialog extends BaseFragmentDialog {
    public View mView;

    public static ImageAppDialog getInstance(String url) {
        ImageAppDialog dialog = new ImageAppDialog();
        Bundle bundle = new Bundle();
        bundle.putString("image", url);
        dialog.setArguments(bundle);
        return dialog;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mView == null) {
            mView = inflater.inflate(R.layout.image_dialog, null);
        }
        return mView;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Bundle arguments = getArguments();
        String image = arguments.getString("image");
        Log.e("text123", "onViewCreated: image = "+ image );
    }

    @Override
    public void onStart() {
        super.onStart();

    }


    public void showDialog(FragmentManager fm) {
        show(fm, "ImageAppDialog");
    }
}
