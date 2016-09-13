package vampire.com.androidprojectb;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import vampire.com.androidprojectb.base.BaseActivity;
import vampire.com.androidprojectb.fragment.news.NewsFragment;
import vampire.com.androidprojectb.fragment.recreation.RecreationFragment;
import vampire.com.androidprojectb.fragment.topic.TopicFragment;
import vampire.com.androidprojectb.fragment.user.UserFragment;


public class MainActivity extends BaseActivity implements View.OnClickListener {


    private FrameLayout frameLayout;
    private RadioButton btnNews;
    private RadioButton btnRecreation;
    private RadioButton btnTopic;
    private RadioButton btnUser;
    private RadioGroup radioGroup;
    private FragmentManager manager;


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

        btnNews.setOnClickListener(this);
        btnRecreation.setOnClickListener(this);
        btnTopic.setOnClickListener(this);
        btnUser.setOnClickListener(this);

        manager =getSupportFragmentManager();

    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            // 新闻
            case R.id.btn_news:
                NewsFragment newsFragment = new NewsFragment();
                upDataFragment(newsFragment);
                break;

            // 娱乐
            case R.id.btn_recreation:
                RecreationFragment recreationFragment =new RecreationFragment();
                upDataFragment(recreationFragment);
                break;

            // 话题
            case R.id.btn_topic:
                TopicFragment topicFragment =new TopicFragment();
                upDataFragment(topicFragment);
                break;

            // 我
            case R.id.btn_user:
                UserFragment userFragment =new UserFragment();
                upDataFragment(userFragment);
                break;
        }

    }

    // 替换fragment
    private void upDataFragment(Fragment fragment){

        FragmentTransaction transaction =  manager.beginTransaction();
        transaction.replace(R.id.frame_layout_main,fragment).commit();
    }
}
