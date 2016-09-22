package vampire.com.androidprojectb.fragment.topic.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

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

    public FindTopicLeftAdapter(Context context) {
        this.context = context;
    }

    public void setLefttBean(FindTopicBean lefttBean) {
        this.lefttBean = lefttBean;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return lefttBean!=null?lefttBean.getData().size():0;
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
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder = null;
        LayoutInflater inflater = LayoutInflater.from(context);
        if (view == null) {
            view = inflater.inflate(R.layout.find_topic_left, null);
            viewHolder=new ViewHolder(view);
            view.setTag(viewHolder);
        }else {
            viewHolder= (ViewHolder) view.getTag();
        }

        viewHolder.textViewleft.setText(lefttBean.getData().get(i).getName());
        return view;
    }

    public class ViewHolder {
        TextView textViewleft;

        public ViewHolder(View view) {
            textViewleft = (TextView) view.findViewById(R.id.find_text_left);
        }
    }
}
