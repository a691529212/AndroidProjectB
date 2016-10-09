package com.capricorn;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;

/**
 * Created by Vampire on 16/9/20.
 */
public class TouchAble {
    private static int lastX;
    private static int lastY;
    private static int startDownX;
    private static int startDownY;
    private static boolean isIntercept = false;


    public static void moveEvent(final View view, Context context) {

        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();

        final int screenWidth = displayMetrics.widthPixels;
        final int screenHeight = displayMetrics.heightPixels;

        view.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();
                switch (action) {
                    case MotionEvent.ACTION_DOWN:
                        // 获取相对屏幕位置(不是界面)
                        startDownX = lastX = (int) event.getRawX();
                        startDownY = lastY = (int) event.getRawY();
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
                        if (bottom + v.getHeight() >= screenHeight) {
                            bottom = screenHeight - v.getHeight();
                            top = bottom - v.getHeight();
                        }
                        v.layout(left, top, right, bottom);

                        lastX = (int) event.getRawX();
                        lastY = (int) event.getRawY();

                        break;
                    case MotionEvent.ACTION_UP:
                        v.setOnTouchListener(null);

                        int lastMoveDx = Math.abs((int) event.getRawX() - startDownX);
                        int lastMoveDy = Math.abs((int) event.getRawY() - startDownY);
                        if (0 != lastMoveDx || 0 != lastMoveDy) {
                            isIntercept = true;
                        } else {
                            isIntercept = false;
                        }
                        // 每次移动都要设置其layout，不然由于父布局可能嵌套listview，当父布局发生改变冲毁（如下拉刷新时）则移动的view会回到原来的位置
                        RelativeLayout.LayoutParams lpFeedback = new RelativeLayout.LayoutParams(
                                RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                        lpFeedback.leftMargin = v.getLeft();
                        lpFeedback.topMargin = v.getTop();
                        lpFeedback.setMargins(v.getLeft(), v.getTop(), 0, 0);
                        v.setLayoutParams(lpFeedback);
                        break;
                }
                return isIntercept;
            }
        });
    }
}
