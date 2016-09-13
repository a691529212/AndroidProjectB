package vampire.com.androidprojectb.base;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by Vampire on 16/9/13.
 * 通用的Adapter
 */
public abstract class CommonAdapter<T> extends BaseAdapter {
    private List<T> beenList;
    private LayoutInflater inflater;
    private int converViewId;

    public CommonAdapter(List<T> beenList, Context context, int id) {
        this.beenList = beenList;
        inflater = LayoutInflater.from(context);
        converViewId = id;
    }

    @Override
    public int getCount() {
        return beenList != null ? beenList.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        CommonViewHolder commonViewHolder = CommonViewHolder.getHolder(convertView, inflater, converViewId, parent);
        setData(beenList.get(position),commonViewHolder);
        return commonViewHolder.getConvertView();
    }

    public abstract void setData(T t,CommonViewHolder viewHolder);
}
