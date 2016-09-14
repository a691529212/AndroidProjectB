package vampire.com.androidprojectb.fragment.recreation.twister;

import java.util.List;

/**
 * Created by Vampire on 16/9/14.
 */
public class TwisterBean {
    private static final String TAG = "Vampire_TwisterBean";

    /**
     * code : 200
     * msg : success
     * newslist : [{"content":"船儿张开帆，<br/>帆儿挂上船。<br/>船和帆突然翻了脸，<br/>粗喉大嗓子吵翻天。<br/>船说：\u201c要不是我背着帆，<br/>准会轻轻快跑飞驰如箭般。\u201d<br/>帆说：\u201c要不是船拖着我，<br/>便会快速航行似闪电！\u201d<br/>船说：\u201c我帮了帆的忙。\u201d<br/>帆说：\u201c我推着船驶向前\u2026\u2026\u201d<br/>突然一阵大风来，<br/>帆儿被掀下船，<br/>这时候，船儿没有了帆，<br/>帆儿离开了船，<"}]
     */

    private int code;
    private String msg;
    /**
     * content : 船儿张开帆，<br/>帆儿挂上船。<br/>船和帆突然翻了脸，<br/>粗喉大嗓子吵翻天。<br/>船说：“要不是我背着帆，<br/>准会轻轻快跑飞驰如箭般。”<br/>帆说：“要不是船拖着我，<br/>便会快速航行似闪电！”<br/>船说：“我帮了帆的忙。”<br/>帆说：“我推着船驶向前……”<br/>突然一阵大风来，<br/>帆儿被掀下船，<br/>这时候，船儿没有了帆，<br/>帆儿离开了船，<
     */

    private List<NewslistBean> newslist;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<NewslistBean> getNewslist() {
        return newslist;
    }

    public void setNewslist(List<NewslistBean> newslist) {
        this.newslist = newslist;
    }

    public static class NewslistBean {
        private String content;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }
}
