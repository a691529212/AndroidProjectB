package vampire.com.androidprojectb.fragment.news.adapter;

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

    public NewsReuseListViewAdapter(Context context) {
        this.context= context;

    }

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
            convertView = LayoutInflater.from(context).inflate(R.layout.item_news_reuse_list_view, null);
            newsReuseHolder = new NewsReuseHolder(convertView);
            convertView.setTag(newsReuseHolder);
        } else {
            newsReuseHolder = (NewsReuseHolder) convertView.getTag();
        }

        Glide.with(MyApp.getContext()).load(bean.getNewslist().get(position).getPicUrl()).placeholder(R.mipmap.imgres)
                .bitmapTransform(new CropCircleTransformation(MyApp.getContext())).into(newsReuseHolder.newsReusePicUrl);
        newsReuseHolder.newsReuseTitle.setText(bean.getNewslist().get(position).getTitle());
        newsReuseHolder.newsReuseCtime.setText(bean.getNewslist().get(position).getCtime());
        newsReuseHolder.newsReuseDescription.setText(bean.getNewslist().get(position).getDescription());
        return convertView;
    }
    class NewsReuseHolder {
        private ImageView newsReusePicUrl;
        private TextView newsReuseTitle, newsReuseCtime, newsReuseDescription;

        public NewsReuseHolder(View view) {
            newsReusePicUrl = (ImageView) view.findViewById(R.id.news_reuse_picurl_image_view);
            newsReuseTitle = (TextView) view.findViewById(R.id.news_reuse_title_text_view);
            newsReuseCtime = (TextView) view.findViewById(R.id.news_reuse_ctime_text_view);
            newsReuseDescription = (TextView) view.findViewById(R.id.news_reuse_description_text_view);
        }
    }

    public void setBean(NewsReuseBean bean) {
        this.bean = bean;
        notifyDataSetChanged();
    }
}
