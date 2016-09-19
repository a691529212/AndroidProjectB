package vampire.com.androidprojectb.fragment.news.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import vampire.com.androidprojectb.R;

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
 * Created by R on 16/9/13.
 */

public class PopupWindowListViewAdapter extends BaseAdapter{
    private Context context;
    private List<String> newsTitle;

    public PopupWindowListViewAdapter(Context context) {
        this.context = context;
    }
    public void setTitle(List<String> newsTitle){
        this.newsTitle= newsTitle;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return newsTitle.size();
    }

    @Override
    public Object getItem(int position) {
        return newsTitle.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        PopupWindowHolder popupWindowHolder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_news_pop_window_list_view, null);
            popupWindowHolder = new PopupWindowHolder(convertView);
            convertView.setTag(popupWindowHolder);
        } else {
            popupWindowHolder = (PopupWindowHolder) convertView.getTag();
        }
        popupWindowHolder.newsTitle.setText(newsTitle.get(position));
        return convertView;
    }
    class PopupWindowHolder {
        private TextView newsTitle;
        public PopupWindowHolder(View view) {
            newsTitle = (TextView) view.findViewById(R.id.news_pop_window_text_veiw);

        }
    }
}
