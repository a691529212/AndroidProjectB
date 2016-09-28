package vampire.com.androidprojectb.activity;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import vampire.com.androidprojectb.R;
import vampire.com.androidprojectb.base.BaseActivity;
import vampire.com.androidprojectb.fragment.topic.Adapter.AskUpSecondAdapter;
import vampire.com.androidprojectb.fragment.topic.bean.AskUpSecondBean;
import vampire.com.androidprojectb.tool.nettool.NetTool;
import vampire.com.androidprojectb.tool.nettool.OnHttpCallBack;
import vampire.com.androidprojectb.values.UrlValues;

/**
 * code is far away from bug with the animal protecting
 * <p>
 * ┏┓　　　┏┓
 * ┏┛┻━━━┛┻┓
 * ┃　　　　　　　┃
 * ┃　　　━　　　┃
 * ┃　┳┛　┗┳　┃
 * ┃　　　　　　　┃
 * ┃　　　┻　　　┃
 * ┃　　　　　　　┃
 * ┗━┓　　　┏━┛
 * 　　┃　　　┃神兽保佑
 * 　　┃　　　┃永无BUG！  凯哥 祝你一路顺风
 * 　　┃　　　┗━━━┓
 * 　　┃　　　　　　　┣┓
 * 　　┃　　　　　　　┏┛
 * 　　┗┓┓┏━┳┓┏┛
 * 　　　┃┫┫　┃┫┫
 * 　　　┗┻┛　┗┻┛
 */
public class AskUpSecondActivity extends BaseActivity implements View.OnClickListener {
    private TextView textViewName;
    private ListView listViewUp;
   private ImageView imageViewBack;
    private AskUpSecondAdapter secondAdapter;

    @Override
    protected int setLayout() {
        return R.layout.ask_up_second;
    }

    @Override
    protected void initView() {
        textViewName = bindView(R.id.text_name);
        listViewUp = bindView(R.id.lv_ask_up);
        imageViewBack=bindView(R.id.image_back);
        secondAdapter = new AskUpSecondAdapter(this);

    }

    @Override
    protected void initData() {
        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        String name = intent.getStringExtra("name");
        textViewName.setText(name);
        listViewUp.setAdapter(secondAdapter);
        imageViewBack.setOnClickListener(this);
        NetTool.getInstance().startRequest(UrlValues.ASK_UP_PREFIXION + id + UrlValues.ASK_UP_SUFFIX, AskUpSecondBean.class, new OnHttpCallBack<AskUpSecondBean>() {
            @Override
            public void onSuccess(AskUpSecondBean response) {
                secondAdapter.setSecondBean(response);
            }

            @Override
            public void onError(Throwable e) {

            }
        });
    }

    @Override
    public void onClick(View view) {
        finish();
    }
}
