package vampire.com.androidprojectb.fragment.news.tantan;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import vampire.com.androidprojectb.R;
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
 * Created by R on 16/9/21.
 */

public class CardAdapter extends BaseAdapter {
    private Context mContext;
    private NewsReuseBean mCardList;
    private int i = 0;

    public void setmCardList(NewsReuseBean mCardList) {
        this.mCardList = mCardList;
        notifyDataSetChanged();
    }

    public CardAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return mCardList == null ? 0 : Integer.MAX_VALUE;
    }

    @Override
    public Object getItem(int position) {
        i++;
        return mCardList.getNewslist().get(i%50);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) mContext
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_tantan, parent, false);
            holder = new ViewHolder(convertView);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        Glide.with(mContext)
                .load(mCardList.getNewslist().get(i%50).getPicUrl())
                .into(holder.mCardImageView);
        holder.mCardName.setText(mCardList.getNewslist().get(i%50).getTitle());
        return convertView;
    }

    class ViewHolder {
        TextView mCardName;
        ImageView mCardImageView;

        public ViewHolder(View view) {
            mCardImageView = (ImageView) view.findViewById(R.id.helloText);
            mCardName = (TextView) view.findViewById(R.id.card_name);

        }
    }
}
