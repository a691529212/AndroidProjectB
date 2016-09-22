package vampire.com.androidprojectb.fragment.topic;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

import cn.bingoogolapple.bgabanner.BGABanner;
import vampire.com.androidprojectb.R;
import vampire.com.androidprojectb.base.BaseFragment;
import vampire.com.androidprojectb.base.MyApp;
import vampire.com.androidprojectb.fragment.topic.Adapter.VideoAdapter;
import vampire.com.androidprojectb.fragment.topic.bean.VideoBean;
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
public class VideoFragment extends BaseFragment {
    private ListView listViewVideo;
    private VideoAdapter downadapter;
    private BGABanner banner;
    private List<View> mViews = new ArrayList<>();
    private View view;
    private LayoutInflater inflater;


    @Override
    protected int setLayout() {
        return R.layout.topic_video;
    }

    @Override
    protected void initView() {
        listViewVideo = bindView(R.id.lv_topic_video);
        view = LayoutInflater.from(MyApp.getContext()).inflate(R.layout.video_turn_pager, null);
        banner = (BGABanner) view.findViewById(R.id.banner_main_cube);

    }

    @Override
    protected void initData() {
        inflater = LayoutInflater.from(getContext());
        mViews = getViews(3);
        banner.setViews(mViews);
        downadapter = new VideoAdapter(MyApp.getContext());
        listViewVideo.setAdapter(downadapter);

        listViewVideo.addHeaderView(view);

        NetTool.getInstance().startRequest(UrlValues.TOPIC_VIDEO, VideoBean.class, new OnHttpCallBack<VideoBean>() {
            @Override
            public void onSuccess(VideoBean response) {
                downadapter.setBean(response);
                SimpleDraweeView simpleDraweeView;
                for (int i = 0; i < mViews.size(); i++) {
                    simpleDraweeView = (SimpleDraweeView) mViews.get(i);
                    simpleDraweeView.setImageURI(response.getTop().get(i).getImage());
                }
            }

            @Override
            public void onError(Throwable e) {

            }
        });
    }

    private List<View> getViews(int count) {
        List<View> views = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            views.add(inflater.inflate(R.layout.view_image, null));
        }
        return views;
    }
}
