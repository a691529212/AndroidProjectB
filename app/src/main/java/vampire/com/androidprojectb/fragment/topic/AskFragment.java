package vampire.com.androidprojectb.fragment.topic;

import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;

import com.roger.catloadinglibrary.CatLoadingView;

import vampire.com.androidprojectb.R;
import vampire.com.androidprojectb.activity.AskDownSecondActivity;
import vampire.com.androidprojectb.activity.AskUpSecondActivity;
import vampire.com.androidprojectb.base.BaseFragment;
import vampire.com.androidprojectb.base.MyApp;
import vampire.com.androidprojectb.fragment.topic.Adapter.AskDownAdapter;
import vampire.com.androidprojectb.fragment.topic.Adapter.AskRvUpAdapter;
import vampire.com.androidprojectb.fragment.topic.bean.AskDownBean;
import vampire.com.androidprojectb.fragment.topic.bean.AskUpBean;
import vampire.com.androidprojectb.tool.nettool.NetTool;
import vampire.com.androidprojectb.tool.nettool.OnHttpCallBack;
import vampire.com.androidprojectb.values.UrlValues;

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
public class AskFragment extends BaseFragment {
    private ListView listViewAsk;
    private RecyclerView recyclerViewAskHead;
    private View view;
    private GridLayoutManager manager;
    private AskRvUpAdapter upAdapter;
    private CatLoadingView mViews;
    private int temp ;
    @Override
    protected int setLayout() {
        return R.layout.topic_ask;
    }

    @Override
    protected void initView() {
        listViewAsk = bindView(R.id.ask_listview);
        mViews=new CatLoadingView();
        mViews.show(getFragmentManager(),"");
        view = LayoutInflater.from(MyApp.getContext()).inflate(R.layout.ask_head_view,null);
        recyclerViewAskHead= (RecyclerView) view.findViewById(R.id.rv_ask_head);

        manager = new GridLayoutManager(MyApp.getContext(),5);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        upAdapter = new AskRvUpAdapter(getContext());
        final ImageView imageViewIv = (ImageView) view.findViewById(R.id.iv_btn);

        imageViewIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //下面的temp等于0是代表else后面的temp=0
                if (temp == 0){
                    upAdapter.setCoutnt(15);
                    temp =1;
                    imageViewIv.setImageResource(R.mipmap.a3a);

                }else {
                    upAdapter.setCoutnt(5);
                    temp =0;
                    imageViewIv.setImageResource(R.mipmap.a3_);

                }

            }
        });
    }


    @Override
    protected void initData() {
        recyclerViewAskHead.setLayoutManager(manager);
        recyclerViewAskHead.setAdapter(upAdapter);
//        upAdapter.setCoutnt(5);
         NetTool.getInstance().startRequest(UrlValues.ASK_UP, AskUpBean.class, new OnHttpCallBack<AskUpBean>() {
             @Override
             public void onSuccess(final AskUpBean response) {
                 upAdapter.setUpBean(response);
                 mViews.dismiss();

                 mViews.dismissAllowingStateLoss();
                 upAdapter.setOnItemOclickAsk(new AskRvUpAdapter.OnItemOclickAsk() {
                     @Override
                     public void ItemOnClick(int pos) {
                         String idUrl=response.getData().get(pos).getId();
                         String nameUrl=response.getData().get(pos).getName();
                         Intent intent=new Intent(mContext,AskUpSecondActivity.class);
                         intent.putExtra("id",idUrl);
                         intent.putExtra("name",nameUrl);
                         startActivity(intent);
                     }
                 });
             }

             @Override
             public void onError(Throwable e) {

             }
         });
        final AskDownAdapter downAdapter=new AskDownAdapter(getContext());

        listViewAsk.setAdapter(downAdapter);
        listViewAsk.addHeaderView(view);
        NetTool.getInstance().startRequest(UrlValues.ASK_DOWN, AskDownBean.class, new OnHttpCallBack<AskDownBean>() {
            @Override
            public void onSuccess(final AskDownBean response) {
                downAdapter.setAskDownBean(response);
                downAdapter.setDownOnClick(new AskDownAdapter.CardViewAskDownOnClick() {
                    @Override
                    public void ItemOclick(int pos) {
                        String idUrl=response.getData().getExpertList().get(pos).getExpertId();
                        String nameUrl=response.getData().getExpertList().get(pos).getAlias();
                        String photoUrl=response.getData().getExpertList().get(pos).getPicurl();
                        Intent intent=new Intent(mContext, AskDownSecondActivity.class);
                        intent.putExtra("id",idUrl);
                        intent.putExtra("name",nameUrl);
                        intent.putExtra("photo",photoUrl);
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
