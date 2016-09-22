package vampire.com.androidprojectb.fragment.user;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.UpdateListener;
import vampire.com.androidprojectb.R;
import vampire.com.androidprojectb.activity.EnterActivity;
import vampire.com.androidprojectb.activity.SettiingActivity;
import vampire.com.androidprojectb.base.BaseFragment;
import vampire.com.androidprojectb.base.MyApp;
import vampire.com.androidprojectb.fragment.user.radio.RadioCollectActivity;
import vampire.com.androidprojectb.fragment.user.radio.RadioCommentActivity;
import vampire.com.androidprojectb.fragment.user.radio.RadioGoldActivity;
import vampire.com.androidprojectb.fragment.user.radio.RadioReadActivity;

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

     private ImageView imageViewHead;
    private static int RESULT_LOAD_IMAGE = 1;
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
        imageViewHead= (ImageView) enterView.findViewById(R.id.image_head);
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
        imageViewHead.setOnClickListener(this);
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
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RESULT_LOAD_IMAGE && resultCode == Activity.RESULT_OK && null != data) {
            Uri selectedImage = data.getData();
            String[] filePathColumn = {MediaStore.Images.Media.DATA};
            Cursor cursor = getContext().getContentResolver().query(selectedImage, filePathColumn, null, null, null);
            cursor.moveToFirst();
            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String picturePath = cursor.getString(columnIndex);
            cursor.close();
            Bitmap bitmap = BitmapFactory.decodeFile(picturePath);
            imageViewHead.setImageBitmap(bitmap);
            //获取user数据需要调动的方法
            MyUser myUser = BmobUser.getCurrentUser(MyUser.class);
            myUser.setIcon(bitmap);
            Bitmap bitmap1 = myUser.getIcon();
            CircleDrawable circleDrawable = new CircleDrawable(bitmap1);
            imageViewHead.setImageDrawable(circleDrawable);
            AlphaAnimation alphaAnimation = new AlphaAnimation(0, 1);
            alphaAnimation.setDuration(1000);
            imageViewHead.setAnimation(alphaAnimation);
            alphaAnimation.start();
            myUser.setIcon(bitmap1);
            //保存
            myUser.update(new UpdateListener() {
                @Override
                public void done(BmobException e) {
                    if (e != null) {
                        Log.d("UserFragment", "更新失败" + e.toString());
                    } else {
                        Log.d("UserFragment", "更新成功");
                    }
                }
            });


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
            case  R.id.image_head:

                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setTitle("选择相册");
                builder.setMessage("你确定要更换相册么?");
                builder.setIcon(R.mipmap.a7g);
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //调用系统相册的方法
                        Intent b = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                        startActivityForResult(b, RESULT_LOAD_IMAGE);
                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.setNeutralButton("忽略", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.show();

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
