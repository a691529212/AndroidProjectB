package vampire.com.androidprojectb.fragment.news.activity;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import vampire.com.androidprojectb.R;
import vampire.com.androidprojectb.base.BaseActivity;
import vampire.com.androidprojectb.base.MyApp;
import vampire.com.androidprojectb.fragment.news.adapter.TitleAdapter;
import vampire.com.androidprojectb.fragment.news.adapter.TitleAddAdapter;
import vampire.com.androidprojectb.fragment.news.adapter.TitleDelAdapter;


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
 * Created by R on 16/9/20.
 */

public class TabLayoutTitleActivity extends BaseActivity {
    private ListView listViewTiTle, listViewAdd, listViewDel;
    private TitleAdapter titleAdapter;
    private TitleAddAdapter titleAddAdapter;
    private TitleDelAdapter titleDelAdapter;


    @Override
    protected int setLayout() {
        return R.layout.activity_tablayout_title;
    }

    @Override
    protected void initView() {
        listViewTiTle = bindView(R.id.tablayout_title);
        listViewAdd = bindView(R.id.tablayout_title_add);
        listViewDel = bindView(R.id.tablayout_title_del);
        listViewTiTle.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(TabLayoutTitleActivity.this, MyApp.getListTitle().get(position), Toast.LENGTH_SHORT).show();
                finish();

            }
        });
        listViewAdd.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(TabLayoutTitleActivity.this, "添加了" + MyApp.getListTitle().get(position), Toast.LENGTH_SHORT).show();

            }
        });
        listViewDel.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                MyApp.getListTitle().remove(position);
                Toast.makeText(TabLayoutTitleActivity.this, "删除了" + MyApp.getListTitle().get(position), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    protected void initData() {
        titleAdapter = new TitleAdapter(this);
        listViewTiTle.setAdapter(titleAdapter);
        titleAddAdapter = new TitleAddAdapter(this);
        listViewAdd.setAdapter(titleAddAdapter);
        titleDelAdapter = new TitleDelAdapter(this);
        listViewDel.setAdapter(titleDelAdapter);

    }


}
