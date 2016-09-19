package vampire.com.androidprojectb.fragment.user;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

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
public class CollectAdapter extends FragmentPagerAdapter{
    private ArrayList<Fragment> fragments;
    private Context context;
    private ArrayList<String> arrayList;

    public void setArrayList(ArrayList<String> arrayList) {
        this.arrayList = arrayList;
    }

    public CollectAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context=context;
    }

    public void setFragments(ArrayList<Fragment> fragments) {
        this.fragments = fragments;
    }

    /**
     * Return the Fragment associated with a specified position.
     *
     * @param position
     */
    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    /**
     * Return the number of views available.
     */
    @Override
    public int getCount() {
        return fragments!=null?fragments.size():0;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return arrayList.get(position);
    }
}
