package vampire.com.androidprojectb.fragment.news;

import android.os.Bundle;
import android.widget.ListView;

import vampire.com.androidprojectb.R;
import vampire.com.androidprojectb.base.BaseFragment;
import vampire.com.androidprojectb.fragment.news.bean.NewsReuseBean;
import vampire.com.androidprojectb.nettool.NetTool;
import vampire.com.androidprojectb.nettool.OnHttpCallBack;
import vampire.com.androidprojectb.values.UrlValues;

/**
 * 　　　　　　　　┏┓　　　┏┓+ +
 * 　　　　　　　┏┛┻━━━┛┻┓ + +
 * 　　　　　　　┃　　　　　　　┃
 * 　　　　　　　┃　　　━　　　┃ ++ + + +
 * 　　　　　　 ████━████ ┃+
 * 　　　　　　　┃　　　　　　　┃ +
 * 　　　　　　　┃　　　┻　　　┃
 * 　　　　　　　┃　　　　　　　┃ + +
 * 　　　　　　　┗━┓　　　┏━┛
 * 　　　　　　　　　┃　　　┃
 * 　　　　　　　　　┃　　　┃ + + + +
 * 　　　　　　　　　┃　　　┃　　　　Code is far away from bug with the animal protecting
 * 　　　　　　　　　┃　　　┃ + 　　　　神兽保佑,代码无bug
 * 　　　　　　　　　┃　　　┃
 * 　　　　　　　　　┃　　　┃　　+
 * 　　　　　　　　　┃　 　　┗━━━┓ + +
 * 　　　　　　　　　┃ 　　　　　　　┣┓
 * 　　　　　　　　　┃ 　　　　　　　┏┛
 * 　　　　　　　　　┗┓┓┏━┳┓┏┛ + + + +
 * 　　　　　　　　　　┃┫┫　┃┫┫
 * 　　　　　　　　　　┗┻┛　┗┻┛+ + + +
 * <p/>
 * Created by R on 16/9/13.
 */

public class NewsReuseFragment extends BaseFragment {
    private ListView mNewsReuseListView;
    private NewsReuseListViewAdapter newsReuseListViewAdapter;
    private String url;
    private String[] urls = {
            //热门精选
            UrlValues.HOT,
            //社会新闻
            UrlValues.SOCIAL,
            //美女图片
            UrlValues.GIRL,
            //体育新闻
            UrlValues.SPORTS,
            //科技新闻
            UrlValues.SCIENCE,
            //国际新闻
            UrlValues.WORLD,
            //奇闻趣事
            UrlValues.INTERESTING,
            //娱乐花边
            UrlValues.ENTERARTAINMENT,
            //苹果新闻
            UrlValues.APPLE,
            //生活健康
            UrlValues.HEALTH

    };
    private static final String NEWS_REUSE_BUNDLE_KEY = "news_reuse_bundle_key";

    @Override
    protected int setLayout() {
        return R.layout.fragment_news_reuse;
    }

    @Override
    protected void initView() {
        mNewsReuseListView = bindView(R.id.fragment_news_reuse_listview);
        newsReuseListViewAdapter = new NewsReuseListViewAdapter();

    }

    @Override
    protected void initData() {
        Bundle bundle = getArguments();
        if (bundle != null) {
            final int position = bundle.getInt(NEWS_REUSE_BUNDLE_KEY);
            url = urls[position] + UrlValues.NUM + 20;

            NetTool.getInstance().startRequest(url, NewsReuseBean.class,
                    new OnHttpCallBack<NewsReuseBean>() {
                        @Override
                        public void onSuccess(NewsReuseBean response) {
                            newsReuseListViewAdapter.setBean(response);
                            mNewsReuseListView.setAdapter(newsReuseListViewAdapter);


                        }

                        @Override
                        public void onError(Throwable e) {

                        }
                    });

        }

    }


    public static NewsReuseFragment newInstance(int position) {
        Bundle bundle = new Bundle();
        bundle.putInt(NEWS_REUSE_BUNDLE_KEY, position);
        NewsReuseFragment homeReuseFragment = new NewsReuseFragment();
        homeReuseFragment.setArguments(bundle);
        return homeReuseFragment;
    }
}
