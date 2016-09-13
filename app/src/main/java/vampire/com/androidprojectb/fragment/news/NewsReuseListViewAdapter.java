package vampire.com.androidprojectb.fragment.news;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import jp.wasabeef.glide.transformations.CropCircleTransformation;
import vampire.com.androidprojectb.R;
import vampire.com.androidprojectb.base.MyApp;
import vampire.com.androidprojectb.fragment.news.bean.NewsReuseBean;

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

public class NewsReuseListViewAdapter extends BaseAdapter {
    private Context context;
    private NewsReuseBean bean;

//    public NewsReuseListViewAdapter(Context context) {
//        this.context= context;
//
//    }

    @Override
    public int getCount() {
        return bean.getNewslist().size();
    }

    @Override
    public Object getItem(int position) {
        return bean.getNewslist().get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        NewsReuseHolder newsReuseHolder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_news_reuse_list_view, parent, false);
            newsReuseHolder = new NewsReuseHolder(convertView);
            convertView.setTag(newsReuseHolder);
        } else {
            newsReuseHolder = (NewsReuseHolder) convertView.getTag();
        }
        Glide.with(MyApp.getContext()).load(bean.getNewslist().get(position).getPicUrl())
                .bitmapTransform(new CropCircleTransformation(MyApp.getContext())).into(newsReuseHolder.multiNewsIv);
        newsReuseHolder.titleMultiNewsTv.setText(bean.getNewslist().get(position).getTitle());
        newsReuseHolder.timeMultiNewsTv.setText(bean.getNewslist().get(position).getCtime());
        newsReuseHolder.replayMultiNewsTv.setText(bean.getNewslist().get(position).getDescription());
        return convertView;
    }
    class NewsReuseHolder {
        private ImageView multiNewsIv;
        private TextView titleMultiNewsTv, timeMultiNewsTv, replayMultiNewsTv;

        public NewsReuseHolder(View view) {
            multiNewsIv = (ImageView) view.findViewById(R.id.iv_multi_news_image);
            titleMultiNewsTv = (TextView) view.findViewById(R.id.tv_multi_news_title);
            timeMultiNewsTv = (TextView) view.findViewById(R.id.tv_multi_news_time);
            replayMultiNewsTv = (TextView) view.findViewById(R.id.tv_multi_news_reply_count);
        }
    }

    public void setBean(NewsReuseBean bean) {
        this.bean = bean;
    }
}
