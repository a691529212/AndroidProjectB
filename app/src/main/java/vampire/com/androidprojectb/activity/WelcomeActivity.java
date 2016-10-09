package vampire.com.androidprojectb.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

import vampire.com.androidprojectb.MainActivity;
import vampire.com.androidprojectb.R;

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
 * <p/>
 * <p/>
 * <p/>
 * Created by R on 16/10/8.
 */
public class WelcomeActivity extends AppCompatActivity
        implements View.OnClickListener {
    private static final String TAG = "TAG_WelcomeActivity";
    /**
     * 图片的URL
     */
    private static final String URL_IMAGE = "http://ww1.sinaimg.cn/large/610dc034jw1f5hpzuy3r7j20np0zkgpd.jpg";

    private TextView textView;

    private Timer timer;
    private TimerTask timerTask;
    private int index = 5;
    private FileDownloadTask downloadTask;

    private Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message message) {
            textView.setText(index-- + "");
            if (index == 0) {
                startNextPage();
            }
            return false;
        }
    });

    /**
     * 跳转到主界面,并停止计时器/取消图片的下载/关闭自己
     */
    private void startNextPage() {
        startActivity(new Intent(this, MainActivity.class));
        timer.cancel();
        downloadTask.cancel(true);
        finish();

    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        textView = (TextView) findViewById(R.id.welcome_text_time);
        textView.setOnClickListener(this);
        // 初始化计时器相关类的对象
        timer = new Timer();
        timerTask = new TimerTask() {
            @Override
            public void run() {
                handler.sendEmptyMessage(0);
            }
        };

        // 初始化下载图片的异步任务
        downloadTask = new FileDownloadTask(new FileDownloadTask.OnDownloadListener() {
            @Override
            public void onFinish(Bitmap bmp) {
            }
        });

        // 开始下载图片
        downloadTask.execute(URL_IMAGE);
        // 开始执行计时器,每隔1000毫秒都会执行一下TimerTask对象里面的任务
        timer.schedule(timerTask, 0, 1000);

    }

    @Override
    public void onClick(View view) {
        startNextPage();
    }
}