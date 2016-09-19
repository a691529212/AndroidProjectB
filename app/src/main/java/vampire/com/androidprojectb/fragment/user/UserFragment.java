package vampire.com.androidprojectb.fragment.user;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;

import cn.bmob.v3.BmobUser;
import vampire.com.androidprojectb.R;
import vampire.com.androidprojectb.base.BaseFragment;
import vampire.com.androidprojectb.base.MyApp;

/**
 * Created by Vampire on 16/9/12.
 */
public class UserFragment extends BaseFragment implements View.OnClickListener, RadioGroup.OnCheckedChangeListener {
    private RadioGroup group;
    private static final String TAG = "Vampire_UserFragment";
    private View noEnterView;
    private LinearLayout llSet;
    private LinearLayout redSet;
    private View enterView;
    private TextView textViewName;
    private TextView textViewEnter;
    private Button btnFinish;

    @Override
    protected int setLayout() {
        return R.layout.fragment_user;
    }

    @Override
    protected void initView() {
        llSet = bindView(R.id.user_set);
        llSet.bringToFront();
        redSet = bindView(R.id.red_ll);
        group = bindView(R.id.Radio_Group);


        enterView = LayoutInflater.from(mContext).inflate(R.layout.usermereplacelayout, null);
        textViewName = (TextView) enterView.findViewById(R.id.text_name);
        btnFinish = (Button) enterView.findViewById(R.id.btn_finish);
        noEnterView = LayoutInflater.from(mContext).inflate(R.layout.usermeaddlayout, null);
        textViewEnter = (TextView) noEnterView.findViewById(R.id.text_enter);


    }

    @Override
    protected void initData() {


        textViewEnter.setOnClickListener(this);
        llSet.setOnClickListener(this);
        btnFinish.setOnClickListener(this);
        group.setOnCheckedChangeListener(this);
    }


    @Override
    public void onResume() {
        super.onResume();

        MyUser myUser = BmobUser.getCurrentUser(MyUser.class);
        if (myUser != null) {
            redSet.removeAllViews();
            redSet.addView(enterView);
            textViewName.setText(myUser.getUsername());
        } else {
            redSet.removeAllViews();
            redSet.addView(noEnterView);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.text_enter:
                Intent intent = new Intent(mContext, EnterActivity.class);
                startActivity(intent);


                break;
            case R.id.user_set:
                Intent intent1 = new Intent(mContext, SettiingActivity.class);
                startActivity(intent1);


                break;
            case R.id.btn_finish:
                MyUser.logOut();
                redSet.removeAllViews();
                redSet.addView(noEnterView);


                break;
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        switch (i) {
            case R.id.radio_read:
                Intent intent = new Intent(MyApp.getContext(), RadioReadActivity.class);
                startActivity(intent);


                break;
            case R.id.radio_collect:

                Intent intent1 = new Intent(MyApp.getContext(), RadioCollectActivity.class);
                startActivity(intent1);
                break;
            case R.id.radio_comment:
                Intent intent2 = new Intent(MyApp.getContext(), RadioCommentActivity.class);
                startActivity(intent2);
                break;
            case R.id.radio_gold:
                Intent intent3 = new Intent(MyApp.getContext(), RadioGoldActivity.class);
                startActivity(intent3);
                break;
        }
    }
}
