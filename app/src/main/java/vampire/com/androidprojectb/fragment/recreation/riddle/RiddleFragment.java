package vampire.com.androidprojectb.fragment.recreation.riddle;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.capricorn.ArcMenu;

import cn.bmob.v3.a.a.This;
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
public class RiddleFragment extends BaseFragment {
    private static final String TAG = "Vampire_RiddleFragment";
    private TextView riddleTV;
    private TextView requesrTV;
    private ArcMenu arcMenu;
    private static final int[] ICON = new int[]{R.mipmap.back, R.mipmap.request, R.mipmap.a8p, R.mipmap.next};


    @Override
    protected int setLayout() {
        return R.layout.fragment_riddle;
    }

    @Override
    protected void initView() {
        riddleTV = bindView(R.id.tv_riddle);
        requesrTV = bindView(R.id.tv_request);
        arcMenu = bindView(R.id.arc_menu);
    }

    @Override
    protected void initData() {
        setArcMenu(arcMenu, ICON);
        getRiddle();

    }

    private void getRiddle() {
        requesrTV.setVisibility(View.GONE);
        NetTool.getInstance().startRequest(UrlValues.RIDDLE, RiddleBean.class, new OnHttpCallBack<RiddleBean>() {
            @Override
            public void onSuccess(RiddleBean response) {
                riddleTV.setText(response.getNewslist().get(0).getQuest());
                requesrTV.setText("答案: "+response.getNewslist().get(0).getResult());
            }

            @Override
            public void onError(Throwable e) {

            }
        });
    }

    private void setArcMenu(ArcMenu arcMenu, int[] icons) {
        final int itemCount = icons.length;
        for (int i = 0; i < itemCount; i++) {
            ImageView item = new ImageView(getContext());
            item.setImageResource(icons[i]);

            final int position = i;
            final int finalI = i;
            arcMenu.addItem(item, new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    switch (position) {
                        case 0:
                            MainActivity mainActivity = (MainActivity) getActivity();
                            mainActivity.upDataFragment(new RecreationFragment());
                            break;
                        case 1:
                            requesrTV.setVisibility(View.VISIBLE);
                            break;
                        case 3:
                            getRiddle();
                            break;

                    }
//                    Toast.makeText(MainActivity.this, "position:" + position, Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
