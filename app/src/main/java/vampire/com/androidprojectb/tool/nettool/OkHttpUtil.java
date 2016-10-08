package vampire.com.androidprojectb.tool.nettool;


import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import vampire.com.androidprojectb.base.MyApp;

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
        Log.d("OkHttpUtil", url);
        Request request;
         //有的请求需要加body
         RequestBody body = RequestBody.create(MediaType.parse("html/txt"),"data=AD9/fXPmdAPktxm8hlqlG2TsD4ZylgBFnC2Y9ruMOxU%3D");
        if (url.equals("http://topic.comment.163.com/topic/recomend.html")||url.equals("http://topic.comment.163.com/topic/list/myfollow.html")) {
            request = new Request
                    .Builder().url(url)
                    .addHeader("Server"," nginx")
                    .addHeader("Date","Tue, 27 Sep 2016 06:04:53 GMT")
                    .addHeader("Content-Type","text/html;charset=UTF-8")
                    .addHeader("Content-Length","1779")
                    .addHeader("Connection","keep-alive")

                    .addHeader("Vary","Accept-Encoding")
                    .addHeader("Vary","Accept-Encoding")

                    .build();
            Log.d("OkHttpUtil", "in");
        } else {

            request = new Request
                    .Builder().url(url)
                    .addHeader("apikey", "35fe329001b3e54bfd917517f52fcbe0")
                    .build();
        }

        Log.d("OkHttpUtil", url);

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
                String str = response.body().string().trim();

                if(str.length() == 160){
                    File cacheDir = MyApp.getContext().getCacheDir();
                    if(!cacheDir.exists()){
                        cacheDir.mkdir();
                    }
                    File text = new File(cacheDir,"ceshi.txt");
                    if(!text.exists()){
                        text.createNewFile();
                    }
                    FileOutputStream fileOutputStream = new FileOutputStream(text);
                    fileOutputStream.write(str.getBytes());
                }


                try {
                    final T result = mGson.fromJson(str, tClass);
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            callBack.onSuccess(result);
                        }
                    });
                }catch (Exception e){
                    Log.d("OkHttpUtil", "e:" + e);
                }



            }

        });

    }
}
