package vampire.com.androidprojectb.base;

import android.app.Application;
import android.content.Context;

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
        //第一：默认初始化 通常会在Application的onCreate方法里写
        Bmob.initialize(this, "1f593c7c45cc220c981e72df2e4c7d4b");
        Fresco.initialize(this);
    }

    public  static Context getContext(){
        return mContext;
    }






}
