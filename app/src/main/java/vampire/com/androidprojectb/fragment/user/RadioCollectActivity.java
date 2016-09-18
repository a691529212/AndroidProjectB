package vampire.com.androidprojectb.fragment.user;

import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import vampire.com.androidprojectb.R;
import vampire.com.androidprojectb.base.BaseActivity;

/**
 * code is far away from bug with the animal protecting
 * <p>
 * ┏┓　　　┏┓
 * ┏┛┻━━━┛┻┓
 * ┃　　　　　　　┃
 * ┃　　　━　　　┃
 * ┃　┳┛　┗┳　┃
 * ┃　　　　　　　┃
 * ┃　　　┻　　　┃
 * ┃　　　　　　　┃
 * ┗━┓　　　┏━┛
 * 　　┃　　　┃神兽保佑
 * 　　┃　　　┃永无BUG！  凯哥 祝你一路顺风
 * 　　┃　　　┗━━━┓
 * 　　┃　　　　　　　┣┓
 * 　　┃　　　　　　　┏┛
 * 　　┗┓┓┏━┳┓┏┛
 * 　　　┃┫┫　┃┫┫
 * 　　　┗┻┛　┗┻┛
 */
public class RadioCollectActivity extends BaseActivity implements View.OnClickListener {
    private TabLayout tabCollect;
    private ViewPager vpCollect;
    private ArrayList<Fragment> fragments;
    private ArrayList<String> arrayList;
    private CollectAdapter collectAdapter;
    private ImageView imageViewBack;
    @Override
    protected int setLayout() {
        return R.layout.radiocollect;
    }

    @Override
    protected void initView() {
        tabCollect = bindView(R.id.tab_collect);
        vpCollect = bindView(R.id.vp_collect);
        imageViewBack=bindView(R.id.image_back);

    }

    @Override
    protected void initData() {

        fragments = new ArrayList<>();
        fragments.add(new NewsCollectFragment());
        fragments.add(new CommentCollectFragment());
        fragments.add(new PhotoCollectFragment());

        arrayList=new ArrayList<>();
        arrayList.add("新闻");
        arrayList.add("跟帖");
        arrayList.add("图片");
        collectAdapter=new CollectAdapter(getSupportFragmentManager(),getApplicationContext());
        collectAdapter.setArrayList(arrayList);
        collectAdapter.setFragments(fragments);
        vpCollect.setAdapter(collectAdapter);
        tabCollect.setupWithViewPager(vpCollect);
        tabCollect.setSelectedTabIndicatorColor(Color.RED);
        tabCollect.setTabTextColors(0x88AAAAAA,Color.RED);
        imageViewBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        finish();
    }
}
