package vampire.com.androidprojectb.fragment.recreation.dream;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.iflytek.cloud.SpeechConstant;
import com.iflytek.cloud.SpeechSynthesizer;
import com.romainpiel.shimmer.Shimmer;
import com.romainpiel.shimmer.ShimmerTextView;
import com.yalantis.contextmenu.lib.ContextMenuDialogFragment;
import com.yalantis.contextmenu.lib.interfaces.OnMenuItemClickListener;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import vampire.com.androidprojectb.MainActivity;
import vampire.com.androidprojectb.R;
import vampire.com.androidprojectb.base.BaseFragment;
import vampire.com.androidprojectb.base.CommonAdapter;
import vampire.com.androidprojectb.base.CommonViewHolder;
import vampire.com.androidprojectb.fragment.recreation.RecreationFragment;
import vampire.com.androidprojectb.fragment.recreation.SendMessage;
import vampire.com.androidprojectb.fragment.recreation.Title;
import vampire.com.androidprojectb.tool.ContextMenu;
import vampire.com.androidprojectb.tool.FormatCodeUtil;
import vampire.com.androidprojectb.tool.Speaker;
import vampire.com.androidprojectb.tool.dbtool.DBFavorite;
import vampire.com.androidprojectb.tool.dbtool.DBTool;
import vampire.com.androidprojectb.tool.nettool.NetTool;
import vampire.com.androidprojectb.tool.nettool.OnHttpCallBack;
import vampire.com.androidprojectb.values.StringValues;
import vampire.com.androidprojectb.values.UrlValues;

/**
 * Created by Vampire on 16/9/19.
 */
public class DreamFragment extends BaseFragment {
    private static final String TAG = "Vampire_DreamFragment";
    private ShimmerTextView requestTv;
    private Button dreamBtn;
    private me.james.biuedittext.BiuEditText dreamEt;
    private ShimmerTextView titleTv;
    private ListView searchListView;
    private List<DreamBean.NewslistBean> newslistBeen;
    private AbstractDraweeController draweeController;
    private SimpleDraweeView simpleDraweeView;
    private SimpleDraweeView simpleDraweeView_left;
    private SimpleDraweeView simpleDraweeView_right;
    private Title title;
    private final Uri uri = Uri.parse("http://img5.imgtn.bdimg.com/it/u=283959817,3530741872&fm=21&gp=0.jpg");
    private AbstractDraweeController draweeController_left;
    private AbstractDraweeController draweeController_right;


    @Override
    protected int setLayout() {
        return R.layout.fragment_dream;
    }

