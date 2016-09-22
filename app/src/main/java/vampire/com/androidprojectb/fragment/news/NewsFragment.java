package vampire.com.androidprojectb.fragment.news;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.PopupWindow;

import vampire.com.androidprojectb.R;
import vampire.com.androidprojectb.base.BaseFragment;
import vampire.com.androidprojectb.base.MyApp;
import vampire.com.androidprojectb.fragment.news.activity.NewsSearchAcitvity;
import vampire.com.androidprojectb.fragment.news.activity.TabLayoutTitleActivity;
import vampire.com.androidprojectb.fragment.news.adapter.NewsAdapter;
import vampire.com.androidprojectb.fragment.news.adapter.PopupWindowListViewAdapter;
import vampire.com.androidprojectb.fragment.news.tantan.TanTanAcitivity;

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
    private View view;
    private ListView popWindowListView;
    private PopupWindowListViewAdapter popupWindowListViewAdapter;


    @Override
    protected int setLayout() {
        return R.layout.fragment_news;
    }

    @Override
    protected void initView() {
        view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_news_pop_window, null);
        popWindowListView = (ListView) view.findViewById(R.id.fragment_news_pop_window_list_view);
        button = bindView(R.id.fragment_news_button);
        button.setOnClickListener(this);
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

    }

    @Override
    protected void initData() {
        newsAdapter = new NewsAdapter(getChildFragmentManager());
        mNewsViewPager.setAdapter(newsAdapter);
        mNewsTabLayout.setupWithViewPager(mNewsViewPager);
        newsFragmentPop = createPop();
        popWindowListView.setOnItemClickListener(this);


    }

    @Override
    public void onClick(View v) {
//        if (newsFragmentPop.isShowing()) {
//            newsFragmentPop.dismiss();
//        } else {
//            newsFragmentPop.showAsDropDown(button, 0, 0);
//        }
        Intent intent = new Intent(getActivity(),TabLayoutTitleActivity.class);
        startActivity(intent);
    }

    private PopupWindow createPop() {
        popupWindowListViewAdapter = new PopupWindowListViewAdapter(getContext());
//        popupWindowListViewAdapter.setTitle(newsTitle);
        popWindowListView.setAdapter(popupWindowListViewAdapter);
        PopupWindow pop = new PopupWindow(getContext());

        DisplayMetrics dm = getResources().getDisplayMetrics();
        int w_screen = dm.widthPixels;
        int h_screen = dm.heightPixels;
        pop.setWidth(w_screen);
        pop.setHeight(h_screen);
//        View view2 = LayoutInflater.from(getContext()).inflate(R.layout.fragment_news_pop_window_button, null);
//        view2.findViewById(R.id.fragment_news_pop_window_button).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                newsFragmentPop.dismiss();
//            }
//        });
//        popWindowListView.addHeaderView(view2.findViewById(R.id.fragment_news_pop_window_button));

        pop.setContentView(view);
        // pop.setBackgroundDrawable(new ColorDrawable(0xffffffff));

        return pop;


    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        MyApp.getListTitle().remove(position);
//        popupWindowListViewAdapter.setTitle(MyApp.getListTitle());
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        newsFragmentPop.dismiss();

    }
}