package vampire.com.androidprojectb.fragment.recreation.dream;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.iflytek.cloud.SpeechConstant;
import com.iflytek.cloud.SpeechError;
import com.iflytek.cloud.SpeechSynthesizer;
import com.iflytek.cloud.SynthesizerListener;
import com.romainpiel.shimmer.Shimmer;
import com.romainpiel.shimmer.ShimmerTextView;
import com.yalantis.contextmenu.lib.ContextMenuDialogFragment;
import com.yalantis.contextmenu.lib.interfaces.OnMenuItemClickListener;

import java.lang.ref.SoftReference;

import vampire.com.androidprojectb.MainActivity;
import vampire.com.androidprojectb.R;
import vampire.com.androidprojectb.base.BaseFragment;
import vampire.com.androidprojectb.base.MyApp;
import vampire.com.androidprojectb.fragment.recreation.RecreationFragment;
import vampire.com.androidprojectb.tool.ContextMenu;
import vampire.com.androidprojectb.tool.FormatCodeUtil;
import vampire.com.androidprojectb.tool.Speaker;
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
    private EditText dreamEt;
    private ShimmerTextView titleTv;
    private String voiceName = "vixm";
    private ContextMenuDialogFragment contextMenuDialogFragment;
    private SpeechSynthesizer synthesizer;

    @Override
    protected int setLayout() {
        return R.layout.fragment_dream;
    }

    @Override
    protected void initView() {

        // 将标题栏显示
        final MainActivity mainActivity = (MainActivity) getActivity();
        mainActivity.getMainTitle().setVisibility(View.VISIBLE);
        Button back = mainActivity.getBack();
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivity.upDataFragment(new RecreationFragment());
            }
        });
        contextMenuDialogFragment = ContextMenu.showContextMenu();
        Button down = mainActivity.getDown();
        down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contextMenuDialogFragment.show(getChildFragmentManager(), "ContextMenuDialogFragment");
            }
        });
        contextMenuDialogFragment.setItemClickListener(new OnMenuItemClickListener() {
            @Override
            public void onMenuItemClick(View clickedView, int position) {
                voiceName = StringValues.VOICE[position];
                //1.创建SpeechSynthesizer对象, 第二个参数：本地合成时传InitListener
                synthesizer = SpeechSynthesizer.createSynthesizer(mContext, null);
                //2.合成参数设置，详见《科大讯飞MSC API手册(Android)》SpeechSynthesizer 类
                synthesizer.setParameter(SpeechConstant.VOICE_NAME, voiceName);//设置发音人
                synthesizer.setParameter(SpeechConstant.SPEED, "50");//设置语速
                synthesizer.setParameter(SpeechConstant.VOLUME, "80");//设置音量，范围0~100
                synthesizer.startSpeaking(requestTv.getText().toString(), Speaker.mSynListeners);

            }
        });


        requestTv = bindView(R.id.tv_dream_request);
        titleTv = bindView(R.id.tv_dream_title);
        dreamBtn = bindView(R.id.btn_dream);
        dreamEt = bindView(R.id.et_dream);
    }

    @Override
    protected void initData() {
        dreamBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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


                            }

                            @Override
                            public void onError(Throwable e) {

                            }
                        });
            }
        });

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        MainActivity mainActivity = (MainActivity) getActivity();
        mainActivity.getMainTitle().setVisibility(View.GONE);
    }


}
