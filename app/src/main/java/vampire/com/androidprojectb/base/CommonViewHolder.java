package vampire.com.androidprojectb.base;

import android.net.Uri;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

/**
 * Created by Vampire on 16/9/13.
 * 一个通用的viewHolder;适用于所有的adapter
 */
public class CommonViewHolder {
    private static final String TAG = "Vampire_CommonViewHolder";
    //SparseArray可以看成Key值是int类型的HasMap;
    // 是android特有的 , 效率比HasMap高
    private SparseArray<View> views;
    private View convertView; // 行布局

    public static CommonViewHolder getHolder(View convertView, LayoutInflater inflater, int id, ViewGroup parent) {
        CommonViewHolder viewHolder;
        if (convertView == null) {
            View view = inflater.inflate(id, parent, false);
            viewHolder = new CommonViewHolder(view);

        }else {
            viewHolder = (CommonViewHolder) convertView.getTag();
        }
        return viewHolder;
    }

    // 返回行布局
    public View getConvertView() {
        return convertView;
    }

    public CommonViewHolder(View convertView) {
        views = new SparseArray<>();
        this.convertView = convertView;
        this.convertView.setTag(this);
    }

    /**
     * 通过id来获得行布局里指定的view的方法
     *
     * @param id view的id
     * @return 该id所对应的view
     */
    public <T extends View> T getView(int id) {
        View view = views.get(id);
        if (view == null) {
            //执行findViewById 找到这个组件 然后放到views里
            view = convertView.findViewById(id);
            // 放到views里
            views.put(id, view);
        }
        return (T) view;
    }

    // 设置文字
    public void setText(int id, String text) {
        TextView textView = getView(id);
        textView.setText(text);
    }

    // 设置图片
    public void setImage(int id ,String url){
        Uri uri =Uri.parse(url);
        SimpleDraweeView simpleDraweeView =getView(id);
        simpleDraweeView.setImageURI(uri);
    }

}
