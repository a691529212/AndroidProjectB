package vampire.com.androidprojectb.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;
import vampire.com.androidprojectb.R;
import vampire.com.androidprojectb.base.BaseActivity;
import vampire.com.androidprojectb.fragment.user.MyUser;

/**
 * code is far away from bug with the animal protecting
 * <p/>
 * ┏┓　　　┏┓
 * ┏┛┻━━━┛┻┓
 * ┃　　　　　　　┃
 * ┃　　　━　　　┃
 * ┃　┳┛　┗┳　┃
 * ┃　　　　　　　┃
 * ┃　　　┻　　　┃
 * ┃　　　　　　　┃
 * ┗━┓　　　┏━┛
 * 　　┃　　　┃神兽保佑
 * 　　┃　　　┃永无BUG！  凯哥 祝你一路顺风
 * 　　┃　　　┗━━━┓
 * 　　┃　　　　　　　┣┓
 * 　　┃　　　　　　　┏┛
 * 　　┗┓┓┏━┳┓┏┛
 * 　　　┃┫┫　┃┫┫
 * 　　　┗┻┛　┗┻┛
 */
public class EnterActivity extends BaseActivity implements View.OnClickListener {
    private TextView textViewRegister;
    private TextView textViewEnter;
    private EditText editTextAccount;
    private EditText editTextPassword;
    @Override
    protected int setLayout() {
        return R.layout.enterlayout;
    }

    @Override
    protected void initView() {
        textViewRegister = bindView(R.id.text_register);
        textViewEnter = bindView(R.id.text_enter);
        editTextAccount=bindView(R.id.et_account);
        editTextPassword=bindView(R.id.et_password);
    }

    @Override
    protected void initData() {
        textViewRegister.setOnClickListener(this);
        textViewEnter.setOnClickListener(this);
    }

    @Override
    public void onClick(final View view) {
        switch (view.getId()) {
            case R.id.text_register:
                Intent intent = new Intent(this, RegisterActivity.class);
                startActivity(intent);

                break;
            case  R.id.text_enter:
                final MyUser user = new MyUser();
                String name = editTextAccount.getText().toString();
                String password = editTextPassword.getText().toString();
                user.setUsername(name);
                user.setPassword(password);

                user.login(new SaveListener<MyUser>() {
                    //e表示没有异常就注册,如果有异常就执行下面的方法
                    @Override
                    public void done(MyUser myUser, BmobException e) {
                        if (e==null){
                            Log.d("ZhuCeActivity", "登陆成功了");
                            ProgressDialog progressDialog;
                            progressDialog = new ProgressDialog(view.getContext());
                            progressDialog.setCancelable(true);
                            progressDialog.setMessage("正在加载....");

                            progressDialog.show();
                            finish();
                        }else {
                            Toast.makeText(EnterActivity.this, "您输入的账号或密码不正确", Toast.LENGTH_SHORT).show();

                        }
                    }
                });



                break;
        }
    }
}
