package vampire.com.androidprojectb.values;

/**
 * Created by Vampire on 16/9/12.
 */
public class UrlValues {
    //每六小时自动更新，随机返回

    // APIkey
    public static final String API_KEY = "35fe329001b3e54bfd917517f52fcbe0";

    // 返回文章数
    public static final String NUM = "?num=";

    // 文章分页
    public static final String SOCIAL_PAGE = "&page=";

    // 是否随机
    public static final String RAND = "&rand=";

    // 搜索关键字
    public static final String WORD = "&word=";

    // 指定来源
    public static final String SRC = "&src=";

    // 自己的星座(去除出'座')
    public static final String ME = "?me=";

    // 对象的星座(去除'座')
    public static final String HE = "&he=";

    // 对象为所有星座时
    public static final String all = "1";

    // 用于周公解梦的搜索关键字
    public static final String DREAM_WORD = "?word=";

    // 月份
    public static final String MOUTH = "?m=";

    // 日期
    public static final String DAY = "&d=";

    // 热门精选(参数 num:文章返回量(必填!10-50) , rand(是否随机) 1为随机 , world(搜索关键字), page(翻页 输出数量与nun有关),src: 指定文章来源 eg:人民日报 )
    public static final String HOT = "http://apis.baidu.com/txapi/weixin/wxhot";

    // 社会新闻(num , page) 10-50
//    public static final String SOCIAL = "http://apis.baidu.com/txapi/social/social";

    // 美女图片 (num) 10-50
    public static final String GIRL = "http://apis.baidu.com/txapi/mvtp/meinv";

    // 体育(num , page) 10-50
    public static final String SPORTS = "http://apis.baidu.com/txapi/tiyu/tiyu";

    // 科技新闻 (num , page) 10-50
    public static final String SCIENCE = "http://apis.baidu.com/txapi/keji/keji";

    // 国际新闻 (num , page) 10-50
    public static final String WORLD = "http://apis.baidu.com/txapi/world/world";

    //奇闻趣事 (num , page) 10-50
    public static final String INTERESTING = "http://apis.baidu.com/txapi/qiwen/qiwen";

    // 娱乐花边 (num , page)
    public static final String ENTERARTAINMENT = "http://apis.baidu.com/txapi/huabian/newtop";

    // 苹果新闻 (num , page) 10-50
    public static final String APPLE = "http://apis.baidu.com/txapi/apple/apple";

    // 生活健康 (num , page) 10-50
    public static final String HEALTH = "http://apis.baidu.com/txapi/health/health";

    // 脑筋急转弯
    public static final String RIDDLE = "http://apis.baidu.com/txapi/naowan/naowan";

    // 星座配对 参数 (me : 必填 , he : 对象星座 || all : 1)
    // tips : 需要去除"座"
    public static final String CONSTELLATION = "http://apis.baidu.com/txapi/xingzuo/xingzuo";

    // 名言警句
    public static final String SAYING = "http://apis.baidu.com/txapi/dictum/dictum";

    //生日预测 (月 / 日)
    public static final String BIRTHDAY = "http://apis.baidu.com/txapi/dob/dob";

    //绕口令 (参数 num 1 - 10)
    public static final String TONGUE_TWISTER = "http://apis.baidu.com/txapi/rkl/rkl";

    // 周公解梦 (参数 word) ()utf-8
    public static final String DREAM = "http://apis.baidu.com/txapi/dream/dream";


}
