package vampire.com.androidprojectb.fragment.news.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import vampire.com.androidprojectb.R;
import vampire.com.androidprojectb.base.MyApp;

/**
 * 　　　　　　　　┏┓　　　┏┓+ +
 * 　　　　　　　┏┛┻━━━┛┻┓ + +
 * 　　　　　　　┃　　　　　　　┃
 * 　　　　　　　┃　　　━　　　┃ ++ + + +
 * 　　　　　　 ████━████ ┃+
 * 　　　　　　　┃　　　　　　　┃ +
 * 　　　　　　　┃　　　┻　　　┃
 * 　　　　　　　┃　　　　　　　┃ + +
 * 　　　　　　　┗━┓　　　┏━┛
 * 　　　　　　　　　┃　　　┃
 * 　　　　　　　　　┃　　　┃ + + + +
 * 　　　　　　　　　┃　　　┃　　　　Code is far away from bug with the animal protecting
 * 　　　　　　　　　┃　　　┃ + 　　　　神兽保佑,代码无bug
 * 　　　　　　　　　┃　　　┃
 * 　　　　　　　　　┃　　　┃　　+
 * 　　　　　　　　　┃　 　　┗━━━┓ + +
 * 　　　　　　　　　┃ 　　　　　　　┣┓
 * 　　　　　　　　　┃ 　　　　　　　┏┛
 * 　　　　　　　　　┗┓┓┏━┳┓┏┛ + + + +
 * 　　　　　　　　　　┃┫┫　┃┫┫
 * 　　　　　　　　　　┗┻┛　┗┻┛+ + + +
 * <p>
 * Created by R on 16/9/20.
 */

public class TitleDelAdapter extends BaseAdapter {
    private Context context;

    public TitleDelAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return MyApp.getListTitle().size();
    }

    @Override
    public Object getItem(int position) {
        return MyApp.getListTitle().get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TitleDelViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.fragment_news_button_pop_list_item, null);
            holder = new TitleDelViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (TitleDelViewHolder) convertView.getTag();
        }
        holder.textview.setText(MyApp.getListTitle().get(position));
        return convertView;
    }

    class TitleDelViewHolder {
        private TextView textview;

        public TitleDelViewHolder(View view) {
            textview = (TextView) view.findViewById(R.id.fragment_news_button_pop_list_view_text_view);
        }
    }
}
