package vampire.com.androidprojectb.activity;

import android.provider.Settings;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.TextView;

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
public class SettiingActivity extends BaseActivity{
    private SeekBar seekBar;
    private TextView text2;
    private CheckBox checkbox;
     @Override
    protected int setLayout() {
        return R.layout.setlayout;
    }

    @Override
    protected void initView() {
        seekBar = bindView(R.id.seekBar1);
        text2 = bindView(R.id.textView3);
        checkbox = bindView(R.id.checkBox1);
    }

    @Override
    protected void initData() {
        //进度条绑定最大亮度，255是最大亮度
        seekBar.setMax(255);
        int normal = Settings.System.getInt(getContentResolver(),
                Settings.System.SCREEN_BRIGHTNESS, 255);
        text2.setText(String.valueOf(normal));
        //进度条绑定当前亮度
        seekBar.setProgress(normal);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {


            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                //取得当前进度
                checkbox.setChecked(false);
                int tmpInt = seekBar.getProgress();
                text2.setText(String.valueOf(tmpInt));
                //当进度小于80时，设置成80，防止太黑看不见的后果。
                if (tmpInt < 40) {
                    tmpInt = 40;
                }

                //根据当前进度改变亮度
                Settings.System.putInt(getContentResolver(),
                        Settings.System.SCREEN_BRIGHTNESS, tmpInt);
                tmpInt = Settings.System.getInt(getContentResolver(),
                        Settings.System.SCREEN_BRIGHTNESS, -1);
                WindowManager.LayoutParams wl = getWindow()
                        .getAttributes();
                float tmpFloat = (float) tmpInt / 255;
                if (tmpFloat > 0 && tmpFloat <= 1) {
                    wl.screenBrightness = tmpFloat;
                }
                getWindow().setAttributes(wl);
            }
        });
        checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                text2.setText("150");

                int light = 150;
                Settings.System.putInt(getContentResolver(),
                        Settings.System.SCREEN_BRIGHTNESS, light);
                light = Settings.System.getInt(getContentResolver(),
                        Settings.System.SCREEN_BRIGHTNESS, -1);
                WindowManager.LayoutParams wl = getWindow()
                        .getAttributes();
                float tmpFloat = (float) light / 255;
                if (tmpFloat > 0 && tmpFloat <= 1) {
                    wl.screenBrightness = tmpFloat;
                }
                getWindow().setAttributes(wl);
            }
        });
    }
}
