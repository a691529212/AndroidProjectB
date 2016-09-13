package vampire.com.androidprojectb.base;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.facebook.drawee.backends.pipeline.Fresco;

import cn.bmob.v3.Bmob;

public class MyApp extends Application {
    private static final String TAG = "Vampire_MyApp";

    private static Context mContext;


    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
        // 初始化Fresco

        Fresco.initialize(this);
        Bmob.initialize(this, "1f593c7c45cc220c981e72df2e4c7d4b");
    }

    public  static Context getContext(){
        return mContext;
    }






}
