package vampire.com.androidprojectb.fragment.recreation.twister;

import android.view.View;
import android.widget.ImageView;

import com.capricorn.RayMenu;
import com.romainpiel.shimmer.Shimmer;
import com.romainpiel.shimmer.ShimmerTextView;

import vampire.com.androidprojectb.MainActivity;
import vampire.com.androidprojectb.R;
import vampire.com.androidprojectb.base.BaseFragment;
import vampire.com.androidprojectb.fragment.recreation.RecreationFragment;

import com.capricorn.TouchAble;

import vampire.com.androidprojectb.tool.dbtool.DBFavorite;
import vampire.com.androidprojectb.tool.dbtool.DBTool;
import vampire.com.androidprojectb.tool.nettool.NetTool;
import vampire.com.androidprojectb.tool.nettool.OnHttpCallBack;
import vampire.com.androidprojectb.values.UrlValues;

/**
 * Created by Vampire on 16/9/14.
 */
public class TwisterFragment extends BaseFragment {
    private static final String TAG = "Vampire_TwisterFragment";
    private ShimmerTextView twisterTV;
    private RayMenu rayMenu;
    private static final int[] ICONS = {R.mipmap.back, R.mipmap.a8p, R.mipmap.next};

    @Override
    protected int setLayout() {
        return R.layout.fragment_twister;
    }

    @Override
    protected void initView() {
        twisterTV = bindView(R.id.tv_twister);
        rayMenu = bindView(R.id.ray_menu);
        TouchAble.moveEvent(rayMenu, getContext());
        Shimmer shimmer = new Shimmer();
        shimmer.setDuration(5000).setStartDelay(1000).setRepeatCount(2).setDirection(Shimmer.ANIMATION_DIRECTION_LTR);
        shimmer.start(twisterTV);
    }

    @Override
    protected void initData() {
        initRayMenu();
        getTwister();

    }

    private void initRayMenu() {
        final int itemCount = ICONS.length;
        for (int i = 0; i < itemCount; i++) {
            final ImageView item = new ImageView(getContext());
            item.setImageResource(ICONS[i]);

            final int position = i;
            rayMenu.addItem(item, new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    switch (position) {
                        case 0:
                            MainActivity mainActivity = (MainActivity) getActivity();
                            mainActivity.upDataFragment(new RecreationFragment());
                            break;
                        case 1:
                            // 收藏
                            DBFavorite dbFavorite =new DBFavorite();
                            dbFavorite.setType("twister");
                            dbFavorite.setTitle(twisterTV.getText().toString());
                            DBTool.getInstance().insertFavorite(dbFavorite);

                            item.setImageResource(R.mipmap.ac7);
                            break;
                        case 2:
                            getTwister();
                            break;
                    }
                }
            });// Add a menu item
        }
    }

    private void getTwister() {
        NetTool.getInstance().startRequest(UrlValues.TONGUE_TWISTER + UrlValues.NUM + 1, TwisterBean.class, new OnHttpCallBack<TwisterBean>() {
            @Override
            public void onSuccess(TwisterBean response) {
                String twister = response.getNewslist().get(0).getContent();

                twister = twister.replaceAll("<br/>", "\n");
//                DBTool.getInstance().getFavorite("twister");
                twisterTV.setText(twister);

            }

            @Override
            public void onError(Throwable e) {

            }
        });
    }


}
