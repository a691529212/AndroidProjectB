package vampire.com.androidprojectb.fragment.recreation;

import android.content.Context;
import android.view.View;

import com.iflytek.cloud.SpeechConstant;
import com.iflytek.cloud.SpeechSynthesizer;
import com.yalantis.contextmenu.lib.ContextMenuDialogFragment;
import com.yalantis.contextmenu.lib.interfaces.OnMenuItemClickListener;

import org.greenrobot.eventbus.Subscribe;

import vampire.com.androidprojectb.MainActivity;
import vampire.com.androidprojectb.tool.ContextMenu;
import vampire.com.androidprojectb.tool.Speaker;
import vampire.com.androidprojectb.values.StringValues;

/**
 * Created by Vampire on 16/9/27.
 */
public class Title {
    private ContextMenuDialogFragment contextMenuDialogFragment;
    private Context context;
    private String speak;

    public void setSpeak(String speak) {
        this.speak = speak;
    }

    public Title(Context context, String speak) {
        this.context = context;
        this.speak = speak;
    }

    public void setTitle(final MainActivity mainActivity){
        mainActivity.getMainTitle().setVisibility(View.VISIBLE);
        // 返回键
        mainActivity.getBack().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivity.upDataFragment(new RecreationFragment());
            }
        });

        contextMenuDialogFragment = ContextMenu.showContextMenu();
        //下展示条
        mainActivity.getDown().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                contextMenuDialogFragment.show(mainActivity.getSupportFragmentManager(), "ContextMenuDialogFragment");
            }
        });

        contextMenuDialogFragment.setItemClickListener(new OnMenuItemClickListener() {
            @Override
            public void onMenuItemClick(View clickedView, int position) {

                String voiceName = StringValues.VOICE[position];
                //1.创建SpeechSynthesizer对象, 第二个参数：本地合成时传InitListener
                SpeechSynthesizer synthesizer = SpeechSynthesizer.createSynthesizer(context, null);
                //2.合成参数设置，详见《科大讯飞MSC API手册(Android)》SpeechSynthesizer 类
                synthesizer.setParameter(SpeechConstant.VOICE_NAME, voiceName);//设置发音人
                synthesizer.setParameter(SpeechConstant.SPEED, "50");//设置语速
                synthesizer.setParameter(SpeechConstant.VOLUME, "80");//设置音量，范围0~100
                synthesizer.startSpeaking(speak, Speaker.mSynListeners);

            }
        });
    }
}
