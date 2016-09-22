package vampire.com.androidprojectb.fragment.topic.Adapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import vampire.com.androidprojectb.R;
import vampire.com.androidprojectb.fragment.topic.bean.VideoBean;

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
public class VideoAdapter extends BaseAdapter{
    private Context context;
    private VideoBean bean;

    public VideoAdapter(Context context) {
        this.context = context;
    }

    public void setBean(VideoBean bean) {
        this.bean = bean;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return bean!=null?bean.getLive_review().size():0;
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
        ViewHolder viewHolder=null;
        LayoutInflater inflater=LayoutInflater.from(context);
        if (view==null){
            view=inflater.inflate(R.layout.video_down,null);
            viewHolder=new ViewHolder(view);
            view.setTag(viewHolder);
        }else {
            viewHolder= (ViewHolder) view.getTag();
        }
        viewHolder.textViewUserCount.setText(bean.getLive_review().get(i).getUserCount()+"");
        viewHolder.textViewRoomName.setText(bean.getLive_review().get(i).getRoomName());
        Uri uri=Uri.parse(bean.getLive_review().get(i).getImage());
        viewHolder.draweeViewimage.setImageURI(uri);


        return view;
    }
    public  class  ViewHolder{
        SimpleDraweeView draweeViewimage;
        TextView textViewRoomName;
        TextView textViewUserCount;
        public  ViewHolder(View view){
          draweeViewimage= (SimpleDraweeView) view.findViewById(R.id.drawee_view_image);
            textViewRoomName= (TextView) view.findViewById(R.id.text_room_name);
            textViewUserCount= (TextView) view.findViewById(R.id.text_user_count);
        }
    }
}
