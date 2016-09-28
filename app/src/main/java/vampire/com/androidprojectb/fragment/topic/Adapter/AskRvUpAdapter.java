package vampire.com.androidprojectb.fragment.topic.Adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import vampire.com.androidprojectb.R;
import vampire.com.androidprojectb.fragment.topic.bean.AskUpBean;

/**
 * code is far away from bug with the animal protecting
 * <p/>
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
public class AskRvUpAdapter extends RecyclerView.Adapter<AskRvUpAdapter.MyViewHolder>{
    private Context context;
    private AskUpBean upBean;
    private  int coutnt = 5;
    private OnItemOclickAsk onItemOclickAsk;

    public void setOnItemOclickAsk(OnItemOclickAsk onItemOclickAsk) {
        this.onItemOclickAsk = onItemOclickAsk;
    }

    public  interface  OnItemOclickAsk{
        void ItemOnClick(int pos);
    }
    public void setCoutnt(int coutnt) {
        this.coutnt = coutnt;
        notifyDataSetChanged();
    }

    public AskRvUpAdapter(Context context) {
        this.context = context;
    }

    public void setUpBean(AskUpBean upBean) {
        this.upBean = upBean;
        notifyDataSetChanged();
    }

    @Override
    public AskRvUpAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.ask_up,parent,false);
        MyViewHolder viewHolder=new MyViewHolder(view);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(AskRvUpAdapter.MyViewHolder holder, final int position) {
        holder.textViewName.setText(upBean.getData().get(position).getName());
        Uri uri=Uri.parse(upBean.getData().get(position).getIcon());
        holder.simpleDraweeViewImage.setImageURI(uri);
        holder.relativeLayoutUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemOclickAsk.ItemOnClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {

        coutnt = (upBean!=null?coutnt:0);
        if (coutnt ==0&&upBean!=null){
            coutnt = 5;
        }

        Log.d("AskRvUpAdapter", "coutnt:" + coutnt);

        return coutnt;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        SimpleDraweeView simpleDraweeViewImage;
        TextView textViewName;
        RelativeLayout relativeLayoutUp;
        public MyViewHolder(View itemView) {
            super(itemView);
            simpleDraweeViewImage= (SimpleDraweeView) itemView.findViewById(R.id.drawee_view_icon);
            textViewName= (TextView) itemView.findViewById(R.id.text_name);
            relativeLayoutUp= (RelativeLayout) itemView.findViewById(R.id.rl_up);
        }
    }
}
