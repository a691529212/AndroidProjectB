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
 * Created by R on 16/9/13.
 */

public class PopupWindowListViewAdapter extends BaseAdapter{
    private Context context;

    public PopupWindowListViewAdapter(Context context) {
        this.context = context;
    }


    @Override
    public int getCount() {
        return   MyApp.getListTitle().size();
    }

    @Override
    public Object getItem(int position) {
        return  MyApp.getListTitle().get(position);
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
        popupWindowHolder.newsTitle.setText(  MyApp.getListTitle().get(position));
        return convertView;
    }
    class PopupWindowHolder {
        private TextView newsTitle;
        public PopupWindowHolder(View view) {
            newsTitle = (TextView) view.findViewById(R.id.news_pop_window_text_veiw);

        }
    }
}
