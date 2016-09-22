package vampire.com.androidprojectb.tool.dbtool;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

/**
 * Created by Vampire on 16/9/20.
 */
@Entity
public class DBFavorite {
    @Id(autoincrement = true)
    private Long id;
    private String type;
    private String title;
    private String url;
    private String imgUrl;

    @Generated(hash = 67916786)
    public DBFavorite(Long id, String type, String title, String url, String imgUrl) {
        this.id = id;
        this.type = type;
        this.title = title;
        this.url = url;
        this.imgUrl = imgUrl;
    }

    @Generated(hash = 553012725)
    public DBFavorite() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImgUrl() {
        return this.imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    @Override
    public String toString() {
        return "DBFavorite{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                '}';
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
