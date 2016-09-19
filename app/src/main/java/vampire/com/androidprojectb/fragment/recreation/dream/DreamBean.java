package vampire.com.androidprojectb.fragment.recreation.dream;

import java.util.List;

/**
 * Created by Vampire on 16/9/19.
 */
public class DreamBean {

    private static final String TAG = "Vampire_DreamBean";

    /**
     * code : 200
     * msg : success
     * newslist : [{"id":"398","type":"植物类","title":"西瓜、吃西瓜","result":"梦见熟西瓜，是祥瑞。梦见生西瓜，是凶兆。梦见吃西瓜，出国能发大财。梦见有人抢自己手里的西瓜，会打输官司，损失巨大。病人梦见吃西瓜，会困难重重。"}]
     */

    private int code;
    private String msg;
    /**
     * id : 398
     * type : 植物类
     * title : 西瓜、吃西瓜
     * result : 梦见熟西瓜，是祥瑞。梦见生西瓜，是凶兆。梦见吃西瓜，出国能发大财。梦见有人抢自己手里的西瓜，会打输官司，损失巨大。病人梦见吃西瓜，会困难重重。
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
        private String id;
        private String type;
        private String title;
        private String result;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getResult() {
            return result;
        }

        public void setResult(String result) {
            this.result = result;
        }
    }
}
