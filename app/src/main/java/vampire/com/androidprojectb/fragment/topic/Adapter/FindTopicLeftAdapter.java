package vampire.com.androidprojectb.fragment.topic.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import vampire.com.androidprojectb.BuildConfig;
import vampire.com.androidprojectb.R;

import vampire.com.androidprojectb.fragment.topic.bean.FindTopicBean;

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
public class FindTopicLeftAdapter extends BaseAdapter {
    private Context context;
    private FindTopicBean lefttBean;

    private int pos;

    public void setSetTextColor(int pos) {
        this.pos = pos;
        notifyDataSetChanged();
    }

    public FindTopicLeftAdapter(Context context) {
        this.context = context;
    }

    public void setLefttBean(FindTopicBean lefttBean) {
        this.lefttBean = lefttBean;

        notifyDataSetChanged();
    }


    @Override
    public int getCount() {
        return lefttBean != null ? lefttBean.getData().size() : 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder = null;
        LayoutInflater inflater = LayoutInflater.from(context);
        if (view == null) {
            view = inflater.inflate(R.layout.find_topic_left, null);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        if (i == pos) {
            viewHolder.textViewleft.setTextColor(0xFFD21010);
        } else {
            viewHolder.textViewleft.setTextColor(0xf8080808);
        }

        viewHolder.textViewleft.setText(lefttBean.getData().get(i).getName());


        return view;
    }

    private class ViewHolder {
        private TextView textViewleft;

        private ViewHolder(View view) {
            textViewleft = (TextView) view.findViewById(R.id.find_text_left);
        }
    }
}
