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
import vampire.com.androidprojectb.fragment.topic.bean.AskDownSecondBean;

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
public class AskDownSecondAdapter extends BaseAdapter{
    private Context context;
    private AskDownSecondBean downSecondBean;

    public AskDownSecondAdapter(Context context) {
        this.context = context;
    }

    public void setDownSecondBean(AskDownSecondBean downSecondBean) {
        this.downSecondBean = downSecondBean;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return downSecondBean!=null?downSecondBean.getData().getLatestList().size():0;
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
            view=inflater.inflate(R.layout.ask_down_second_last,null);
            viewHolder=new ViewHolder(view);
            view.setTag(viewHolder);
        }else {
           viewHolder= (ViewHolder) view.getTag();
        }
        viewHolder.textViewName.setText(downSecondBean.getData().getLatestList().get(i).getQuestion().getUserName());
        viewHolder.textViewContent.setText(downSecondBean.getData().getLatestList().get(i).getQuestion().getContent());
        Uri uri=Uri.parse(downSecondBean.getData().getLatestList().get(i).getQuestion().getUserHeadPicUrl());
        viewHolder.simpleDraweeViewHeadUrl.setImageURI(uri);
        viewHolder.textViewAnswerName.setText(downSecondBean.getData().getLatestList().get(i).getAnswer().getSpecialistName());
        viewHolder.textViewAnswerCount.setText(downSecondBean.getData().getLatestList().get(i).getAnswer().getContent());
        Uri uri1=Uri.parse(downSecondBean.getData().getLatestList().get(i).getAnswer().getSpecialistHeadPicUrl());
        viewHolder.simpleDraweeViewAnswerHead.setImageURI(uri1);
        return view;
    }
    public  class ViewHolder{
        SimpleDraweeView simpleDraweeViewHeadUrl;
        TextView textViewName;
        TextView textViewContent;
        SimpleDraweeView simpleDraweeViewAnswerHead;
        TextView textViewAnswerName;
        TextView textViewAnswerCount;
        public  ViewHolder(View view){
              simpleDraweeViewHeadUrl= (SimpleDraweeView) view.findViewById(R.id.drawee_head_url);
            textViewName= (TextView) view.findViewById(R.id.text_name);
            textViewContent= (TextView) view.findViewById(R.id.text_content);
            simpleDraweeViewAnswerHead= (SimpleDraweeView) view.findViewById(R.id.drawee_answer_head);
            textViewAnswerName= (TextView) view.findViewById(R.id.text_answer_name);
            textViewAnswerCount= (TextView) view.findViewById(R.id.text_answer_count);
        }
    }
}
