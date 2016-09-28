package vampire.com.androidprojectb.tool;

import android.os.Bundle;
import android.util.Log;

import com.iflytek.cloud.SpeechConstant;
import com.iflytek.cloud.SpeechError;
import com.iflytek.cloud.SpeechSynthesizer;
import com.iflytek.cloud.SynthesizerListener;

import vampire.com.androidprojectb.base.MyApp;

/**
 * Created by Vampire on 16/9/22.
 */
public class Speaker {
    private Speaker() {

    }

    //合成监听器
    public static SynthesizerListener mSynListeners = new SynthesizerListener() {
        //会话结束回调接口，没有错误时，error为null
        public void onCompleted(SpeechError error) {
            if(error!=null)
            {
                Log.d("mySynthesiezer complete code:", error.getErrorCode()+"");
            }
            else
            {
                Log.d("mySynthesiezer complete code:", "0");
            }
        }

        //缓冲进度回调
        //percent为缓冲进度0~100，beginPos为缓冲音频在文本中开始位置，endPos表示缓冲音频在文本中结束位置，info为附加信息。
        public void onBufferProgress(int percent, int beginPos, int endPos, String info) {

        }

        //开始播放
        public void onSpeakBegin() {

            Log.d("MainActivity", "开始播放");
        }

        //暂停播放
        public void onSpeakPaused() {
        }

        //播放进度回调
        //percent为播放进度0~100,beginPos为播放音频在文本中开始位置，endPos表示播放音频在文本中结束位置.
        public void onSpeakProgress(int percent, int beginPos, int endPos) {
        }

        //恢复播放回调接口
        public void onSpeakResumed() {
        }

        //会话事件回调接口
        public void onEvent(int arg0, int arg1, int arg2, Bundle arg3) {
        }


    };



}
