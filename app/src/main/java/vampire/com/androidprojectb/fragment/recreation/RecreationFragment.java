package vampire.com.androidprojectb.fragment.recreation;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import vampire.com.androidprojectb.MainActivity;
import vampire.com.androidprojectb.R;
import vampire.com.androidprojectb.base.BaseFragment;
import vampire.com.androidprojectb.fragment.recreation.riddle.RiddleFragment;
import vampire.com.androidprojectb.fragment.recreation.twister.TwisterFragment;
import vampire.com.androidprojectb.nettool.NetTool;
import vampire.com.androidprojectb.nettool.OnHttpCallBack;
import vampire.com.androidprojectb.values.UrlValues;

/**
 * Created by Vampire on 16/9/12.
 */
public class RecreationFragment extends BaseFragment implements View.OnClickListener {
    private static final String TAG = "Vampire_RecreationFragment";
    private TextView oldSaying;
    private TextView name;
    private LinearLayout riddleLayout;
    private LinearLayout twisterLayout;
    private LinearLayout birthdayLatout;
    private LinearLayout dreamLayout;
    private LinearLayout constellationLayout;

    @Override
    protected int setLayout() {
        return R.layout.fragment_recreation;
    }

    @Override
    protected void initView() {
        oldSaying = bindView(R.id.tv_old_saying_first);
        name = bindView(R.id.tv_old_saying_name);

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

    }

    @Override
    protected void initData() {
        NetTool.getInstance().startRequest(UrlValues.SAYING, OldSayingBean.class, new OnHttpCallBack<OldSayingBean>() {
            @Override
            public void onSuccess(OldSayingBean response) {
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
                break;
            case R.id.dream:
                break;
            case R.id.constellation:
                break;
        }
    }
}
