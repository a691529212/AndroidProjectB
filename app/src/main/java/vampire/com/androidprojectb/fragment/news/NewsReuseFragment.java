package vampire.com.androidprojectb.fragment.news;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import vampire.com.androidprojectb.R;
import vampire.com.androidprojectb.base.BaseFragment;
import vampire.com.androidprojectb.base.MyApp;
import vampire.com.androidprojectb.fragment.news.activity.NewsDetailActivity;
import vampire.com.androidprojectb.fragment.news.adapter.NewsReuseListViewAdapter;
import vampire.com.androidprojectb.fragment.news.bean.NewsReuseBean;
import vampire.com.androidprojectb.tool.nettool.NetTool;
import vampire.com.androidprojectb.tool.nettool.OnHttpCallBack;
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

    private static final String NEWS_REUSE_BUNDLE_KEY = "news_reuse_bundle_key";

    @Override
    protected int setLayout() {
        return R.layout.fragment_news_reuse;
    }

    @Override
    protected void initView() {

        mNewsReuseListView = bindView(R.id.fragment_news_reuse_listview);


    }

    @Override
    protected void initData() {
        Bundle bundle = getArguments();
        if (bundle != null) {
            final int position = bundle.getInt(NEWS_REUSE_BUNDLE_KEY);
            String title =   MyApp.getListTitle().get(position);
            url =  MyApp.getHasMapTitle().get(title)+ UrlValues.NUM + 50;
            Log.d("NewsReuseFragment---", url);
            //  url = urls[position] + UrlValues.NUM + 20;
            NetTool.getInstance().startRequest(url, NewsReuseBean.class,
                    new OnHttpCallBack<NewsReuseBean>() {
                        @Override
                        public void onSuccess(final NewsReuseBean response) {
                            newsReuseListViewAdapter = new NewsReuseListViewAdapter(getContext());
                            newsReuseListViewAdapter.setBean(response);
                            mNewsReuseListView.setAdapter(newsReuseListViewAdapter);
                            mNewsReuseListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                @Override
                                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                    Intent intent = new Intent(getActivity(), NewsDetailActivity.class);
                                    String detailUrl = response.getNewslist().get(position).getUrl();
                                    detailUrl.replaceAll(" +", "");
                                    intent.putExtra(NewsDetailActivity.NEWS_DETAIL_KEY, detailUrl);
                                    startActivity(intent);
                                }
                            });
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
