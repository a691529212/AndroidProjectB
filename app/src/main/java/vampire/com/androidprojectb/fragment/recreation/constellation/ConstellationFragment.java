package vampire.com.androidprojectb.fragment.recreation.constellation;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.facebook.shimmer.ShimmerFrameLayout;

import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.List;

import kankan.wheel.widget.WheelView;
import vampire.com.androidprojectb.R;
import vampire.com.androidprojectb.base.BaseFragment;
import vampire.com.androidprojectb.base.CommonAdapter;
import vampire.com.androidprojectb.base.CommonViewHolder;
import vampire.com.androidprojectb.tool.nettool.NetTool;
import vampire.com.androidprojectb.tool.nettool.OnHttpCallBack;
import vampire.com.androidprojectb.values.UrlValues;

/**
 * Created by Vampire on 16/9/19.
 */
public class ConstellationFragment extends BaseFragment {
    private static final String TAG = "Vampire_ConstellationFragment";
    private WheelView targetConstellation;
    private WheelView mineConstellation;
    String[] constellations = {"巨蟹", "狮子", "处女", "天秤", "天蝎", "射手", "魔蝎", "水瓶", "双鱼", "白羊", "金牛", "双子"};
    String[] constellationsForTarget = {"ALL", "巨蟹", "狮子", "处女", "天秤", "天蝎", "射手", "魔蝎", "水瓶", "双鱼", "白羊", "金牛", "双子"};
    private ShimmerFrameLayout frameLayout;
    private Button btnZzz;
    private ListView listView;

    @Override
    protected int setLayout() {
        return R.layout.fragment_constellation;
    }

    @Override
    protected void initView() {
        frameLayout = bindView(R.id.text_layout);
        frameLayout.startShimmerAnimation();
        listView = bindView(R.id.lv_constellation);


        btnZzz = bindView(R.id.btn_constellation);

        mineConstellation = bindView(R.id.mine);
        targetConstellation = bindView(R.id.target);

        ConstellationArrayAdapter adapter = new ConstellationArrayAdapter(getContext(), constellations, 0);
        mineConstellation.setViewAdapter(adapter);
        TargetConstellationArrayAdapter targetAdapter = new TargetConstellationArrayAdapter(getContext(), constellationsForTarget, 0);
        targetConstellation.setViewAdapter(targetAdapter);
    }

    @Override
    protected void initData() {
        btnZzz.setOnClickListener(new View.OnClickListener() {


            private String url;

            @Override
            public void onClick(View v) {
                switch (targetConstellation.getCurrentItem()) {
                    case 0:
                        url = UrlValues.CONSTELLATION + UrlValues.ME + constellations[mineConstellation.getCurrentItem()] + UrlValues.all;
                        break;
                    default:
                        url = UrlValues.CONSTELLATION + UrlValues.ME + constellations[mineConstellation.getCurrentItem()] + UrlValues.HE +
                                constellationsForTarget[targetConstellation.getCurrentItem()];
                        break;
                }
                NetTool.getInstance().startRequest(url, ConstellationBean.class, new OnHttpCallBack<ConstellationBean>() {
                    @Override
                    public void onSuccess(ConstellationBean response) {
                        Log.d(TAG, "response.getNewslist()==null:" + (response.getNewslist() == null));
                        List<ConstellationBean.NewslistBean> constellationBeanList = response.getNewslist();
                        CommonAdapter<ConstellationBean.NewslistBean> commonAdapter = new CommonAdapter<ConstellationBean.NewslistBean>(constellationBeanList,
                                getContext(), R.layout.item_for_constellation) {

                            @Override
                            public void setData(ConstellationBean.NewslistBean newslistBean, CommonViewHolder viewHolder) {

                                viewHolder.setText(R.id.tv_constellation_title, newslistBean.getTitle());
                                viewHolder.setText(R.id.tv_constellation_grade, newslistBean.getGrade());
                                viewHolder.setText(R.id.tv_constellation_request, newslistBean.getContent());
                            }
                        };
                        listView.setAdapter(commonAdapter);

                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
            }
        });

    }
}
