package vampire.com.androidprojectb.activity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import kankan.wheel.BuildConfig;
import vampire.com.androidprojectb.R;
import vampire.com.androidprojectb.base.BaseActivity;
import vampire.com.androidprojectb.fragment.topic.Adapter.AskDownSecondAdapter;
import vampire.com.androidprojectb.fragment.topic.bean.AskDownSecondBean;
import vampire.com.androidprojectb.tool.SeparateListView;
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
public class AskDownSecondActivity extends BaseActivity implements View.OnClickListener {
    private SeparateListView listViewAskDown;
    private TextView textViewName;
    private ImageView imageViewBack;
    private SimpleDraweeView simpleDraweeViewPicUrl;
    private SimpleDraweeView simpleDraweeViewHeadUrl;
    private TextView textViewAlias;
    private TextView textViewDescription;
    private AskDownSecondAdapter downSecondAdapter;
   private LinearLayout ll;
    @Override
    protected int setLayout() {
        return R.layout.ask_down_second;
    }

    @Override
    protected void initView() {
        listViewAskDown = bindView(R.id.lv_ask_down);
        textViewName = bindView(R.id.text_name);
        imageViewBack = bindView(R.id.image_back);
        ll=bindView(R.id.ll);
        downSecondAdapter = new AskDownSecondAdapter(this);

        View view = LayoutInflater.from(this).inflate(R.layout.ask_down_second_head, listViewAskDown, false);
        simpleDraweeViewPicUrl = (SimpleDraweeView) view.findViewById(R.id.drawee_view_pic_url);
        simpleDraweeViewHeadUrl = (SimpleDraweeView) view.findViewById(R.id.drawee_view_image);
        textViewAlias = (TextView) view.findViewById(R.id.text_alias);
        textViewDescription = (TextView) view.findViewById(R.id.text_description);
        listViewAskDown.addHeaderView(view);
    }

    @Override
    protected void initData() {
        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        String name = intent.getStringExtra("name");

        listViewAskDown.setAdapter(downSecondAdapter);
        listViewAskDown.setShowDownAnim(false);
        textViewName.setText(name);
        NetTool.getInstance().startRequest(UrlValues.ASK_DOWN_PREFIXION + id + UrlValues.ASK_DOWN_SUFFIX, AskDownSecondBean.class, new OnHttpCallBack<AskDownSecondBean>() {
            @Override
            public void onSuccess(AskDownSecondBean response) {
                try {
                    textViewAlias.setText(response.getData().getExpert().getAlias());
                    textViewDescription.setText(response.getData().getExpert().getDescription());

                    Log.d("AskDownSecondActivity", response.getData().getExpert().getDescription().toString());
                    Uri uri = Uri.parse(response.getData().getExpert().getHeadpicurl());
                    simpleDraweeViewHeadUrl.setImageURI(uri);
                    Uri uri1 = Uri.parse(response.getData().getExpert().getPicurl());
                    simpleDraweeViewPicUrl.setImageURI(uri1);
                    downSecondAdapter.setDownSecondBean(response);
                } catch (Exception e) {

                }


            }

            @Override
            public void onError(Throwable e) {

            }
        });
         listViewAskDown.setOnScrollListener(new AbsListView.OnScrollListener() {
             float scale=(float)getScrolly()/200;
             float alpha=(225*scale);
             @Override
             public void onScrollStateChanged(AbsListView absListView, int i) {
                 if (absListView.getChildAt(0)!=null){
                     getScrolly();
                     if (getScrolly() <= 0) {
                         ll.setBackgroundColor(Color.argb((int) 0, 227, 29, 26));
                     }else if (getScrolly()>0&&getScrolly()<=200){

                         ll.setBackgroundColor(Color.argb((int)alpha,227,29,26));
                     }else {
                         ll.setBackgroundColor(Color.argb((int)225,227,29,26));
                     }
                 }
             }
             private int getScrolly(){
                 View view=listViewAskDown.getChildAt(0);
                 if (view==null){
                     return  0;

                 }
                 int firstVisiblePosion=listViewAskDown.getFirstVisiblePosition();
                 int top=view.getTop();
                 return  -top+firstVisiblePosion*view.getHeight();
             }

             @Override
             public void onScroll(AbsListView absListView, int i, int i1, int i2) {

             }
         });
        imageViewBack.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        finish();
    }
}
