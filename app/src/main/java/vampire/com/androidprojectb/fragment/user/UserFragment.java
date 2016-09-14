package vampire.com.androidprojectb.fragment.user;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import vampire.com.androidprojectb.R;
import vampire.com.androidprojectb.base.BaseFragment;

/**
 * Created by Vampire on 16/9/12.
 */
public class UserFragment extends BaseFragment {
    private static final String TAG = "Vampire_UserFragment";
    private View noEnterView;
    private LinearLayout llSet;
    private LinearLayout redSet;
    private View enterView;
    private TextView textViewName;
    @Override
    protected int setLayout() {
        return R.layout.fragment_user;
    }

    @Override
    protected void initView() {
        llSet = bindView(R.id.user_set);
        llSet.bringToFront();
        redSet = bindView(R.id.red_ll);
        enterView= LayoutInflater.from(getContext()).inflate(R.layout.usermereplacelayout, null);
        textViewName= (TextView) enterView.findViewById(R.id.text_name);
        noEnterView = LayoutInflater.from(getContext()).inflate(R.layout.usermeaddlayout, null);


    }

    @Override
    protected void initData() {
        MyUser myUser = MyUser.getCurrentUser(MyUser.class);
        if (myUser != null) {
            redSet.removeAllViews();
            redSet.addView(enterView);
            textViewName.setText(myUser.getUsername());
        }else {
            llSet.removeAllViews();
            llSet.addView(noEnterView);
        }

    }

    @Override
    public void onResume() {
        super.onResume();
    }
}
