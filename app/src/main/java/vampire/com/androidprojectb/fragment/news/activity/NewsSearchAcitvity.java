package vampire.com.androidprojectb.fragment.news.activity;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import vampire.com.androidprojectb.R;
import vampire.com.androidprojectb.base.BaseActivity;
import vampire.com.androidprojectb.fragment.news.adapter.NewsReuseListViewAdapter;
import vampire.com.androidprojectb.fragment.news.bean.NewsReuseBean;
import vampire.com.androidprojectb.tool.FormatCodeUtil;
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
 * <p>
 * Created by R on 16/9/22.
 */

public class NewsSearchAcitvity extends BaseActivity implements View.OnClickListener {
    private Button searchButton;
    private EditText searchEditText;
    private ListView searchListView;
    private String searchUrl;
    private NewsReuseListViewAdapter searchAdapter;


    @Override
    protected int setLayout() {
        return R.layout.activity_news_search;
    }

    @Override
    protected void initView() {
        searchButton = bindView(R.id.activity_news_search_button);
        searchEditText = bindView(R.id.activity_news_search_edit_text);
        searchListView = bindView(R.id.activity_news_search_list_view);

    }

    @Override
    protected void initData() {
        searchAdapter = new NewsReuseListViewAdapter(this);
        searchButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.activity_news_search_button:
                String s = searchEditText.getText().toString();
                searchUrl = UrlValues.HOT +UrlValues.NUM +20+UrlValues.WORD+ FormatCodeUtil.codingFormat(s)+UrlValues.SOCIAL_PAGE+10;
                Log.d("NewsSearchAcitvity",  "response:"+searchUrl);
                NetTool.getInstance().startRequest(searchUrl, NewsReuseBean.class,
                        new OnHttpCallBack<NewsReuseBean>() {
                            @Override
                            public void onSuccess(NewsReuseBean response) {
                                if (response.getMsg().equals("success")){
                                    Log.d("NewsSearchAcitvity", "response:" + response);
                                    searchAdapter.setBean(response);
                                    searchListView.setAdapter(searchAdapter);

                                }else{
                                    Toast.makeText(NewsSearchAcitvity.this, "没有搜索到信息", Toast.LENGTH_SHORT).show();
                                }

                            }

                            @Override
                            public void onError(Throwable e) {

                            }
                        });

                break;
        }
    }
}
