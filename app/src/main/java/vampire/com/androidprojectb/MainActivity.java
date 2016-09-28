package vampire.com.androidprojectb;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

import com.romainpiel.shimmer.Shimmer;
import com.romainpiel.shimmer.ShimmerTextView;

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
    private RelativeLayout title;
    private Button back;
    private Button down;
    private ShimmerTextView titleTv;


    @Override
    protected int setLayout() {
        return R.layout.activity_main;
    }

    public Button getBack() {
        return back;
    }

    public Button getDown() {
        return down;
    }

    public RelativeLayout getMainTitle() {
        return title;
    }

    public ShimmerTextView getTitleTv() {
        return titleTv;
    }

    @Override
    protected void initView() {

        title = bindView(R.id.main_linear_layout);
        back = bindView(R.id.main_go_back);
        down = bindView(R.id.main_go_down);
        titleTv = bindView(R.id.tv_main_title);
        Shimmer shimmer = new Shimmer();
        shimmer.setDuration(6000).setStartDelay(300).setDirection(Shimmer.ANIMATION_DIRECTION_LTR);// left tp right
        shimmer.start(titleTv);

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
        newsFragment = new NewsFragment();
        upDataFragment(newsFragment);
    }

    // 替换fragment
    public void upDataFragment(Fragment fragment) {

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
