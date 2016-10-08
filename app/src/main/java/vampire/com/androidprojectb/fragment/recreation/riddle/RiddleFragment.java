package vampire.com.androidprojectb.fragment.recreation.riddle;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.capricorn.ArcLayout;
import com.capricorn.ArcMenu;
import com.romainpiel.shimmer.Shimmer;
import com.romainpiel.shimmer.ShimmerTextView;

import rx.functions.Action1;
import vampire.com.androidprojectb.MainActivity;
import vampire.com.androidprojectb.R;
import vampire.com.androidprojectb.base.BaseFragment;
import vampire.com.androidprojectb.fragment.recreation.RecreationFragment;

import com.capricorn.TouchAble;

import java.util.List;

import vampire.com.androidprojectb.fragment.recreation.Title;
import vampire.com.androidprojectb.tool.dbtool.DBFavorite;
import vampire.com.androidprojectb.tool.dbtool.DBTool;
import vampire.com.androidprojectb.tool.nettool.NetTool;
import vampire.com.androidprojectb.tool.nettool.OnHttpCallBack;
import vampire.com.androidprojectb.values.UrlValues;

/**
 * Created by Vampire on 16/9/14.
 */
public class RiddleFragment extends BaseFragment {
    private static final String TAG = "Vampire_RiddleFragment";
    private ShimmerTextView riddleTV;
    private ShimmerTextView requesrTV;
    private ArcMenu arcMenu;
    private int[] iocn = new int[]{R.mipmap.back, R.mipmap.request, R.mipmap.a8p, R.mipmap.next};
    private Title title;
    private boolean isFavorite = false;
    private ArcLayout arcLayout;


    @Override
    protected int setLayout() {
        return R.layout.fragment_riddle;
    }

    @Override
    protected void initView() {
        riddleTV = bindView(R.id.tv_riddle);
        requesrTV = bindView(R.id.tv_request);
        arcMenu = bindView(R.id.arc_menu);
//        arcMenu.getControlLayout().setOnLongClickListener();
//        arcMenu.setOnLongClickListener(new View.OnLongClickListener() {
//            @Override
//            public boolean onLongClick(View v) {
//                Log.d(TAG, "vampire");
//                arcMenu.setClickable(true);
//                TouchAble.moveEvent(arcMenu,getContext());
//                return true;
//            }
//        });

        Shimmer shimmer = new Shimmer();
        shimmer.setDuration(5000).setStartDelay(1000).setRepeatCount(2).setDirection(Shimmer.ANIMATION_DIRECTION_LTR);
        shimmer.start(requesrTV);
        shimmer.start(riddleTV);
    }

    @Override
    protected void initData() {
        setArcMenu(arcMenu, iocn);
        getRiddle();
        // 将标题栏显示
        final MainActivity mainActivity = (MainActivity) getActivity();
        title = new Title(getContext(), requesrTV.getText().toString());
        title.setTitle(mainActivity);

        arcLayout = arcMenu.getmArcLayout();

    }

    private void getRiddle() {
        requesrTV.setVisibility(View.GONE);
        NetTool.getInstance().startRequest(UrlValues.RIDDLE, RiddleBean.class, new OnHttpCallBack<RiddleBean>() {
            @Override
            public void onSuccess(RiddleBean response) {
                riddleTV.setText(response.getNewslist().get(0).getQuest());
                requesrTV.setText("答案: " + response.getNewslist().get(0).getResult());
                title.setSpeak(riddleTV.getText().toString());
                DBTool.getInstance().getFavoriteByTitle("riddle", riddleTV.getText().toString(), new Action1<List<DBFavorite>>() {
                    @Override
                    public void call(List<DBFavorite> dbFavorites) {
                        if (dbFavorites.size() > 0) {
                            iocn = new int[]{R.mipmap.back, R.mipmap.request, R.mipmap.ac7, R.mipmap.next};
                            setArcMenu(arcMenu, iocn);
//                            iocn[2] = R.mipmap.ac7;
                            Log.d(TAG, "has");
                            isFavorite = true;

                        } else {
//                            iocn[2] = R.mipmap.a8p;
                            Log.d(TAG, "not");
                            iocn = new int[]{R.mipmap.back, R.mipmap.request, R.mipmap.a8p, R.mipmap.next};
                            isFavorite = false;
                            setArcMenu(arcMenu, iocn);

                        }
                    }
                });
            }

            @Override
            public void onError(Throwable e) {

            }
        });
    }

    private void setArcMenu(final ArcMenu arcMenu, int[] icons) {
        final int itemCount = icons.length;
        if (arcLayout!=null){
            arcLayout.removeAllViews();
        }
        for (int i = 0; i < itemCount; i++) {
            ImageView item = new ImageView(getContext());
            item.setImageResource(icons[i]);

            final int position = i;

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
                            mainActivity = (MainActivity) getActivity();
                            title.setSpeak(requesrTV.getText().toString());
                            title.setTitle(mainActivity);
                            break;
                        case 2:
                            if (isFavorite) {
                                Log.d(TAG, "isFavorite");
                                DBTool.getInstance().delFavorite(requesrTV.getText().toString());
                                iocn = new int[]{R.mipmap.back, R.mipmap.request, R.mipmap.a8p, R.mipmap.next};
                                setArcMenu(arcMenu, iocn);

                                isFavorite = false;
                            } else {
                                Log.d(TAG, "NotFavorite");
                                DBFavorite dbFavorite = new DBFavorite();
                                dbFavorite.setType("riddle");
                                dbFavorite.setTitle(riddleTV.getText().toString());
                                dbFavorite.setUrl(requesrTV.getText().toString());
                                DBTool.getInstance().insertFavorite(dbFavorite);

                                iocn = new int[]{R.mipmap.back, R.mipmap.request, R.mipmap.ac7, R.mipmap.next};
                                isFavorite = true;
                                setArcMenu(arcMenu, iocn);
                            }
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
