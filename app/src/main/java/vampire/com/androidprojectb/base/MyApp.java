package vampire.com.androidprojectb.base;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.facebook.drawee.backends.pipeline.Fresco;

public class MyApp extends Application {
    private static final String TAG = "Vampire_MyApp";

    private static Context mContext;


    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
        // 初始化Fresco
        Fresco.initialize(this);

    }

    public  static Context getContext(){
        return mContext;
    }






}
