package vampire.com.androidprojectb.fragment.news;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.PopupWindow;

import java.util.ArrayList;
import java.util.List;

import vampire.com.androidprojectb.R;
import vampire.com.androidprojectb.base.BaseFragment;
import vampire.com.androidprojectb.fragment.news.adapter.NewsAdapter;
import vampire.com.androidprojectb.fragment.news.adapter.PopupWindowListViewAdapter;
import vampire.com.androidprojectb.values.StringValues;

/**
 * Created by Vampire on 16/9/12.
 */
public class NewsFragment extends BaseFragment implements View.OnClickListener, AdapterView.OnItemClickListener {
    private static final String TAG = "Vampire_NewsFragment";
    private TabLayout mNewsTabLayout;
    private ViewPager mNewsViewPager;
    private NewsAdapter newsAdapter;
    private Button button;
    private PopupWindow newsFragmentPop;
    private  View view;
    private ListView popWindowListView;
    private PopupWindowListViewAdapter popupWindowListViewAdapter;
    private String [] newstitle = StringValues.TITLE;
    private List<String> newsTitle;


    @Override
    protected int setLayout() {
        return R.layout.fragment_news;
    }

    @Override
    protected void initView() {
        view= LayoutInflater.from(getContext()).inflate(R.layout.fragment_news_pop_window,null);
        popWindowListView= (ListView) view.findViewById(R.id.fragment_news_pop_window_list_view);
        button = bindView(R.id.fragment_news_button);
        button.setOnClickListener(this);
        mNewsTabLayout = bindView(R.id.fragment_news_tablayout);
        mNewsViewPager = bindView(R.id.fragment_news_viewpager);
        newsTitle = new ArrayList<>();


    }

    @Override
    protected void initData() {
        newsAdapter = new NewsAdapter(getChildFragmentManager());
        mNewsViewPager.setAdapter(newsAdapter);
        mNewsTabLayout.setupWithViewPager(mNewsViewPager);
        newsFragmentPop= createPop();
        popWindowListView.setOnItemClickListener(this);

        for (int i = 0; i < newstitle.length; i++) {
            newsTitle.add(StringValues.TITLE[i]);
        }


    }

    @Override
    public void onClick(View v) {
        if (newsFragmentPop.isShowing()) {
            newsFragmentPop.dismiss();
        }else {
            newsFragmentPop.showAsDropDown(button,-80,-200);
        }
    }
    private PopupWindow createPop() {
        popupWindowListViewAdapter = new PopupWindowListViewAdapter(getContext());
        popupWindowListViewAdapter.setTitle(newsTitle);
        popWindowListView.setAdapter(popupWindowListViewAdapter);
        PopupWindow pop = new PopupWindow(getContext());
        pop.setWidth(500);
        pop.setHeight(700);
        View view2 = LayoutInflater.from(getContext()).inflate(R.layout.fragment_news_pop_window_button,null);
        view2.findViewById(R.id.fragment_news_pop_window_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newsFragmentPop.dismiss();
            }
        });
        popWindowListView.addHeaderView(view2.findViewById(R.id.fragment_news_pop_window_button));

        pop.setContentView(view);
       // pop.setBackgroundDrawable(new ColorDrawable(0xffffffff));

        return pop;



    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        newsTitle.remove(position);
        popupWindowListViewAdapter.setTitle(newsTitle);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        newsFragmentPop.dismiss();

    }
}