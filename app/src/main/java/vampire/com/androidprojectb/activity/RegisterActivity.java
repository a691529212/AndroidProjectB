package vampire.com.androidprojectb.activity;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import cn.bmob.v3.BmobUser;
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
public class RegisterActivity extends BaseActivity implements View.OnClickListener {
    private TextView textViewRegister;
   private EditText editTextAccount;
    private EditText editTextPassword;
    private ImageView imageViewBack;
    @Override
    protected int setLayout() {
        return R.layout.registerlayout;
    }

    @Override
    protected void initView() {
        textViewRegister = bindView(R.id.text_register);
        editTextAccount=bindView(R.id.et_account);
        editTextPassword=bindView(R.id.et_password);
        imageViewBack=bindView(R.id.image_back);
    }

    @Override
    protected void initData() {
        textViewRegister.setOnClickListener(this);
        imageViewBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.image_back:
                finish();

                break;
            case R.id.text_register:
                MyUser myUser=new MyUser();
                String etpassword = editTextPassword.getText().toString();
                String etname = editTextAccount.getText().toString();
                myUser.setUsername(etname);
                myUser.setPassword(etpassword);
                myUser.signUp(new SaveListener<BmobUser>() {
                    @Override
                    public void done(BmobUser bmobUser, BmobException e) {
                        if ((e == null)) {
                            Toast.makeText(RegisterActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
                            finish();
                        } else {
                            Toast.makeText(RegisterActivity.this, "注册失败", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

                if (myUser != null) {
                    Toast.makeText(this, "已经注册过了", Toast.LENGTH_SHORT).show();
                } else {

                }

                break;
        }

    }
}
