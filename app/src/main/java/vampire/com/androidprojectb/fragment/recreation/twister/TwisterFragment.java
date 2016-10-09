package vampire.com.androidprojectb.fragment.recreation.twister;

import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.AlertDialog;
import android.app.Dialog;
import android.os.AsyncTask;
import android.text.Editable;
import android.text.Layout;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

import com.capricorn.RayLayout;
import com.capricorn.RayMenu;
import com.romainpiel.shimmer.Shimmer;
import com.romainpiel.shimmer.ShimmerTextView;

import app.dinus.com.loadingdrawable.render.LoadingDrawable;
import rx.functions.Action1;
import vampire.com.androidprojectb.MainActivity;
import vampire.com.androidprojectb.R;
import vampire.com.androidprojectb.base.BaseFragment;
import vampire.com.androidprojectb.fragment.recreation.RecreationFragment;

import com.capricorn.TouchAble;

import java.util.List;
import java.util.Random;

import vampire.com.androidprojectb.fragment.recreation.Title;
import vampire.com.androidprojectb.tool.MyTextView;
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
    private MyTextView twisterTV;
    private RayMenu rayMenu;
    private static int[] ICONS = {R.mipmap.back, R.mipmap.a8p, R.mipmap.next};
    private Title title;
    private boolean isFavorite = false;
    private RayLayout rayLayout;
    private Shimmer shimmer;
    private String twister;
    private AlertDialog.Builder builder;


    @Override
    protected int setLayout() {
        return R.layout.fragment_twister;
    }

    @Override
    protected void initView() {
        twisterTV = bindView(R.id.tv_twister);
        rayMenu = bindView(R.id.ray_menu);
        TouchAble.moveEvent(rayMenu, getContext());
        shimmer = new Shimmer();
        shimmer.setDuration(5000).setStartDelay(1000).setRepeatCount(2).setDirection(Shimmer.ANIMATION_DIRECTION_LTR);
        shimmer.start(twisterTV);


    }

    @Override
    protected void initData() {
        initRayMenu();
        getTwister();
        // 将标题栏显示
        final MainActivity mainActivity = (MainActivity) getActivity();
        title = new Title(getContext(), twisterTV.getText().toString());
        title.setTitle(mainActivity);
        rayLayout = rayMenu.getmRayLayout();

    }

    private void initRayMenu() {
        if (rayLayout != null) {
            rayLayout.removeAllViews();
        }

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
                            if (isFavorite) {
                                DBTool.getInstance().delFavoriteByTitle(twisterTV.getText().toString());
                                item.setImageResource(R.mipmap.a8p);
                                isFavorite = false;
                            } else {
                                // 收藏
                                DBFavorite dbFavorite = new DBFavorite();
                                dbFavorite.setType("twister");
                                dbFavorite.setTitle(twister);
                                DBTool.getInstance().insertFavorite(dbFavorite);
                                item.setImageResource(R.mipmap.ac7);
                                isFavorite = true;
                            }
                            break;

                        case 2:
                            getTwister();
                            break;
                    }
                }
            });// Add a menu item
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    private void getTwister() {

        NetTool.getInstance().startRequest(UrlValues.TONGUE_TWISTER + UrlValues.NUM + 1, TwisterBean.class, new OnHttpCallBack<TwisterBean>() {

            @Override
            public void onSuccess(TwisterBean response) {

                twisterTV.setText("");
                twister = response.getNewslist().get(0).getContent();

                twister = twister.replaceAll("<br/>", "\n");
                DBTool.getInstance().getFavoriteByTitle("twister", twister, new Action1<List<DBFavorite>>() {

                    @Override
                    public void call(List<DBFavorite> dbFavorites) {
                        if (dbFavorites.size() > 0) {
                            ICONS = new int[]{R.mipmap.back, R.mipmap.ac7, R.mipmap.next};
                            initRayMenu();
                            isFavorite = true;
                            Log.d(TAG, "收藏");
                        } else {
                            ICONS = new int[]{R.mipmap.back, R.mipmap.a8p, R.mipmap.next};
                            initRayMenu();
                            isFavorite = false;
                            Log.d(TAG, "未收藏");
                        }
                    }
                });

                //蹦字儿
                String s = new String();
                for (int i = 0; i < twister.length(); i++) {
                    s = twister.substring(i,i+1);
                    UpDateText upDateText = new UpDateText();
                    upDateText.execute(s);
                }

                title.setSpeak(twister);

            }

            @Override
            public void onError(Throwable e) {

            }
        });

        //没什么卵用
        twisterTV.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

//                world = (String) s.subSequence(before,count);
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

    private class UpDateText extends AsyncTask<String, String, String> {

        @Override
        protected String doInBackground(String... params) {

                try {
                    Thread.sleep(300);
                    String s = params[0];
                    return s;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            twisterTV.setText(twisterTV.getText().toString()+s);
            shimmer.setDuration(5000).setStartDelay(1000).setRepeatCount(2).setDirection(Shimmer.ANIMATION_DIRECTION_LTR);
            shimmer.start(twisterTV);
        }
    }

}