    @Override
    protected void initView() {

        simpleDraweeView = bindView(R.id.iv_head);
        simpleDraweeView_left = bindView(R.id.iv_head_left);
        simpleDraweeView_right = bindView(R.id.iv_head_right);
        searchListView = bindView(R.id.lv_dream_search);
        requestTv = bindView(R.id.tv_dream_request);
        titleTv = bindView(R.id.tv_dream_title);
        dreamBtn = bindView(R.id.btn_dream);
        dreamEt = bindView(R.id.et_dream);
        dreamEt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dreamEt.setFocusable(true);
            }
        });
    }

    @Override
    protected void initData() {
        dreamBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 停止摇摆
                dreamEt.setCursorVisible(false);
                draweeController = Fresco.newDraweeControllerBuilder().setAutoPlayAnimations(false).setUri(uri).build();
                draweeController_left = Fresco.newDraweeControllerBuilder().setAutoPlayAnimations(false).setUri(uri).build();
                draweeController_right = Fresco.newDraweeControllerBuilder().setAutoPlayAnimations(false).setUri(uri).build();
                simpleDraweeView.setController(draweeController);
                simpleDraweeView_left.setController(draweeController_left);
                simpleDraweeView_right.setController(draweeController_right);

                // 网络请求
                NetTool.getInstance().startRequest(UrlValues.DREAM + UrlValues.DREAM_WORD + FormatCodeUtil.codingFormat(dreamEt.getText().toString()),
                        DreamBean.class, new OnHttpCallBack<DreamBean>() {
                            @Override
                            public void onSuccess(DreamBean response) {
                                if (response.getNewslist() != null) {
                                    requestTv.setText(response.getNewslist().get(0).getResult());
                                    titleTv.setText(response.getNewslist().get(0).getTitle());
                                } else {
                                    requestTv.setText(StringValues.MOTET);
                                    titleTv.setText("波若波罗蜜心经");
                                }
                                Shimmer shimmer = new Shimmer();
                                shimmer.setDuration(6000).setStartDelay(300).setDirection(Shimmer.ANIMATION_DIRECTION_LTR);// left tp right
                                shimmer.start(requestTv);
                                shimmer.start(titleTv);
                                searchListView.setVisibility(View.GONE);
                                title.setSpeak(titleTv.getText().toString() + requestTv.getText().toString());
                            }

                            @Override
                            public void onError(Throwable e) {

                            }
                        });

                // 搜索记录存档
                DBFavorite dbFavorite = new DBFavorite();
                dbFavorite.setTitle(dreamEt.getText().toString());
                dbFavorite.setType("dream_search");
                DBTool.getInstance().insertFavorite(dbFavorite);
            }
        });

        dreamEt.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        dreamEt.setCursorVisible(true);

                        // 开始摇摆
                        draweeController = Fresco.newDraweeControllerBuilder().setAutoPlayAnimations(true).setUri(uri).build();
                        draweeController_left = Fresco.newDraweeControllerBuilder().setAutoPlayAnimations(true).setUri(uri).build();
                        draweeController_right = Fresco.newDraweeControllerBuilder().setAutoPlayAnimations(true).setUri(uri).build();
                        simpleDraweeView.setController(draweeController);
                        simpleDraweeView_left.setController(draweeController_left);
                        simpleDraweeView_right.setController(draweeController_right);

                        // 查询历史搜索记录
                        if (dreamEt.getText().length() == 0) {
                            DBTool.getInstance().getFavorite("dream_search", new Action1<List<DBFavorite>>() {
                                @Override
                                public void call(List<DBFavorite> dbFavorites) {
                                    List<String> strings = new ArrayList<String>();
                                    strings.add("历史搜索记录...");
                                    for (DBFavorite dbFavorite : dbFavorites) {
                                        strings.add(dbFavorite.getTitle());
                                    }
                                }
                            });
                        }
                        break;
                }
                return false;
            }
        });

        // 防跳反搜索
        Observable.create(new EditTextObsetvable(dreamEt))
                .debounce(500, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(final String s) {
                        Log.d(TAG, "s.length():" + s.length());
                        if (s.length() == 0) {
                            searchListView.setVisibility(View.GONE);
                        }
                        NetTool.getInstance().startRequest(UrlValues.DREAM + UrlValues.DREAM_WORD + FormatCodeUtil.codingFormat(s),
                                DreamBean.class, new OnHttpCallBack<DreamBean>() {
                                    @Override
                                    public void onSuccess(DreamBean response) {
                                        if (s.length() == 0) {
                                            return;
                                        }
                                        searchListView.setVisibility(View.VISIBLE);
                                        if (response.getNewslist() != null) {
                                            newslistBeen = response.getNewslist();
                                        } else {
                                            newslistBeen = new ArrayList<DreamBean.NewslistBean>();
                                            DreamBean.NewslistBean newslistBean = new DreamBean.NewslistBean();
                                            newslistBean.setTitle("暂无查询结果");
                                            newslistBeen.add(newslistBean);
                                        }
                                        searchListView.setAdapter(new CommonAdapter<DreamBean.NewslistBean>(newslistBeen, getContext(), R.layout.lv_dream_search) {
                                            @Override
                                            public void setData(DreamBean.NewslistBean newslistBean, CommonViewHolder viewHolder) {
                                                viewHolder.setText(R.id.tv_search_dream, newslistBean.getTitle());
                                            }
                                        });
                                    }

                                    @Override
                                    public void onError(Throwable e) {

                                    }
                                });
                    }
                });

        searchListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                titleTv.setText(newslistBeen.get(position).getTitle());
                requestTv.setText(newslistBeen.get(position).getResult());
                searchListView.setVisibility(View.GONE);
            }
        });

        // gif
        draweeController = Fresco.newDraweeControllerBuilder().setAutoPlayAnimations(false).setUri(uri).build();
        draweeController_left = Fresco.newDraweeControllerBuilder().setAutoPlayAnimations(false).setUri(uri).build();
        draweeController_right = Fresco.newDraweeControllerBuilder().setAutoPlayAnimations(false).setUri(uri).build();
        simpleDraweeView.setController(draweeController);
        simpleDraweeView_left.setController(draweeController_left);
        simpleDraweeView_right.setController(draweeController_right);

        // EditText 获取焦点监听(暂且没用)
        dreamEt.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                // 当获取焦点时
                if (hasFocus) {
                    Log.d(TAG, "hasFocus:" + hasFocus);
                }
                // 当失去焦点时
                else {
                    Log.d(TAG, "hasFocus:" + hasFocus);
                }
            }
        });

        // 将标题栏显示
        final MainActivity mainActivity = (MainActivity) getActivity();
        title = new Title(getContext(), titleTv.getText().toString() + requestTv.getText().toString());
        title.setTitle(mainActivity);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        MainActivity mainActivity = (MainActivity) getActivity();
        mainActivity.getMainTitle().setVisibility(View.GONE);
    }


}
