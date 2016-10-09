package vampire.com.androidprojectb.fragment.recreation;

import android.animation.Animator;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.romainpiel.shimmer.Shimmer;
import com.romainpiel.shimmer.ShimmerTextView;

import app.dinus.com.loadingdrawable.LoadingView;
import app.dinus.com.loadingdrawable.render.LoadingDrawable;
import app.dinus.com.loadingdrawable.render.scenery.ElectricFanLoadingRenderer;
import vampire.com.androidprojectb.MainActivity;
import vampire.com.androidprojectb.R;
import vampire.com.androidprojectb.base.BaseFragment;
import vampire.com.androidprojectb.base.MyApp;
import vampire.com.androidprojectb.fragment.recreation.constellation.ConstellationFragment;
import vampire.com.androidprojectb.fragment.recreation.dream.DreamFragment;
import vampire.com.androidprojectb.fragment.recreation.fortunetelling.FortunetellingFragment;
import vampire.com.androidprojectb.fragment.recreation.riddle.RiddleFragment;
import vampire.com.androidprojectb.fragment.recreation.twister.TwisterFragment;
import vampire.com.androidprojectb.tool.nettool.NetTool;
import vampire.com.androidprojectb.tool.nettool.OnHttpCallBack;
import vampire.com.androidprojectb.values.UrlValues;

/**
 * Created by Vampire on 16/9/12.
 */
public class RecreationFragment extends BaseFragment implements View.OnClickListener {
    private ShimmerTextView oldSaying;
    private ShimmerTextView name;
    private LinearLayout riddleLayout;
    private LinearLayout twisterLayout;
    private LinearLayout birthdayLatout;
    private LinearLayout dreamLayout;
    private LinearLayout constellationLayout;
    private Shimmer shimmerl;
    private ShimmerTextView riddleTV;
    private ShimmerTextView twisterTV;
    private ShimmerTextView birthdayTV;
    private ShimmerTextView dreamTV;
    private ShimmerTextView constellationTV;
    private Shimmer shimmerR;
    private LoadingDrawable loadingDrawable;

    @Override
    protected int setLayout() {
        return R.layout.fragment_recreation;
    }

    @Override
    protected void initView() {

        oldSaying = bindView(R.id.tv_old_saying_first);
        name = bindView(R.id.tv_old_saying_name);
        riddleTV = bindView(R.id.tv_riddle_menu);
        twisterTV = bindView(R.id.tv_twister_menu);
        birthdayTV = bindView(R.id.tv_taiji_menu);
        dreamTV = bindView(R.id.tv_dream_menu);
        constellationTV = bindView(R.id.tv_consellation_menu);


        riddleLayout = bindView(R.id.riddle);
        twisterLayout = bindView(R.id.twister);
        birthdayLatout = bindView(R.id.life);
        dreamLayout = bindView(R.id.dream);
        constellationLayout = bindView(R.id.constellation);

        riddleLayout.setOnClickListener(this);
        twisterLayout.setOnClickListener(this);
        birthdayLatout.setOnClickListener(this);
        dreamLayout.setOnClickListener(this);
        constellationLayout.setOnClickListener(this);

        shimmerR = new Shimmer();
        shimmerl = new Shimmer();
        shimmerl.setDuration(3000).setStartDelay(300).setDirection(Shimmer.ANIMATION_DIRECTION_LTR);// left tp right
        shimmerR.setDuration(3000).setStartDelay(300).setDirection(Shimmer.ANIMATION_DIRECTION_RTL);// right to left
        shimmerl.start(oldSaying);
        shimmerR.start(name);
        shimmerl.start(riddleTV);
        shimmerR.start(twisterTV);
        shimmerl.start(birthdayTV);
        shimmerR.start(dreamTV);
        shimmerl.start(constellationTV);

        loadingDrawable = new LoadingDrawable(new ElectricFanLoadingRenderer(getContext()));
        oldSaying.setBackground(loadingDrawable);
        loadingDrawable.start();

    }

    @Override
    protected void initData() {
        NetTool.getInstance().startRequest(UrlValues.SAYING, OldSayingBean.class, new OnHttpCallBack<OldSayingBean>() {
            @Override
            public void onSuccess(OldSayingBean response) {
                loadingDrawable.stop();
                oldSaying.setBackground(null);
                if (response.getNewslist().get(0).getContent().length() > 50) {
                    oldSaying.setTextSize(13);
                }
                oldSaying.setText(response.getNewslist().get(0).getContent());
                name.setText(name.getText() + response.getNewslist().get(0).getMrname());
            }

            @Override
            public void onError(Throwable e) {

            }
        });

    }

    @Override
    public void onClick(View v) {
        MainActivity mainActivity = (MainActivity) getActivity();
        switch (v.getId()) {
            case R.id.riddle:
                mainActivity.upDataFragment(new RiddleFragment());
                break;
            case R.id.twister:
                mainActivity.upDataFragment(new TwisterFragment());
                break;
            case R.id.life:
                mainActivity.upDataFragment(new FortunetellingFragment());
                break;
            case R.id.dream:
                mainActivity.upDataFragment(new DreamFragment());
                break;
            case R.id.constellation:
                mainActivity.upDataFragment(new ConstellationFragment());
                break;
        }
    }
}
