package vampire.com.androidprojectb.activity;

import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import vampire.com.androidprojectb.BuildConfig;
import vampire.com.androidprojectb.R;
import vampire.com.androidprojectb.base.BaseActivity;

import vampire.com.androidprojectb.fragment.topic.Adapter.FindTopicLeftAdapter;

import vampire.com.androidprojectb.fragment.topic.Adapter.FindTopicRightAdapter;
import vampire.com.androidprojectb.fragment.topic.SetTextColor;
import vampire.com.androidprojectb.fragment.topic.bean.FindTopicBean;
import vampire.com.androidprojectb.tool.nettool.NetTool;
import vampire.com.androidprojectb.tool.nettool.OnHttpCallBack;
import vampire.com.androidprojectb.values.UrlValues;

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
public class FindTopicActivity extends BaseActivity {

    private ListView lvLeft;
    private ListView lvright;
    private FindTopicLeftAdapter leftAdapter;
    private FindTopicRightAdapter rightAdapter;
    private int lastPosition;
    private FindTopicBean findTopicBean;
    private List<FindTopicBean.DataBean.ListBean> listBeen;

    @Override
    protected int setLayout() {
        return R.layout.findtopic;
    }

    @Override
    protected void initView() {
        lvLeft = bindView(R.id.find_lv_left);
        lvright = bindView(R.id.find_lv_right);
        leftAdapter = new FindTopicLeftAdapter(this);
        rightAdapter = new FindTopicRightAdapter(this);


    }

    @Override
    protected void initData() {

        lvLeft.setAdapter(leftAdapter);
        lvright.setAdapter(rightAdapter);
        NetTool.getInstance().startRequest(UrlValues.TOPIC_SEARCH, FindTopicBean.class,
                new OnHttpCallBack<FindTopicBean>() {
                    @Override
                    public void onSuccess(FindTopicBean response) {

                        leftAdapter.setLefttBean(response);

                        findTopicBean = response;

                        listBeen = new ArrayList<FindTopicBean.DataBean.ListBean>();
                        listBeen = findTopicBean.getData().get(0).getList();

                        rightAdapter.setListBeen(listBeen);
                        lvright.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                                String id=findTopicBean.getData().get(i).getId();
                                Intent intent=new Intent(FindTopicActivity.this,FindTopicSecondActivity.class);
                                intent.putExtra("id",id);
                                startActivity(intent);
                            }
                        });

                    }


                    @Override
                    public void onError(Throwable e) {

                    }
                });


        lvLeft.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                listBeen = findTopicBean.getData().get(i).getList();

                rightAdapter.setListBeen(listBeen);
               leftAdapter.setSetTextColor(i);


            }
        });


    }


}



