package vampire.com.androidprojectb.fragment.news;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import vampire.com.androidprojectb.R;
import vampire.com.androidprojectb.base.BaseFragment;
import vampire.com.androidprojectb.fragment.news.adapter.NewsAdapter;

/**
 * Created by Vampire on 16/9/12.
 */
public class NewsFragment extends BaseFragment{
    private static final String TAG = "Vampire_NewsFragment";
    private TabLayout mNewsTabLayout;
    private ViewPager mNewsViewPager;
    private NewsAdapter newsAdapter;


    @Override
    protected int setLayout() {
        return R.layout.fragment_news;
    }

    @Override
    protected void initView() {
        mNewsTabLayout = bindView(R.id.fragment_news_tablayout);
        mNewsViewPager = bindView(R.id.fragment_news_viewpager);


    }

    @Override
    protected void initData() {
        newsAdapter= new NewsAdapter(getChildFragmentManager());
        mNewsViewPager.setAdapter(newsAdapter);
        mNewsTabLayout.setupWithViewPager(mNewsViewPager);
    }
}
