package vampire.com.androidprojectb.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;


public abstract class BaseActivity extends AppCompatActivity {
    private static final String TAG = "Vampire_BaseActivity";
    protected View rootView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (setLayout() != 0) {
            rootView = LayoutInflater.from(this).inflate(setLayout(),null);
            setContentView(rootView);//绑定布局
        } else {
            //没有绑定布局,弹出错误日志
            Log.e("BaseAty","Activity:"+this.getClass().getSimpleName()+" 没有绑定布局");
        }
        initView();
        initData();
    }

    protected abstract int setLayout();
    protected abstract void initView();
    protected abstract void initData();

    protected <T extends View> T bindView(int id){
        return (T)findViewById(id);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
