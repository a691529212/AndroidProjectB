package vampire.com.androidprojectb;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import vampire.com.androidprojectb.base.BaseActivity;
import vampire.com.androidprojectb.fragment.news.NewsFragment;
import vampire.com.androidprojectb.fragment.recreation.RecreationFragment;
import vampire.com.androidprojectb.fragment.topic.TopicFragment;
import vampire.com.androidprojectb.fragment.user.UserFragment;


public class MainActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener {


    private FrameLayout frameLayout;
    private RadioButton btnNews;
    private RadioButton btnRecreation;
    private RadioButton btnTopic;
    private RadioButton btnUser;
    private RadioGroup radioGroup;
    private FragmentManager manager;
    private NewsFragment newsFragment;


    @Override
    protected int setLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {

        frameLayout = bindView(R.id.frame_layout_main);

        radioGroup = bindView(R.id.rg_main);

        btnNews = bindView(R.id.btn_news);
        btnRecreation = bindView(R.id.btn_recreation);
        btnTopic = bindView(R.id.btn_topic);
        btnUser = bindView(R.id.btn_user);

        radioGroup.check(R.id.btn_news);
        radioGroup.setOnCheckedChangeListener(this);

        manager = getSupportFragmentManager();

    }

    @Override
    protected void initData() {
        upDataFragment(newsFragment);
    }

    // 替换fragment
    private void upDataFragment(Fragment fragment) {

        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.frame_layout_main, fragment).commit();
    }


    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            // 新闻
            case R.id.btn_news:
                newsFragment = new NewsFragment();
                upDataFragment(newsFragment);
                break;

            // 娱乐
            case R.id.btn_recreation:
                RecreationFragment recreationFragment = new RecreationFragment();
                upDataFragment(recreationFragment);
                break;

            // 话题
            case R.id.btn_topic:
                TopicFragment topicFragment = new TopicFragment();
                upDataFragment(topicFragment);
                break;

            // 我
            case R.id.btn_user:
                UserFragment userFragment = new UserFragment();
                upDataFragment(userFragment);
                break;

        }
    }
}
