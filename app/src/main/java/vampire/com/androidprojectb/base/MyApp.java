package vampire.com.androidprojectb.base;

import android.app.Application;
import android.content.Context;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.iflytek.cloud.SpeechConstant;
import com.iflytek.cloud.SpeechUtility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import cn.bmob.v3.Bmob;
import vampire.com.androidprojectb.fragment.news.bean.TitleBean;
import vampire.com.androidprojectb.tool.dbtool.DBTool;
import vampire.com.androidprojectb.values.StringValues;


public class MyApp extends Application {
    private static final String TAG = "Vampire_MyApp";
    private DBTool dbTool;
    private static Context mContext;
    private static List<String> listTitle = new ArrayList<>();
    private static HashMap<String, String> hasMapTitle = new HashMap<>();

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
        // 初始化Fresco
        //第一：默认初始化 通常会在Application的onCreate方法里写
        Bmob.initialize(this, "1f593c7c45cc220c981e72df2e4c7d4b");
        Fresco.initialize(this);
        // 初始化 语音配置对象
        SpeechUtility.createUtility(this, SpeechConstant.APPID + "=57e3982d");

        for (int i = 0; i < TitleBean.URLS.length; i++) {
            listTitle.add(TitleBean.TITLE[i]);
            hasMapTitle.put(TitleBean.TITLE[i], TitleBean.URLS[i]);
        }
        title();

    }

    private void title() {
        HashMap<String,String> hashMap = new HashMap<>();
        List<String> listtitle = new ArrayList<>();
        for (int i = 0; i < StringValues.TITLE.length; i++) {


        }
    }

    public static Context getContext() {
        return mContext;
    }

    public static List<String> getListTitle() {
        return listTitle;
    }
    public static HashMap<String, String> getHasMapTitle() {
        return hasMapTitle;
    }

}
