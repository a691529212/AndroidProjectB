package vampire.com.androidprojectb.fragment.user;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import vampire.com.androidprojectb.R;
import vampire.com.androidprojectb.base.BaseFragment;

/**
 * Created by Vampire on 16/9/12.
 */
public class UserFragment extends BaseFragment {
    private static final String TAG = "Vampire_UserFragment";
    private View noEnterView;
    private LinearLayout llSet;

    @Override
    protected int setLayout() {
        return R.layout.fragment_user;
    }

    @Override
    protected void initView() {
        llSet = bindView(R.id.user_set);
        llSet.bringToFront();
        noEnterView = LayoutInflater.from(getContext()).inflate(R.layout.noenteruserlayout, null);
    }

    @Override
    protected void initData() {

    }
}
