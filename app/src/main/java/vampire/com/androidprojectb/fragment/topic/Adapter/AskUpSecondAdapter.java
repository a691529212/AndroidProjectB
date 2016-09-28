package vampire.com.androidprojectb.fragment.topic.Adapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;

import vampire.com.androidprojectb.R;
import vampire.com.androidprojectb.fragment.topic.bean.AskUpSecondBean;

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
public class AskUpSecondAdapter extends BaseAdapter{
    private Context context;
    private AskUpSecondBean secondBean;

    public AskUpSecondAdapter(Context context) {
        this.context = context;
    }

    public void setSecondBean(AskUpSecondBean secondBean) {
        this.secondBean = secondBean;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return secondBean!=null?secondBean.getData().getExpertList().size():0;
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
            view=inflater.inflate(R.layout.ask_up_second_lv,null);
            viewHolder=new ViewHolder(view);
            view.setTag(viewHolder);
        }else {
            viewHolder= (ViewHolder) view.getTag();
        }
        viewHolder.textViewAlias.setText(secondBean.getData().getExpertList().get(i).getAlias());
        viewHolder.textViewTitle.setText(secondBean.getData().getExpertList().get(i).getTitle());
        viewHolder.textViewClassification.setText(secondBean.getData().getExpertList().get(i).getClassification());
        viewHolder.textViewQuestionCount.setText(secondBean.getData().getExpertList().get(i).getQuestionCount()+"");
        Uri uri=Uri.parse(secondBean.getData().getExpertList().get(i).getHeadpicurl());
        viewHolder.simpleDraweeViewHeadViewPicUrl.setImageURI(uri);
        RoundingParams roundingParams = RoundingParams.fromCornersRadius(5f);
        roundingParams.setBorder(0x12222222, 1.0f);
        roundingParams.setRoundAsCircle(true);
        viewHolder.simpleDraweeViewHeadViewPicUrl.getHierarchy().setRoundingParams(roundingParams);
        Uri uri1=Uri.parse(secondBean.getData().getExpertList().get(i).getPicurl());
        viewHolder.simpleDraweeViewPicUrl.setImageURI(uri1);
        return view;
    }
    public  class  ViewHolder{
        TextView textViewTitle;
        TextView textViewClassification;
        TextView textViewQuestionCount;
        TextView textViewAlias;
        SimpleDraweeView simpleDraweeViewPicUrl;
        SimpleDraweeView simpleDraweeViewHeadViewPicUrl;
        public  ViewHolder(View view){
            textViewTitle= (TextView) view.findViewById(R.id.text_title);
            textViewClassification= (TextView) view.findViewById(R.id.text_classification);
            textViewQuestionCount= (TextView) view.findViewById(R.id.text_question_counts);
            textViewAlias= (TextView) view.findViewById(R.id.text_alias);
            simpleDraweeViewPicUrl= (SimpleDraweeView) view.findViewById(R.id.image_pic_url);
            simpleDraweeViewHeadViewPicUrl= (SimpleDraweeView) view.findViewById(R.id.image_head_pic_url);
        }
    }
}
