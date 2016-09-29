package vampire.com.androidprojectb.fragment.topic;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import vampire.com.androidprojectb.R;
import vampire.com.androidprojectb.activity.FindTopicActivity;
import vampire.com.androidprojectb.base.BaseFragment;

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
public class AttentionFragment extends BaseFragment implements View.OnClickListener {

    private TextView textViewGoAttention;


    @Override
    protected int setLayout() {
        return R.layout.topic_attention;
    }

    @Override
    protected void initView() {

        textViewGoAttention = bindView(R.id.text_go_attention);


    }

    @Override
    protected void initData() {

textViewGoAttention.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent=new Intent(mContext, FindTopicActivity.class);
        startActivity(intent);
    }
}
