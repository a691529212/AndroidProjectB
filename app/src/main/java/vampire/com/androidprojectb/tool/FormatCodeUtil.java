package vampire.com.androidprojectb.tool;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Created vampires by *Vampire* on 16/8/30.
 */
public class FormatCodeUtil {
    public static String codingFormat(String str) {

        try {
            String utfStr = URLEncoder.encode(str, "utf-8");
            return utfStr;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "" ;
    }
}
