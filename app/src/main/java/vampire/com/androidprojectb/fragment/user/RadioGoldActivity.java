package vampire.com.androidprojectb.fragment.user;

import android.view.View;
import android.widget.ImageView;

import vampire.com.androidprojectb.R;
import vampire.com.androidprojectb.base.BaseActivity;

/**
 * code is far away from bug with the animal protecting
 * <p>
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
public class RadioGoldActivity extends BaseActivity implements View.OnClickListener {
    private ImageView imageViewBack;

    @Override
    protected int setLayout() {
        return R.layout.radiogold;
    }

    @Override
    protected void initView() {
        imageViewBack = bindView(R.id.image_back);
    }

    @Override
    protected void initData() {
  imageViewBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        finish();
    }
}
