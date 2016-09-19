package vampire.com.androidprojectb.fragment.recreation.fortunetelling;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.romainpiel.shimmer.Shimmer;
import com.romainpiel.shimmer.ShimmerTextView;

import java.util.Calendar;

import kankan.wheel.widget.OnWheelChangedListener;
import kankan.wheel.widget.WheelView;
import vampire.com.androidprojectb.R;
import vampire.com.androidprojectb.base.BaseFragment;
import vampire.com.androidprojectb.tool.nettool.NetTool;
import vampire.com.androidprojectb.tool.nettool.OnHttpCallBack;
import vampire.com.androidprojectb.values.UrlValues;

/**
 * Created by Vampire on 16/9/18.
 */
public class FortunetellingFragment extends BaseFragment {
    private WheelView yearView;
    private WheelView monthView;
    private WheelView dayView;
    private Calendar calendar;
    private Button birthdayBtn;
    private ShimmerTextView birRequestTv;
    private ShimmerTextView bitTitleTv;


    @Override
    protected int setLayout() {
        return R.layout.fragment_fortunetelling;
    }

    @Override
    protected void initView() {
        yearView = bindView(R.id.year);
        monthView = bindView(R.id.month);
        dayView = bindView(R.id.day);
        birthdayBtn = bindView(R.id.btn_birthday);
        birRequestTv = bindView(R.id.tv_bir_request);
        bitTitleTv = bindView(R.id.tv_bir_title);
    }

    @Override
    protected void initData() {
        calendar = Calendar.getInstance();
        OnWheelChangedListener listener = new OnWheelChangedListener() {
            @Override
            public void onChanged(WheelView wheel, int oldValue, int newValue) {
                updateDays(yearView, monthView, dayView);
            }
        };

        // month
        String months[] = new String[]{"一月", "二月", "三月", "四月",
                "五月", "六月", "七月", "八月",
                "九月", "十月", "十一月", "十二月"};
        monthView.setViewAdapter(new DateArrayAdapter(getContext(), months, 0));
        monthView.setCurrentItem(0);
        monthView.addChangingListener(listener);

        // year
        int curYear = calendar.get(Calendar.YEAR);
        yearView.setViewAdapter(new DateNumberAdapter(getContext(), curYear - 100, curYear, 0));
        yearView.setCurrentItem(100);
        Log.d("FortunetellingFragment", "curYear:" + curYear);
        yearView.addChangingListener(listener);

        // day
        updateDays(yearView, monthView, dayView);
        dayView.setCurrentItem(calendar.get(Calendar.DAY_OF_MONTH) - 1);


        birthdayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("FortunetellingFragment", "monthView.getCurrentItem():" + monthView.getCurrentItem());
                Log.d("FortunetellingFragment", "dayView.getCurrentItem():" + dayView.getCurrentItem());
                NetTool.getInstance().startRequest(
                        UrlValues.BIRTHDAY + UrlValues.MOUTH + (monthView.getCurrentItem() + 1) + UrlValues.DAY + (dayView.getCurrentItem() + 1)
                        , DateBean.class, new OnHttpCallBack<DateBean>() {
                            @Override
                            public void onSuccess(DateBean response) {
                                bitTitleTv.setText(response.getNewslist().get(0).getTitle());
                                birthdayBtn.setText(response.getNewslist().get(0).getContent());

                                Shimmer shimmerL = new Shimmer();
                                shimmerL.setDuration(3000).setStartDelay(300).setDirection(Shimmer.ANIMATION_DIRECTION_LTR);
                                shimmerL.start(birRequestTv);
                                Shimmer shimmerR = new Shimmer();
                                shimmerR.setDuration(3000).setStartDelay(300).setDirection(Shimmer.ANIMATION_DIRECTION_RTL);
                                shimmerR.start(bitTitleTv);
                            }

                            @Override
                            public void onError(Throwable e) {

                            }
                        });
            }
        });

    }

    private void updateDays(WheelView yearView, WheelView monthView, WheelView dayView) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR) + yearView.getCurrentItem());
        calendar.set(Calendar.MONTH, monthView.getCurrentItem());

        int maxDays = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        dayView.setViewAdapter(new DateNumberAdapter(getContext(), 1, maxDays, calendar.get(Calendar.DAY_OF_MONTH) - 1));
        int curDay = Math.min(maxDays, dayView.getCurrentItem());
        dayView.setCurrentItem(curDay, true);
    }


}
