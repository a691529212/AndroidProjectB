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

public class TitleAddAdapter extends BaseAdapter{
    private Context context;

    public TitleAddAdapter(Context context) {
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
        TitleAddViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.fragment_news_button_pop_list_item, null);
            holder = new TitleAddViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (TitleAddViewHolder) convertView.getTag();
        }
        holder.textview.setText(MyApp.getListTitle().get(position));
        return convertView;
    }
    class TitleAddViewHolder {
        private TextView textview;

        public TitleAddViewHolder(View view) {
            textview = (TextView) view.findViewById(R.id.fragment_news_button_pop_list_view_text_view);
        }
    }
}
