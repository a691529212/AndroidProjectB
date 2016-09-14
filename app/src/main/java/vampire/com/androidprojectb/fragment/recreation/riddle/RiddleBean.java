package vampire.com.androidprojectb.fragment.recreation.riddle;

import java.util.List;

/**
 * Created by Vampire on 16/9/14.
 */
public class RiddleBean {
    private static final String TAG = "Vampire_RiddleBean";

    /**
     * code : 200
     * msg : success
     * newslist : [{"id":"117","quest":"不管长得多像的双胞胎,都会有人分得出来,这人是谁?","result":"他们自己"}]
     */

    private int code;
    private String msg;
    /**
     * id : 117
     * quest : 不管长得多像的双胞胎,都会有人分得出来,这人是谁?
     * result : 他们自己
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
        private String quest;
        private String result;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getQuest() {
            return quest;
        }

        public void setQuest(String quest) {
            this.quest = quest;
        }

        public String getResult() {
            return result;
        }

        public void setResult(String result) {
            this.result = result;
        }
    }
}
