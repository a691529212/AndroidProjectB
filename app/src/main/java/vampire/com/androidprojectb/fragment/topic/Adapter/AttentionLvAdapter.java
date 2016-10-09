package vampire.com.androidprojectb.fragment.topic.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import vampire.com.androidprojectb.R;
import vampire.com.androidprojectb.tool.dbtool.DBFavorite;

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
public class AttentionLvAdapter extends BaseAdapter {
    private Context context;
    private List<DBFavorite> favorites;

    public void setFavorites(List<DBFavorite> favorites) {
        this.favorites = favorites;
        notifyDataSetChanged();
    }

    public AttentionLvAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return favorites!=null?favorites.size():0;
    }
   public  void  deletePos(int pos){
       favorites.remove(pos);
       notifyDataSetChanged();
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
            view = inflater.inflate(R.layout.attention_collect, null);
            viewHolder=new ViewHolder(view);
            view.setTag(viewHolder);
        }else {
            viewHolder= (ViewHolder) view.getTag();

        }
        viewHolder.textViewName.setText(favorites.get(i).getType());
        viewHolder.textViewAlias.setText(favorites.get(i).getTitle());
        return view;
    }

    public class ViewHolder {
        TextView textViewName;
        TextView textViewAlias;

        public ViewHolder(View view) {
          textViewName= (TextView) view.findViewById(R.id.text_name);
            textViewAlias= (TextView) view.findViewById(R.id.text_alias);
        }
    }
}
