package vampire.com.androidprojectb.fragment.news;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.AdapterView;

import vampire.com.androidprojectb.R;
import vampire.com.androidprojectb.base.BaseFragment;
import vampire.com.androidprojectb.base.MyApp;
import vampire.com.androidprojectb.fragment.news.activity.NewsSearchAcitvity;
import vampire.com.androidprojectb.fragment.news.activity.TabLayoutTitleActivity;
import vampire.com.androidprojectb.fragment.news.adapter.NewsAdapter;
import vampire.com.androidprojectb.fragment.news.amap.LastLocation_Activity;
import vampire.com.androidprojectb.fragment.news.tantan.TanTanAcitivity;

/**
 * Created by Vampire on 16/9/12.
 */
public class NewsFragment extends BaseFragment implements View.OnClickListener, AdapterView.OnItemClickListener {
    private static final String TAG = "Vampire_NewsFragment";
    private TabLayout mNewsTabLayout;
    private ViewPager mNewsViewPager;
    private NewsAdapter  newsAdapter;


    @Override
    protected int setLayout() {
        return R.layout.fragment_news;
    }

    @Override
    protected void initView() {
        mNewsTabLayout = bindView(R.id.fragment_news_tablayout);
        mNewsViewPager = bindView(R.id.fragment_news_viewpager);
        mNewsTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        bindView(R.id.fragment_news_button_tantan).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),TanTanAcitivity.class));

            }
        });
        bindView(R.id.fragment_news_button_search).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), NewsSearchAcitvity.class));
            }
        });
        bindView(R.id.fragment_news_button_amap).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), LastLocation_Activity.class));
            }
        });
    }

    @Override
    protected void initData() {
        newsAdapter = new NewsAdapter(getChildFragmentManager());
        mNewsViewPager.setAdapter(newsAdapter);
        mNewsTabLayout.setupWithViewPager(mNewsViewPager);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getActivity(),TabLayoutTitleActivity.class);
        startActivity(intent);
    }



    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        MyApp.getListTitle().remove(position);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}