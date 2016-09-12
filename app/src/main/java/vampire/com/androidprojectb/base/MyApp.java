package vampire.com.androidprojectb.base;

import android.app.Application;
import android.content.Context;
import android.util.Log;

public class MyApp extends Application {
    private static final String TAG = "Vampire_MyApp";

    private static Context mContext;


    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
        Log.d(TAG, "onCreate() called with: " + "");
    }

    public  static Context getContext(){
        return mContext;
    }


}
