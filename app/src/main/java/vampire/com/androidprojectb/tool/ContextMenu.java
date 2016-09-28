package vampire.com.androidprojectb.tool;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.yalantis.contextmenu.lib.ContextMenuDialogFragment;
import com.yalantis.contextmenu.lib.MenuObject;
import com.yalantis.contextmenu.lib.MenuParams;

import java.util.ArrayList;
import java.util.List;

import vampire.com.androidprojectb.R;
import vampire.com.androidprojectb.values.StringValues;

/**
 * Created by Vampire on 16/9/23.
 */
public class ContextMenu {
    private static ContextMenuDialogFragment mMenuDialogFragment;
    public static ContextMenuDialogFragment showContextMenu (){

        List<MenuObject> menuObjects = new ArrayList<>();
        for (int i = 0; i < StringValues.VOICE_NAME.length; i++) {
            MenuObject send = new MenuObject(StringValues.VOICE_NAME[i]);
            send.setResource(StringValues.VOICE_PIC[i]);
            send.setScaleType(ImageView.ScaleType.CENTER_CROP);
            menuObjects.add(send);
        }

        MenuParams menuParams = new MenuParams();

        menuParams.setFitsSystemWindow(true);
        menuParams.setActionBarSize(300);
        menuParams.setMenuObjects(menuObjects);
        // 外部不可点击
        menuParams.setClosableOutside(false);
        // set other settings to meet your needs
        mMenuDialogFragment = ContextMenuDialogFragment.newInstance(menuParams);
        return mMenuDialogFragment;
    }


}
