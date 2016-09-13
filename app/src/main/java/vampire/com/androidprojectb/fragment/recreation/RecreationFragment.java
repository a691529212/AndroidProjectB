package vampire.com.androidprojectb.fragment.recreation;

import android.widget.ImageView;
import android.widget.TextView;

import vampire.com.androidprojectb.R;
import vampire.com.androidprojectb.base.BaseFragment;

/**
 * Created by Vampire on 16/9/12.
 */
public class RecreationFragment extends BaseFragment {
    private static final String TAG = "Vampire_RecreationFragment";
    private TextView oldSaying;
    private ImageView ivRiddle;
    private ImageView ivTwister;
    private ImageView ivBirthday;
    private ImageView ivDream;
    private ImageView ivConstellation;

    @Override
    protected int setLayout() {
        return R.layout.fragment_recreation;
    }

    @Override
    protected void initView() {
        oldSaying = bindView(R.id.tv_old_saying_first);
//        ivRiddle = bindView(R.id.iv_riddle);
//        ivTwister = bindView(R.id.iv_twister);
//        ivBirthday = bindView(R.id.iv_birthday);
//        ivDream = bindView(R.id.iv_dream);
//        ivConstellation = bindView(R.id.iv_constellation);
    }

    @Override
    protected void initData() {

    }
}
