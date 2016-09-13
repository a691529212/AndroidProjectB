//package vampire.com.androidprojectb.fragment.user;
//
//import android.graphics.Bitmap;
//import android.graphics.BitmapFactory;
//
//import java.io.ByteArrayOutputStream;
//import java.io.IOException;
//
////import cn.bmob.v3.BmobUser;
//
///**
// * code is far away from bug with the animal protecting
// * <p/>
// * ┏┓　　　┏┓
// * ┏┛┻━━━┛┻┓
// * ┃　　　　　　　┃
// * ┃　　　━　　　┃
// * ┃　┳┛　┗┳　┃
// * ┃　　　　　　　┃
// * ┃　　　┻　　　┃
// * ┃　　　　　　　┃
// * ┗━┓　　　┏━┛
// * 　　┃　　　┃神兽保佑
// * 　　┃　　　┃永无BUG！  凯哥 祝你一路顺风
// * 　　┃　　　┗━━━┓
// * 　　┃　　　　　　　┣┓
// * 　　┃　　　　　　　┏┛
// * 　　┗┓┓┏━┳┓┏┛
// * 　　　┃┫┫　┃┫┫
// * 　　　┗┻┛　┗┻┛
// */
//public class MyUser extends BmobUser {
//    private byte[] icon;//用户头像
//
//    public void setIcon(Bitmap bitmap) {
//        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
//        //从输出流里拿到输出的数组,为icon赋值
//        //将图片转换成二进制
//        icon = byteArrayOutputStream.toByteArray();
//        try {
//            byteArrayOutputStream.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }
//
//    public Bitmap getIcon() {
//        if (icon != null) {
//            Bitmap bitmap = BitmapFactory.decodeByteArray(icon,0, icon.length);
//            return bitmap;
//
//        }
//        return null;
//    }
//}
