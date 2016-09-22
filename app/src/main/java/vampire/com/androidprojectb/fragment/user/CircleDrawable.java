package vampire.com.androidprojectb.fragment.user;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;

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
 * 处理成圆形图片
 * 他是抽象的,我们不能自定义Drawable里来处理
 * View 的事件,逻辑
 * Drawable的好处,它不需要改动原始的组件
 */
public class CircleDrawable extends Drawable {
    private Bitmap mBitmap;//要处理的源图片
    private Paint mPaint;//画笔,来画图片
    private  int r;//圆形的半径

    public CircleDrawable(Bitmap bitmap) {
        this.mBitmap = bitmap;
        r= Math.min(bitmap.getWidth(),bitmap.getHeight())/2;
        mPaint=new Paint();
        mPaint.setAntiAlias(true);//设置抗拒齿
        //将图片处理成share,之后设置给画笔
        //接收3个参数,第一个参数是图片
        //第二三个参数是图片的重复属性,选中CLAMP,不重复

        BitmapShader bitmapShader=new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        //设置画笔的share属性,可以理解为,画笔的花纹,用这个画笔画出的东西
        //花纹就是我们的图片,所以直接花这个圆,就是圆形的图片
        mPaint.setShader(bitmapShader);
    }

    @Override
    public void draw(Canvas canvas) {
   canvas.drawCircle(r,r,r,mPaint);
    }

    //来确定该Drawable的具体范围
    @Override
    public int getIntrinsicHeight() {
        return r*2;
    }
    @Override
    public int getIntrinsicWidth() {
        return r*2;
    }

    @Override
    public void setAlpha(int i) {
        mPaint.setAlpha(i);
    }

    @Override
    public void setColorFilter(ColorFilter colorFilter) {
       mPaint.setColorFilter(colorFilter);
    }

    @Override
    public int getOpacity() {
        return 0;
    }
}
