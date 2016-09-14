package vampire.com.androidprojectb.fragment.recreation.twister;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.capricorn.ArcMenu;
import com.capricorn.RayMenu;

import vampire.com.androidprojectb.MainActivity;
import vampire.com.androidprojectb.R;
import vampire.com.androidprojectb.base.BaseFragment;
import vampire.com.androidprojectb.fragment.recreation.RecreationFragment;
import vampire.com.androidprojectb.nettool.NetTool;
import vampire.com.androidprojectb.nettool.OnHttpCallBack;
import vampire.com.androidprojectb.values.UrlValues;

/**
 * Created by Vampire on 16/9/14.
 */
public class TwisterFragment extends BaseFragment {
    private static final String TAG = "Vampire_TwisterFragment";
    private TextView twisterTV;
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
    }

    @Override
    protected void initData() {
        initRayMenu();
        getTwister();

    }

    private void initRayMenu() {
        final int itemCount = ICONS.length;
        for (int i = 0; i < itemCount; i++) {
            ImageView item = new ImageView(getContext());
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
                Log.d(TAG, "twister.indexOf:" + twister.indexOf("<br/>"));
                twister.replaceAll("<br/>","\n");
                twisterTV.setText(response.getNewslist().get(0).getContent());
            }

            @Override
            public void onError(Throwable e) {

            }
        });
    }


}
