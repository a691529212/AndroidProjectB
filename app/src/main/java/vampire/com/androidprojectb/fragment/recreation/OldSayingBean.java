package vampire.com.androidprojectb.fragment.recreation;

import java.util.List;

/**
 * Created by Vampire on 16/9/13.
 */
public class OldSayingBean {
    private static final String TAG = "Vampire_OldSayingBean";

    /**
     * code : 200
     * msg : success
     * newslist : [{"id":"3636","content":"勤工俭学的意义还在于它能够培养和发挥青年的创造性和才能。如果我们给青年安排一条轻便的道路，他们只须饭来张嘴，上课就念书，什么也不管，这样我们就会害了青年，会使聪明人也变成傻瓜。","mrname":"徐特立"}]
     */

    private int code;
    private String msg;
    /**
     * id : 3636
     * content : 勤工俭学的意义还在于它能够培养和发挥青年的创造性和才能。如果我们给青年安排一条轻便的道路，他们只须饭来张嘴，上课就念书，什么也不管，这样我们就会害了青年，会使聪明人也变成傻瓜。
     * mrname : 徐特立
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
        private String content;
        private String mrname;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getMrname() {
            return mrname;
        }

        public void setMrname(String mrname) {
            this.mrname = mrname;
        }
    }
}
