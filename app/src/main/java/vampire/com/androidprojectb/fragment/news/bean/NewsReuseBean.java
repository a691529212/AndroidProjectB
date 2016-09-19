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
     * newslist : [{"ctime":"2016-09-13 12:49","title":"北京市重大疾病样本库成全球最大库","description":"网易健康","picUrl":"http://imgsize.ph.126.net/?imgurl=http://cms-bucket.nosdn.127.net/a7328fdfcb2d475b9f42464635d64a0420160913124946.jpeg_150x100x1x85.jpg","url":"http://jiankang.163.com/16/0913/12/C0RIE2SF0038804U.html"},{"ctime":"2016-09-13 12:56","title":"女孩获得男儿心 移植心脏手术成功","description":"网易健康","picUrl":"http://imgsize.ph.126.net/?imgurl=http://cms-bucket.nosdn.127.net/0d95e66da6f14cb49c3a21ecb14b4ad120160913125630.jpeg_150x100x1x85.jpg","url":"http://jiankang.163.com/16/0913/12/C0RIQCRF0038804U.html"},{"ctime":"2016-09-12 12:59","title":"互联网＋明厨亮灶 将小吃和夜市管起来","description":"网易健康","picUrl":"http://imgsize.ph.126.net/?imgurl=http://cms-bucket.nosdn.127.net/9d69fd208481482bb80643353af558c420160912130011.jpeg_150x100x1x85.jpg","url":"http://jiankang.163.com/16/0912/12/C0P0KFMJ0038804U.html"},{"ctime":"2016-09-09 12:24","title":"抽验合格率98.6％ 三家企业召回问题月饼","description":"网易健康","picUrl":"http://imgsize.ph.126.net/?imgurl=http://cms-bucket.nosdn.127.net/f8f2dfdee50942e29b31b32e38ec855420160909122504.jpeg_150x100x1x85.jpg","url":"http://jiankang.163.com/16/0909/12/C0H7DT2B0038804U.html"},{"ctime":"2016-09-08 09:14","title":"进口巴氏奶出问题概率 是国内奶的100倍","description":"网易健康","picUrl":"http://imgsize.ph.126.net/?imgurl=http://cms-bucket.nosdn.127.net/0b85d4b79cf04ca9b73b4e77328baf9e20160908120340.jpeg_150x100x1x85.jpg","url":"http://jiankang.163.com/16/0908/09/C0ECEJ3I00388165.html"},{"ctime":"2016-09-08 09:13","title":"\u201c粪菌库\u201d已建4年 做志愿者不易合格率2%","description":"网易健康","picUrl":"http://imgsize.ph.126.net/?imgurl=http://cms-bucket.nosdn.127.net/e278b410377f42d3a4f8aa3a6e6bc56f20160908115207.jpeg_150x100x1x85.jpg","url":"http://jiankang.163.com/16/0908/09/C0EBIFVI00388165.html"},{"ctime":"2016-09-07 12:31","title":"多地明确9月底前完成养老金调整足额发放","description":"网易健康","picUrl":"http://imgsize.ph.126.net/?imgurl=http://cms-bucket.nosdn.127.net/d0e60174734e456ba60b12407b8faa5220160907123130.jpeg_150x100x1x85.jpg","url":"http://jiankang.163.com/16/0907/12/C0C3078I0038804U.html"},{"ctime":"2016-09-07 12:36","title":"中国微生物领域专利 数量位居世界第一","description":"网易健康","picUrl":"http://imgsize.ph.126.net/?imgurl=http://cms-bucket.nosdn.127.net/89bae3bbc94640b8ba88716e4f39d02b20160907123725.jpeg_150x100x1x85.jpg","url":"http://jiankang.163.com/16/0907/12/C0C3ARS10038804U.html"},{"ctime":"2016-09-06 08:47","title":"美国禁售部分洗浴用品 或造成健康危害","description":"网易健康","picUrl":"http://imgsize.ph.126.net/?imgurl=http://cms-bucket.nosdn.127.net/catchpic/a/a4/a4eeefbea8b5037684921d39dbd20c10.jpg_150x100x1x85.jpg","url":"http://jiankang.163.com/16/0906/09/C096MNAQ00388165.html"},{"ctime":"2016-09-06 09:00","title":"月饼新标准已出台 新旧版本包装仍然并存","description":"网易健康","picUrl":"http://imgsize.ph.126.net/?imgurl=http://cms-bucket.nosdn.127.net/catchpic/a/a3/a36b2ab873041f0b3413889be24989dd.jpg_150x100x1x85.jpg","url":"http://jiankang.163.com/16/0906/09/C096VTN100388165.html"},{"ctime":"2016-09-05 07:21","title":"新加坡寨卡病例逾两百 病毒并非南美输入","description":"网易健康","picUrl":"http://imgsize.ph.126.net/?imgurl=http://cms-bucket.nosdn.127.net/42573ea66be647e9ab71ac727783c4cd20160905072157.jpeg_150x100x1x85.jpg","url":"http://jiankang.163.com/16/0905/07/C06CFVRQ0038804U.html"},{"ctime":"2016-09-04 15:02","title":"女性无痛人流手术只是个\u201c小手术\u201d吗？","description":"网易健康","picUrl":"http://imgsize.ph.126.net/?imgurl=http://cms-bucket.nosdn.127.net/e497fd60a2954801be600de53216706520160902195046.jpeg_150x100x1x85.jpg","url":"http://jiankang.163.com/16/0904/15/C04KF9BO0038804U.html"},{"ctime":"2016-09-02 12:00","title":"儿童医院取消窗口挂号 自助机能预约挂号","description":"网易健康","picUrl":"http://imgsize.ph.126.net/?imgurl=http://cms-bucket.nosdn.127.net/4c82cd885d684c479d932401f3f2755020160902120031.jpeg_150x100x1x85.jpg","url":"http://jiankang.163.com/16/0902/12/BVV57TOL0038804U.html"},{"ctime":"2016-09-02 12:06","title":"全国中小学校已铲除93块\u201c毒跑道\u201d","description":"网易健康","picUrl":"http://imgsize.ph.126.net/?imgurl=http://cms-bucket.nosdn.127.net/179f73580a7043b5873330b55f38677920160902120724.jpeg_150x100x1x85.jpg","url":"http://jiankang.163.com/16/0902/12/BVV5KD500038804U.html"},{"ctime":"2016-09-01 08:14","title":"商贩炸鸡加罂粟壳判刑 7个月竟售出10吨","description":"网易健康","picUrl":"http://imgsize.ph.126.net/?imgurl=http://cms-bucket.nosdn.127.net/388bce2356d4450e9f633ca4b16905fc20160901122539.jpeg_150x100x1x85.jpg","url":"http://jiankang.163.com/16/0901/09/BVS93A9S00388165.html"},{"ctime":"2016-08-31 07:32","title":"40岁还能长高4厘米？无良医院骗你没商量","description":"网易健康","picUrl":"http://imgsize.ph.126.net/?imgurl=http://cms-bucket.nosdn.127.net/26a77515beda417292d3df6745024c1620160831073322.jpeg_150x100x1x85.jpg","url":"http://jiankang.163.com/16/0831/07/BVPH4QF50038804U.html"},{"ctime":"2016-08-31 07:46","title":"259批进口产品入境被拒 \u201c花王\u201d上黑榜","description":"网易健康","picUrl":"http://imgsize.ph.126.net/?imgurl=http://cms-bucket.nosdn.127.net/f744718775f24b56b3a8fec536267c3520160831074636.jpeg_150x100x1x85.jpg","url":"http://jiankang.163.com/16/0831/07/BVPHTJIG0038804U.html"},{"ctime":"2016-08-30 09:37","title":"学生体质健康测试 你的孩子准备好了吗？","description":"网易健康","picUrl":"http://imgsize.ph.126.net/?imgurl=http://cms-bucket.nosdn.127.net/80b5eebbdb9c4dab8666cf44d56fca3620160830141022.jpeg_150x100x1x85.jpg","url":"http://jiankang.163.com/16/0830/10/BVN9FOU900388165.html"},{"ctime":"2016-08-29 06:25","title":"女童打狂犬疫苗 到第四针发现竟是消炎药","description":"网易健康","picUrl":"http://imgsize.ph.126.net/?imgurl=http://cms-bucket.nosdn.127.net/30b7eb7b5ca64b978e9df48c5f808d7720160829062537.jpeg_150x100x1x85.jpg","url":"http://jiankang.163.com/16/0829/06/BVK8FO910038804U.html"},{"ctime":"2016-08-28 06:12","title":"食药监需谨防网上\u201c黑外卖\u201d卷土重来","description":"网易健康","picUrl":"http://imgsize.ph.126.net/?imgurl=http://cms-bucket.nosdn.127.net/706f2fe9927c46949d3244d753671c8f20160828110627.jpeg_150x100x1x85.jpg","url":"http://jiankang.163.com/16/0828/08/BVHUBA3000388165.html"}]
     */

    private int code;
    private String msg;
    /**
     * ctime : 2016-09-13 12:49
     * title : 北京市重大疾病样本库成全球最大库
     * description : 网易健康
     * picUrl : http://imgsize.ph.126.net/?imgurl=http://cms-bucket.nosdn.127.net/a7328fdfcb2d475b9f42464635d64a0420160913124946.jpeg_150x100x1x85.jpg
     * url : http://jiankang.163.com/16/0913/12/C0RIE2SF0038804U.html
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
}
