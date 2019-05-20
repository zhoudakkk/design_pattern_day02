package app.yjkm.com.day_02;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Window;
import android.view.WindowManager;
import app.yjkm.com.day_02.AppDialog.ImageAppDialog;
import app.yjkm.com.day_02.AppDialog.ListAppDialog;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        ComputerBuilder builder = new MacBookBuilder();
//        ComputerDirector director = new ComputerDirector(builder);
//        director.construct("我的世界","你的世界");

        List<String> list = new ArrayList<>();
        for (int i = 0; i < 205; i++) {
            list.add("---"+i+"---");
        }
        ListAppDialog.getInstance(list).showDialog(getSupportFragmentManager());
    }


}
