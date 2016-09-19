package vampire.com.androidprojectb.fragment.recreation.constellation;

import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import kankan.wheel.widget.adapters.ArrayWheelAdapter;

/**
 * Created by Vampire on 16/9/19.
 */
public class TargetConstellationArrayAdapter extends ArrayWheelAdapter<String> {
    private static final String TAG = "Vampire_TargetConstellationArrayAdapter";
    // Index of current item
    private int currentItem;
    // Index of item to be highlighted
    private int currentValue;

    String[] items;

    /**
     * Constructor
     *
     * @param context the current context
     * @param items   the items
     */
    public TargetConstellationArrayAdapter(Context context, String[] items, int current) {
        super(context, items);
        this.currentValue = current;
        this.items = items;
        setTextSize(16);

    }

    @Override
    protected void configureTextView(TextView view) {
        super.configureTextView(view);
        view.setTypeface(Typeface.SANS_SERIF);
        if (currentItem>0){
            view.setText(items[currentItem]+"座");
        }
    }

    @Override
    public View getItem(int index, View convertView, ViewGroup parent) {
        currentItem = index;
        return super.getItem(index, convertView, parent);
    }
}
