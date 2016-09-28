package vampire.com.androidprojectb.fragment.news.tantan;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import vampire.com.androidprojectb.R;
import vampire.com.androidprojectb.base.BaseActivity;
import vampire.com.androidprojectb.fragment.news.activity.NewsDetailActivity;
import vampire.com.androidprojectb.fragment.news.bean.NewsReuseBean;
import vampire.com.androidprojectb.fragment.news.flingswipe.SwipeFlingAdapterView;
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
 * Created by R on 16/9/21.
 */

public class TanTanAcitivity extends BaseActivity implements SwipeFlingAdapterView.onFlingListener {
    private ImageView left, right;
    private SwipeFlingAdapterView flingContainer;
    private CardAdapter adapter;


    @Override
    protected int setLayout() {
        return R.layout.activity_tantan;
    }

    @Override
    protected void initView() {
        left = (ImageView) findViewById(R.id.left);
        right = (ImageView) findViewById(R.id.right);
        flingContainer = (SwipeFlingAdapterView) findViewById(R.id.frame);
        adapter = new CardAdapter(this);
        flingContainer.init(this,adapter);
        flingContainer.setAdapter(adapter);


    }

    @Override
    protected void initData() {
        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                left();
            }
        });
        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                right();
            }
        });
        String url = UrlValues.HOT+ UrlValues.NUM + 50;
        NetTool.getInstance().startRequest(url, NewsReuseBean.class,
                new OnHttpCallBack<NewsReuseBean>() {
                    @Override
                    public void onSuccess(final NewsReuseBean response) {
                        adapter.setmCardList(response);
                        swipeFling(response);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });


    }


    public void right() {
        flingContainer.getTopCardListener().selectRight();
    }

    public void left() {
        flingContainer.getTopCardListener().selectLeft();
    }

    public void swipeFling(final NewsReuseBean response) {

        flingContainer.setFlingListener(new SwipeFlingAdapterView.onFlingListener() {
            @Override
            public void removeFirstObjectInAdapter() {

                adapter.notifyDataSetChanged();
            }
            @Override
            public void onLeftCardExit(Object dataObject) {
                Toast.makeText(TanTanAcitivity.this, "不喜欢", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onRightCardExit(Object dataObject) {
                Toast.makeText(TanTanAcitivity.this, "喜欢", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdapterAboutToEmpty(int itemsInAdapter) {
                adapter.notifyDataSetChanged();

            }

            @Override
            public void onScroll(float scrollProgressPercent) {
                View view = flingContainer.getSelectedView();
                view.findViewById(R.id.item_swipe_right_indicator).setAlpha(scrollProgressPercent < 0 ? -scrollProgressPercent : 0);
                view.findViewById(R.id.item_swipe_left_indicator).setAlpha(scrollProgressPercent > 0 ? scrollProgressPercent : 0);
            }
        });
        flingContainer.setOnItemClickListener(new SwipeFlingAdapterView.OnItemClickListener() {
            @Override
            public void onItemClicked(int itemPosition, Object dataObject) {
                Toast.makeText(TanTanAcitivity.this, "点击图片", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(TanTanAcitivity.this, NewsDetailActivity.class);
                String detailUrl = response.getNewslist().get(itemPosition).getUrl();
                detailUrl.replaceAll(" +", "");
                intent.putExtra(NewsDetailActivity.NEWS_DETAIL_KEY, detailUrl);
                startActivity(intent);
            }
        });

    }

    @Override
    public void removeFirstObjectInAdapter() {

    }

    @Override
    public void onLeftCardExit(Object dataObject) {

    }

    @Override
    public void onRightCardExit(Object dataObject) {

    }

    @Override
    public void onAdapterAboutToEmpty(int itemsInAdapter) {

    }

    @Override
    public void onScroll(float scrollProgressPercent) {

    }
}
