package vampire.com.androidprojectb.activity;

import android.widget.ListView;

import vampire.com.androidprojectb.R;
import vampire.com.androidprojectb.base.BaseActivity;
import vampire.com.androidprojectb.base.CommonAdapter;
import vampire.com.androidprojectb.base.CommonViewHolder;
import vampire.com.androidprojectb.base.MyApp;
import vampire.com.androidprojectb.fragment.topic.Adapter.FindTopicLeftAdapter;
import vampire.com.androidprojectb.fragment.topic.bean.FindTopicBean;
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
public class FindTopicActivity extends BaseActivity {

    private ListView lvLeft;
    private ListView lvRight;
    private FindTopicLeftAdapter leftAdapter;

    @Override
    protected int setLayout() {
        return R.layout.findtopic;
    }

    @Override
    protected void initView() {
        lvLeft = bindView(R.id.find_lv_left);
        lvRight = bindView(R.id.find_lv_right);
        leftAdapter = new FindTopicLeftAdapter(this);

    }

    @Override
    protected void initData() {
        lvLeft.setAdapter(leftAdapter);
        NetTool.getInstance().startRequest(UrlValues.TOPIC_SEARCH, FindTopicBean.class,
                new OnHttpCallBack<FindTopicBean>() {
            @Override
            public void onSuccess(FindTopicBean response) {

                leftAdapter.setLefttBean(response);
            }

            @Override
            public void onError(Throwable e) {

            }
        });

    }

}
