package vampire.com.androidprojectb.fragment.recreation.dream;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.romainpiel.shimmer.Shimmer;
import com.romainpiel.shimmer.ShimmerTextView;

import vampire.com.androidprojectb.R;
import vampire.com.androidprojectb.base.BaseFragment;
import vampire.com.androidprojectb.tool.FormatCodeUtil;
import vampire.com.androidprojectb.tool.nettool.NetTool;
import vampire.com.androidprojectb.tool.nettool.OnHttpCallBack;
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

    @Override
    protected int setLayout() {
        return R.layout.fragment_dream;
    }

    @Override
    protected void initView() {

        requestTv = bindView(R.id.tv_dream_request);
        titleTv = bindView(R.id.tv_dream_title);
        dreamBtn = bindView(R.id.btn_dream);
        dreamEt = bindView(R.id.et_dream);
    }

    @Override
    protected void initData() {
        Log.d(TAG, UrlValues.DREAM + UrlValues.DREAM_WORD + FormatCodeUtil.codingFormat(dreamEt.getText().toString()));
        dreamBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NetTool.getInstance().startRequest(UrlValues.DREAM + UrlValues.DREAM_WORD + FormatCodeUtil.codingFormat(dreamEt.getText().toString()),
                        DreamBean.class, new OnHttpCallBack<DreamBean>() {
                            @Override
                            public void onSuccess(DreamBean response) {
                                Log.d(TAG, "response:" + response.getNewslist());
                                if (response.getNewslist() != null) {
                                    requestTv.setText(response.getNewslist().get(0).getResult());
                                    titleTv.setText(response.getNewslist().get(0).getTitle());
                                } else {
                                    requestTv.setText("观自在菩萨,行深般若波罗蜜多时，照见五蕴皆空，度一切苦厄。" +
                                            "舍利子，色不异空，空不异色，色即是空，空即是色，受想行识，亦复如是。" +
                                            "舍利子，是诸法空相，不生不灭，不垢不净，不增不减。是故空中无色，无受想行识，无眼耳鼻舌身意，无色声香味触法，无眼界，乃至无意识界。" +
                                            "无无明，亦无无明尽，乃至无老死，亦无老死尽。无苦集灭道，无智亦无得。以无所得故，菩提萨埵，依般若波罗蜜多故，心无罣碍，无罣碍故，无有恐怖，远离颠倒梦想，究竟涅磐。" +
                                            "三世诸佛，依般若波罗蜜多故，得阿耨多罗三藐三菩提。" +
                                            "故知般若波罗蜜多，是大神咒，是大明咒，是无上咒，是无等等咒，能除一切苦，真实不虚。" +
                                            "故说般若波罗蜜多咒，即说咒曰：揭谛揭谛波罗揭谛波罗僧揭谛菩提萨婆诃。");
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
}
