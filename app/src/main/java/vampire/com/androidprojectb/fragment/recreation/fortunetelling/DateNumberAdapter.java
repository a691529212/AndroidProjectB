package vampire.com.androidprojectb.fragment.recreation.fortunetelling;

import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import kankan.wheel.widget.adapters.NumericWheelAdapter;

/**
 * Created by Vampire on 16/9/18.
 */
public class DateNumberAdapter extends NumericWheelAdapter {
    private static final String TAG = "Vampire_DateNumberAdapter";
    private int currentItem;
    private int currentValue;


    public DateNumberAdapter(Context context, int minValue, int maxValue, int format) {
        super(context, minValue, maxValue);
        this.currentValue = format;
    }

    @Override
    protected void configureTextView(TextView view) {
        super.configureTextView(view);
//        if (currentItem == currentValue) {
//            view.setTextColor(0xFF0000F0);
//        }
        view.setTypeface(Typeface.SANS_SERIF);
    }

    @Override
    public View getItem(int index, View convertView, ViewGroup parent) {
        currentItem = index;
        return super.getItem(index, convertView, parent);
    }

}
