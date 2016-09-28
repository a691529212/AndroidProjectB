package vampire.com.androidprojectb.fragment.recreation.dream;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by Vampire on 16/9/26.
 */
public class EditTextObsetvable implements Observable.OnSubscribe<String> {
    private static final String TAG = "Vampire_EditTextObsetvable";
    private EditText editText;

    public EditTextObsetvable(EditText editText) {
        this.editText = editText;
    }

    @Override
    public void call(final Subscriber<? super String> subscriber) {
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                String text = s.toString();
                if (s.length() >= 0) {
                    subscriber.onNext(text);

                }
            }
        });
    }

}
