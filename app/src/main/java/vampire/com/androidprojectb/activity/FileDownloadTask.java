package vampire.com.androidprojectb.activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Environment;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

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
 * Created by R on 16/10/8.
 */

public class FileDownloadTask extends AsyncTask<String, Integer, Bitmap> {
    /** 获取SD卡路径 */
    private static final File CACHE_PATH =
            Environment.getExternalStorageDirectory();

    // 声明一个接口类型的变量
    private OnDownloadListener listener;

    public FileDownloadTask(OnDownloadListener listener) {
        this.listener = listener;
    }


    @Override
    protected Bitmap doInBackground(String... strings) {
        String urlStr = strings[0];
        HttpURLConnection connection = null;
        InputStream in = null;
        FileOutputStream fos = null;
        try {
            // 定义一个输出的文件
            // 参数1:文件路径 File类型
            // 参数2:文件名
            File file = new File(CACHE_PATH, "network_image.jpg");
            // 如果该文件不存在,则新建文件
            if (!file.exists()) {
                file.createNewFile();
                // 初始化文件输出流
                fos = new FileOutputStream(file);

                URL url = new URL(urlStr);
                connection = (HttpURLConnection) url.openConnection();
                in = connection.getInputStream();
                Bitmap bmp = BitmapFactory.decodeStream(in);
                // Bitmap有个方法,可以直接把图片写到输出流里面
                bmp.compress(Bitmap.CompressFormat.PNG,100,fos);
                fos.close();
            }
            return BitmapFactory.decodeFile(file.getAbsolutePath());

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                connection.disconnect();
            }
        }
        return null;
    }

    // 第一个执行的方法,在后台任务执行之前被调用
    // 一般做一些初始化的操作,或者用于显示一个进度条
    // 运行在主线程中
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    // 在后台任务执行结束被调用,方法运行在主线程中
    // 方法的参数,是后台任务(doInBackground()方法)运行结束之后的返回值
    @Override
    protected void onPostExecute(Bitmap bmp) {
        super.onPostExecute(bmp);
        listener.onFinish(bmp);
    }

    // 在后台任务执行的过程中调用
    // 在后台任务中调用publishProgress()时,下面的方法会被调用
    // 参数为publishProgress()方法中填入的参数
    // 在doInBackground()方法中调用一次publishProgress(),下面的方法就会执行一次
    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
    }


    public interface OnDownloadListener {
        void onFinish(Bitmap bmp);
    }


}

