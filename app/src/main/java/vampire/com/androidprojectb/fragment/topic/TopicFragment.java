package vampire.com.androidprojectb.fragment.topic;

import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

import vampire.com.androidprojectb.R;
import vampire.com.androidprojectb.activity.FindTopicActivity;
import vampire.com.androidprojectb.base.BaseFragment;
import vampire.com.androidprojectb.base.MyApp;
import vampire.com.androidprojectb.fragment.topic.Adapter.TopicAdapter;

/**
 * Created by Vampire on 16/9/12.
 */
public class TopicFragment extends BaseFragment implements View.OnClickListener {
    private static final String TAG = "Vampire_TopicFragment";
    private ArrayList<Fragment> fragments;
    private ArrayList<String> list;
    private TabLayout tabLayoutTopic;
    private ViewPager viewPagerTopic;
    private ImageView imageViewSearch;

    @Override
    protected int setLayout() {
        return R.layout.fragment_topic;
    }

    @Override
    protected void initView() {
        tabLayoutTopic = bindView(R.id.tab_topic);
        viewPagerTopic = bindView(R.id.vp_topic);
        imageViewSearch=bindView(R.id.image_search);
    }

    @Override
    protected void initData() {
        TopicAdapter adapter = new TopicAdapter(getChildFragmentManager(), getContext());
        fragments=new ArrayList<>();
        fragments.add(new AskFragment());
        fragments.add(new VideoFragment());
        fragments.add(new AttentionFragment());
        list=new ArrayList<>();
        list.add("问吧");
        list.add("视频");
        list.add("关注");
        adapter.setFragments(fragments);
        adapter.setArrayList(list);
        viewPagerTopic.setAdapter(adapter);
        tabLayoutTopic.setupWithViewPager(viewPagerTopic);
        tabLayoutTopic.setSelectedTabIndicatorColor(Color.WHITE);
        tabLayoutTopic.setTabTextColors(0x55F6A7A5, Color.WHITE);
        imageViewSearch.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent=new Intent(MyApp.getContext(),FindTopicActivity.class);
        startActivity(intent);
    }
}
