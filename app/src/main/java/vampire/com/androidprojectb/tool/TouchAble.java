package vampire.com.androidprojectb.tool;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Vampire on 16/9/20.
 */
public class TouchAble {
    private static int lastX;
    private static int lastY;


    public static void moveEvent(View view, Context context) {

        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();

        final int screenWidth = displayMetrics.widthPixels;
        final int screenHeight = displayMetrics.heightPixels;

        view.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();
//        Log.d("MainActivity", "action:" + action);
                switch (action) {
                    case MotionEvent.ACTION_DOWN:
                        // 获取相对屏幕位置(不是界面)
                        lastX = (int) event.getRawX();
                        lastY = (int) event.getRawY();
                        break;
                    /**
                     * layout(l,t,r,b)
                     * l  Left position, relative to parent
                     * t  Top position, relative to parent
                     * r  Right position, relative to parent
                     * b  Bottom position, relative to parent
                     * */
                    case MotionEvent.ACTION_MOVE:
                        int dx = (int) (event.getRawX() - lastX);
                        int dy = (int) (event.getRawY() - lastY);

                        int left = v.getLeft() + dx;
                        int top = v.getTop() + dy;
                        int right = v.getRight() + dx;
                        int bottom = v.getBottom() + dy;
                        if (left < 0) {
                            left = 0;
                            right = left + v.getWidth();
                        }
                        if (right > screenWidth) {
                            right = screenWidth;
                            left = right - v.getWidth();
                        }
                        if (top < 0) {
                            top = 0;
                            bottom = top + v.getHeight();
                        }
                        if (bottom + 1.5 * v.getHeight() >= screenHeight) {
                            bottom = screenHeight - v.getHeight() * 2;
                            top = bottom - v.getHeight();
                        }
                        v.layout(left, top, right, bottom);

                        lastX = (int) event.getRawX();
                        lastY = (int) event.getRawY();

                        break;
                    case MotionEvent.ACTION_UP:
                        break;
                }
                return false;
            }
        });
    }
}
