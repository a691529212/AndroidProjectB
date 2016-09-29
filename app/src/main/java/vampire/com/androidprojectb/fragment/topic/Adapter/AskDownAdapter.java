package vampire.com.androidprojectb.fragment.topic.Adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import com.squareup.picasso.Picasso;


import vampire.com.androidprojectb.R;
import vampire.com.androidprojectb.fragment.topic.bean.AskDownBean;


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
public class AskDownAdapter extends BaseAdapter{
    private Context context;
    private AskDownBean askDownBean;
   private CardViewAskDownOnClick downOnClick;

    public void setDownOnClick(CardViewAskDownOnClick downOnClick) {
        this.downOnClick = downOnClick;
    }

    public AskDownAdapter(Context context) {
        this.context = context;
    }

    public void setAskDownBean(AskDownBean askDownBean) {
        this.askDownBean = askDownBean;
        notifyDataSetChanged();
    }
   public  interface  CardViewAskDownOnClick{
       void  ItemOclick(int pos);
   }
    @Override
    public int getCount() {
        return askDownBean!=null?askDownBean.getData().getExpertList().size():0;
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
    public View getView(final int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder=null;
        LayoutInflater inflater=LayoutInflater.from(context);
        if (view==null){
            view=inflater.inflate(R.layout.ask_down,null);
            viewHolder=new ViewHolder(view);
            view.setTag(viewHolder);
        }else {
            viewHolder= (ViewHolder) view.getTag();
        }
        viewHolder.textViewAlias.setText(askDownBean.getData().getExpertList().get(i).getAlias());
        viewHolder.textViewQuestionCount.setText(askDownBean.getData().getExpertList().get(i).getQuestionCount()+"");

        viewHolder.textViewClassification.setText(askDownBean.getData().getExpertList().get(i).getClassification());
        viewHolder.textViewTitle.setText(askDownBean.getData().getExpertList().get(i).getTitle());


        Uri uri1=Uri.parse(askDownBean.getData().getExpertList().get(i).getHeadpicurl());
        Log.d("AskDownAdapter", askDownBean.getData().getExpertList().get(i).getHeadpicurl());
        viewHolder.simpleDraweeViewHeadViewPicUrl.setImageURI(uri1);
        RoundingParams roundingParams = RoundingParams.fromCornersRadius(5f);
        roundingParams.setBorder(0x12222222, 1.0f);
        roundingParams.setRoundAsCircle(true);
        viewHolder.simpleDraweeViewHeadViewPicUrl.getHierarchy().setRoundingParams(roundingParams);

        Uri uri=Uri.parse(askDownBean.getData().getExpertList().get(i).getPicurl());
        viewHolder.simpleDraweeViewPicUrl.setImageURI(uri);
        viewHolder.cardViewAskDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                downOnClick.ItemOclick(i);
            }
        });
        return view;
    }
   public  class ViewHolder{
       TextView textViewTitle;
       TextView textViewClassification;
       TextView textViewQuestionCount;
       TextView textViewAlias;
       SimpleDraweeView simpleDraweeViewPicUrl;
       SimpleDraweeView simpleDraweeViewHeadViewPicUrl;
       CardView cardViewAskDown;
       public  ViewHolder(View view){
           textViewTitle= (TextView) view.findViewById(R.id.text_title);
           textViewClassification= (TextView) view.findViewById(R.id.text_classification);
           textViewQuestionCount= (TextView) view.findViewById(R.id.text_question_counts);
           textViewAlias= (TextView) view.findViewById(R.id.text_alias);
           simpleDraweeViewPicUrl= (SimpleDraweeView) view.findViewById(R.id.image_pic_url);
           simpleDraweeViewHeadViewPicUrl= (SimpleDraweeView) view.findViewById(R.id.image_head_pic_url);
           cardViewAskDown= (CardView) view.findViewById(R.id.card_view_ask_down);
       }
   }

}
