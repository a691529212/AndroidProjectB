package vampire.com.androidprojectb.activity;

import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import vampire.com.androidprojectb.BuildConfig;
import vampire.com.androidprojectb.R;
import vampire.com.androidprojectb.base.BaseActivity;
import vampire.com.androidprojectb.fragment.topic.bean.FindTopicSecondBean;
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
public class FindTopicSecondActivity extends BaseActivity {
    private ListView listViewFindTopic;
    private SimpleDraweeView draweeViewPicUrl;
    private TextView textViewAlias;
    private SimpleDraweeView   draweeViewImage;
    private TextView textViewDescription;
    private ImageView imageViewBack;
    private TextView textViewName;
    @Override
    protected int setLayout() {
        return R.layout.find_topic_second;
    }

    @Override
    protected void initView() {
        listViewFindTopic = bindView(R.id.find_topic_second_lv);
        imageViewBack=bindView(R.id.image_back);
        textViewName=bindView(R.id.text_name);
        View view = LayoutInflater.from(this).inflate(R.layout.find_topic_second_head,null);
        textViewAlias= (TextView) view.findViewById(R.id.text_alias);
        textViewDescription= (TextView) view.findViewById(R.id.text_description);
        draweeViewImage= (SimpleDraweeView) view.findViewById(R.id.drawee_view_image);
        draweeViewPicUrl= (SimpleDraweeView) view.findViewById(R.id.drawee_view_pic_url);
        listViewFindTopic.addHeaderView(view);
    }

    @Override
    protected void initData() {
        Intent intent=getIntent();
        String id=intent.getStringExtra("id");

            Log.d("FindTopicSecondActivity", UrlValues.TOPIC_SEARCH_SECOND_PREFIXION + id + UrlValues.TOPIC_SEARCH_SECOND_SUFFIX);
        NetTool.getInstance().startRequest(UrlValues.TOPIC_SEARCH_SECOND_PREFIXION + id + UrlValues.TOPIC_SEARCH_SECOND_SUFFIX, FindTopicSecondBean.class, new OnHttpCallBack<FindTopicSecondBean>() {
            @Override
            public void onSuccess(FindTopicSecondBean response) {
                textViewName.setText(response.getData().getExpert().getAlias());
                textViewAlias.setText(response.getData().getExpert().getAlias());
                textViewDescription.setText(response.getData().getExpert().getDescription());
                Uri uri=Uri.parse(response.getData().getExpert().getHeadpicurl());
                draweeViewImage.setImageURI(uri);
                Uri uri1=Uri.parse(response.getData().getExpert().getPicurl());
                draweeViewPicUrl.setImageURI(uri1);
            }

            @Override
            public void onError(Throwable e) {

            }
        });
    }
}
