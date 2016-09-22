package vampire.com.androidprojectb.fragment.topic.bean;

import java.util.List;

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
 */
public class AskUpBean {


    /**
     * message : 操作成功
     * data : [{"id":"law","name":"法律","icon":"http://img1.cache.netease.com/m//newsapp/subject/icon/fl.png","picurl":"http://img1.cache.netease.com/m//newsapp/subject/fl.png","createTime":1,"updateTime":15},{"id":"health2","name":"健康","icon":"http://img1.cache.netease.com/m//newsapp/subject/icon/jk_2.png","picurl":"http://img1.cache.netease.com/m//newsapp/subject/jk_2.png","createTime":1,"updateTime":14},{"id":"auto","name":"汽车","icon":"http://img1.cache.netease.com/m/newsapp/subject/icon/qc.png","picurl":"http://img1.cache.netease.com/m//newsapp/subject/qc.png","createTime":1,"updateTime":13},{"id":"finance","name":"财经","icon":"http://img1.cache.netease.com/m/newsapp/subject/icon/cj.png","picurl":"http://img1.cache.netease.com/m//newsapp/subject/cj.png","createTime":1,"updateTime":12},{"id":"history","name":"历史","icon":"http://img1.cache.netease.com/m/newsapp/subject/icon/ls.png","picurl":"http://img1.cache.netease.com/m//newsapp/subject/ls.png","createTime":1,"updateTime":11},{"id":"politic","name":"时政","icon":"http://img1.cache.netease.com/m/newsapp/subject/icon/sz.png","picurl":"http://img1.cache.netease.com/m//newsapp/subject/sz.png","createTime":1,"updateTime":10},{"id":"sport","name":"体育","icon":"http://img1.cache.netease.com/m/newsapp/subject/icon/ty.png","picurl":"http://img1.cache.netease.com/m//newsapp/subject/ty.png","createTime":1,"updateTime":9},{"id":"military","name":"军事","icon":"http://img1.cache.netease.com/m/newsapp/subject/icon/js.png","picurl":"http://img1.cache.netease.com/m//newsapp/subject/js.png","createTime":1,"updateTime":8},{"id":"travel","name":"旅游","icon":"http://img1.cache.netease.com/m/newsapp/subject/icon/ly.png","picurl":"http://img1.cache.netease.com/m//newsapp/subject/ly.png","createTime":1,"updateTime":7},{"id":"house","name":"房产","icon":"http://img1.cache.netease.com/m/newsapp/subject/icon/fc.png","picurl":"http://img1.cache.netease.com/m//newsapp/subject/fc.png","createTime":1,"updateTime":6},{"id":"science","name":"科技","icon":"http://img1.cache.netease.com/m/newsapp/subject/icon/kj.png","picurl":"http://img1.cache.netease.com/m//newsapp/subject/kj.png","createTime":1,"updateTime":5},{"id":"education","name":"教育","icon":"http://img1.cache.netease.com/m/newsapp/subject/icon/jy.png","picurl":"http://img1.cache.netease.com/m//newsapp/subject/jy.png","createTime":1,"updateTime":4},{"id":"entertainment","name":"娱乐","icon":"http://img1.cache.netease.com/m/newsapp/subject/icon/yl.png","picurl":"http://img1.cache.netease.com/m//newsapp/subject/yl.png","createTime":1,"updateTime":3},{"id":"health","name":"生活","icon":"http://img1.cache.netease.com/m/newsapp/subject/icon/sh.png","picurl":"http://img1.cache.netease.com/m//newsapp/subject/jk.png","createTime":1,"updateTime":2},{"id":"fashion","name":"时尚","icon":"http://img1.cache.netease.com/m/newsapp/subject/icon/ss.png","picurl":"http://img1.cache.netease.com/m//newsapp/subject/ss.png","createTime":1,"updateTime":1}]
     * code : 1
     */

    private String message;
    private int code;
    /**
     * id : law
     * name : 法律
     * icon : http://img1.cache.netease.com/m//newsapp/subject/icon/fl.png
     * picurl : http://img1.cache.netease.com/m//newsapp/subject/fl.png
     * createTime : 1
     * updateTime : 15
     */

    private List<DataBean> data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        private String id;
        private String name;
        private String icon;
        private String picurl;
        private int createTime;
        private int updateTime;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public String getPicurl() {
            return picurl;
        }

        public void setPicurl(String picurl) {
            this.picurl = picurl;
        }

        public int getCreateTime() {
            return createTime;
        }

        public void setCreateTime(int createTime) {
            this.createTime = createTime;
        }

        public int getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(int updateTime) {
            this.updateTime = updateTime;
        }
    }
}
