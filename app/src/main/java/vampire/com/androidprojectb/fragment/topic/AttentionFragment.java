package vampire.com.androidprojectb.fragment.topic;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import rx.functions.Action1;
import vampire.com.androidprojectb.R;
import vampire.com.androidprojectb.activity.FindTopicActivity;
import vampire.com.androidprojectb.base.BaseFragment;
import vampire.com.androidprojectb.fragment.topic.Adapter.AttentionLvAdapter;
import vampire.com.androidprojectb.tool.dbtool.DBFavorite;
import vampire.com.androidprojectb.tool.dbtool.DBTool;

/**
 * code is far away from bug with the animal protecting
 * <p/>
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
public class AttentionFragment extends BaseFragment implements View.OnClickListener {

    private TextView textViewGoAttention;
    private ListView listViewAttention;
    private AttentionLvAdapter attentionLvAdapter;
    private View view;
    private DBFavorite dbFavorite;

    @Override
    protected int setLayout() {
        return R.layout.topic_attention;
    }

    @Override
    protected void initView() {
        listViewAttention = bindView(R.id.attention_lv);
        dbFavorite = new DBFavorite();
        attentionLvAdapter = new AttentionLvAdapter(mContext);
        view = LayoutInflater.from(mContext).inflate(R.layout.topic_attention_head, null);
        textViewGoAttention = (TextView) view.findViewById(R.id.text_go_attention);
        listViewAttention.addHeaderView(view);
        listViewAttention.setAdapter(attentionLvAdapter);
    }

    @Override
    protected void initData() {

        textViewGoAttention.setOnClickListener(this);

        DBTool.getInstance().getFavorite("问吧第二界面的收藏", new Action1<List<DBFavorite>>() {
            @Override
            public void call(List<DBFavorite> dbFavorites) {
                if (dbFavorites.size() == 0) {
                    view.setVisibility(View.VISIBLE);
                } else {
                    attentionLvAdapter.setFavorites(dbFavorites);
                    view.setVisibility(View.GONE);
                }

            }
        });
        listViewAttention.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                    DBTool.getInstance().delFavorite(dbFavorite.getUrl());
                    attentionLvAdapter.deletePos(i);


            }
        });

    }


    @Override
    public void onClick(View view) {
        Intent intent = new Intent(mContext, FindTopicActivity.class);
        startActivity(intent);
    }
}
