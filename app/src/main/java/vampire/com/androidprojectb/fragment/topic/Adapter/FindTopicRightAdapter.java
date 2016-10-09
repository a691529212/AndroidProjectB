package vampire.com.androidprojectb.fragment.topic.Adapter;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

import vampire.com.androidprojectb.BuildConfig;
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
public class FindTopicRightAdapter extends BaseAdapter {
    private Context context;

    private List<FindTopicBean.DataBean.ListBean>  listBeen;



    public FindTopicRightAdapter(Context context) {
        this.context = context;
        listBeen =new ArrayList<>();
    }



    public void setListBeen(List<FindTopicBean.DataBean.ListBean> listBeen) {
        this.listBeen = listBeen;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {



        int count = (listBeen!=null?listBeen.size():0);
//        Log.d("FindTopicRightAdapter", "count:" + count);
        return count;
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
            view = inflater.inflate(R.layout.find_topic_right, null);
            viewHolder=new ViewHolder(view);
            view.setTag(viewHolder);
        }else {
            viewHolder= (ViewHolder) view.getTag();
        }
        try{
            viewHolder.textViewQuestionCounts.setText(listBeen.get(i).getQuestionCount()+"");
            viewHolder.textViewConcernCount.setText(listBeen.get(i).getConcernCount()+"");
            viewHolder.textViewName.setText(listBeen.get(i).getName());

            Uri uri=Uri.parse(listBeen.get(i).getHeadpicurl());
            viewHolder.draweeViewImage.setImageURI(uri);

        }catch (Exception e){

        }

        return view;
    }

    private class ViewHolder {
        private TextView textViewName;
        private TextView textViewConcernCount;
        private TextView textViewQuestionCounts;
        private SimpleDraweeView draweeViewImage;

        private ViewHolder(View view) {
            textViewName = (TextView) view.findViewById(R.id.text_name);
            textViewConcernCount = (TextView) view.findViewById(R.id.text_concern_count);
            textViewQuestionCounts = (TextView) view.findViewById(R.id.text_question_counts);
            draweeViewImage= (SimpleDraweeView) view.findViewById(R.id.drawee_view_image);
        }
    }
}
