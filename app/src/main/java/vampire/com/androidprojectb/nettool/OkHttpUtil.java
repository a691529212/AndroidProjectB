package vampire.com.androidprojectb.nettool;

import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import com.google.gson.Gson;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 　　　　　　　　┏┓　　　┏┓+ +
 * 　　　　　　　┏┛┻━━━┛┻┓ + +
 * 　　　　　　　┃　　　　　　　┃
 * 　　　　　　　┃　　　━　　　┃ ++ + + +
 * 　　　　　　 ████━████ ┃+
 * 　　　　　　　┃　　　　　　　┃ +
 * 　　　　　　　┃　　　┻　　　┃
 * 　　　　　　　┃　　　　　　　┃ + +
 * 　　　　　　　┗━┓　　　┏━┛
 * 　　　　　　　　　┃　　　┃
 * 　　　　　　　　　┃　　　┃ + + + +
 * 　　　　　　　　　┃　　　┃　　　　Code is far away from bug with the animal protecting
 * 　　　　　　　　　┃　　　┃ + 　　　　神兽保佑,代码无bug
 * 　　　　　　　　　┃　　　┃
 * 　　　　　　　　　┃　　　┃　　+
 * 　　　　　　　　　┃　 　　┗━━━┓ + +
 * 　　　　　　　　　┃ 　　　　　　　┣┓
 * 　　　　　　　　　┃ 　　　　　　　┏┛
 * 　　　　　　　　　┗┓┓┏━┳┓┏┛ + + + +
 * 　　　　　　　　　　┃┫┫　┃┫┫
 * 　　　　　　　　　　┗┻┛　┗┻┛+ + + +
 * <p>
 * Created by R on 16/9/12.
 */

public class OkHttpUtil implements NetInterface {
    private OkHttpClient mClient;
    //这样定义的handler对象无论在哪里创建的 都是属于主线程的
    private Handler mHandler =
            new Handler(Looper.getMainLooper());
    private Gson mGson;
    public OkHttpUtil() {
        super();
        mGson = new Gson();
        //获取系统的sd卡
        File path =
                Environment.getExternalStorageDirectory();
        //初始化okhttp
        mClient = new OkHttpClient.Builder()
                //设置缓存位置 以及缓存大小
                .cache(new Cache(path, 10 * 1024 * 1024))
                //超时时间5s
                .connectTimeout(5, TimeUnit.SECONDS)
                .build();
    }



    @Override
    public <T> void startRequest(String url, final Class<T> tClass, final OnHttpCallBack<T> callBack) {
        Request request = new Request
                .Builder().url(url)
                .addHeader("apikey","35fe329001b3e54bfd917517f52fcbe0")
                .build();
        mClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        callBack.onError(e);
                        Log.d("OkHttpUtil", "请求失败" + e.toString());
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String str = response.body().string();
                final T result = mGson.fromJson(str,tClass);
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        callBack.onSuccess(result);
                    }
                });
            }
        });
    }
}
