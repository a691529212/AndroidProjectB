package vampire.com.androidprojectb.fragment.news.bean;

import java.util.List;

/**
 * Created by Vampire on 16/9/12.
 */
public class NewsReuseBean {
    private static final String TAG = "Vampire_NewsBean";


    /**
     * code : 200
     * msg : success
     * newslist : [{"ctime":"2016-09-12 17:36","title":"上海浦东机场爆炸案嫌犯被捕：爱买六合彩，选人少些地","description":"网易社会","picUrl":"http://s.cimg.163.com/catchpic/B/B8/B83419F49560F56840D9DA8D778758C2.jpg.119x83.jpg","url":"http://news.163.com/16/0912/17/C0PGFKGN00014SEH.html#f=slist"},{"ctime":"2016-09-12 17:36","title":"视频｜三岁\u201c熊孩子\u201d闹市偷开快递电动三轮，撞上路边","description":"网易社会","picUrl":"http://s.cimg.163.com/catchpic/B/B0/B06F4D773E8CB22B484B1E64C6BEC541.png.119x83.jpg","url":"http://news.163.com/16/0912/17/C0PGFKHE00014SEH.html#f=slist"},{"ctime":"2016-09-12 17:50","title":"毕业女学生称遭校长骗色 校长:她曾敲诈我5万未遂","description":"网易社会","picUrl":"http://s.cimg.163.com/catchpic/F/F8/F897F17909732DA80095708C5374F232.jpg.119x83.jpg","url":"http://news.163.com/16/0912/17/C0PH7ROU00014SEH.html#f=slist"},{"ctime":"2016-09-12 18:28","title":"四川女子被拐卖到青岛 28年后仍是\u201c黑户\u201d","description":"网易社会","picUrl":"http://s.cimg.163.com/catchpic/F/FC/FC5DC51D2526F18B6535DAC2129EE156.jpg.119x83.jpg","url":"http://news.163.com/16/0912/18/C0PJDPE6000146BE.html#f=slist"},{"ctime":"2016-09-12 18:45","title":"湖南公安厅:溆浦县警察系服有机磷农药自杀死亡","description":"网易社会","picUrl":"http://s.cimg.163.com/catchpic/B/B1/B10BA969D17E9D78A0D2B936BD8872E0.jpg.119x83.jpg","url":"http://news.163.com/16/0912/18/C0PKE5EJ0001124J.html#f=slist"},{"ctime":"2016-09-12 15:25","title":"湖南溆浦证实一民警在县公安局自杀，生前曾实名举报局","description":"网易社会","picUrl":"http://s.cimg.163.com/catchpic/3/39/39654792165411DDF06592181F5FCF6A.jpg.119x83.jpg","url":"http://news.163.com/16/0912/15/C0P8VVAE00014SEH.html#f=slist"},{"ctime":"2016-09-12 15:58","title":"云南镇雄罗坎3名小孩遭野蜂袭击 致一死两重伤","description":"网易社会","picUrl":"http://s.cimg.163.com/catchpic/B/B6/B6822096B271064D7276CAA050187658.jpg.119x83.jpg","url":"http://news.163.com/16/0912/15/C0PASCD500014AEE.html#f=slist"},{"ctime":"2016-09-12 16:39","title":"江苏两岁宝宝被宠物兔咬掉手指 妈妈当场晕倒","description":"网易社会","picUrl":"http://s.cimg.163.com/catchpic/4/44/4408DA0104511F471862E0E658579218.jpg.119x83.jpg","url":"http://news.163.com/16/0912/16/C0PD77BG00011229.html#f=slist"},{"ctime":"2016-09-12 16:43","title":"\u201c刘伶利案\u201d法院：2次判定开除无效 学校拒执行","description":"网易社会","picUrl":"http://s.cimg.163.com/catchpic/B/B8/B83419F49560F56840D9DA8D778758C2.jpg.119x83.jpg","url":"http://news.163.com/16/0912/16/C0PDDFIM0001124J.html#f=slist"},{"ctime":"2016-09-12 17:12","title":"员工触电身亡后老板伪造合同骗保60余万 4人被捕","description":"网易社会","picUrl":"http://s.cimg.163.com/catchpic/B/B0/B06F4D773E8CB22B484B1E64C6BEC541.png.119x83.jpg","url":"http://news.163.com/16/0912/17/C0PF27Q500014SEH.html#f=slist"}]
     */

    private int code;
    private String msg;
    /**
     * ctime : 2016-09-12 17:36
     * title : 上海浦东机场爆炸案嫌犯被捕：爱买六合彩，选人少些地
     * description : 网易社会
     * picUrl : http://s.cimg.163.com/catchpic/B/B8/B83419F49560F56840D9DA8D778758C2.jpg.119x83.jpg
     * url : http://news.163.com/16/0912/17/C0PGFKGN00014SEH.html#f=slist
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
        private String ctime;
        private String title;
        private String description;
        private String picUrl;
        private String url;

        public String getCtime() {
            return ctime;
        }

        public void setCtime(String ctime) {
            this.ctime = ctime;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getPicUrl() {
            return picUrl;
        }

        public void setPicUrl(String picUrl) {
            this.picUrl = picUrl;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

    @Override
    public String toString() {
        return "NewsReuseBean{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", newslist=" + newslist +
                '}';
    }
}
