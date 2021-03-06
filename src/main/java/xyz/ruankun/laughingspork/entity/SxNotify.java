package xyz.ruankun.laughingspork.entity;
//                            _ooOoo_
//                           o8888888o
//                           88" . "88
//                           (| -_- |)
//                           O\  =  /O
//                        ____/`---'\____
//                      .'  \\|     |//  `.
//                     /  \\|||  :  |||//  \
//                    /  _||||| -:- |||||-  \
//                    |   | \\\  -  /// |   |
//                    | \_|  ''\---/''  |   |
//                    \  .-\__  `-`  ___/-. /
//                  ___`. .'  /--.--\  `. . __
//               ."" '<  `.___\_<|>_/___.'  >'"".
//              | | :  `- \`.;`\ _ /`;.`/ - ` : | |
//              \  \ `-.   \_ __\ /__ _/   .-` /  /
//         ======`-.____`-.___\_____/___.-`____.-'======
//                            `=---='
//        ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
//                      Buddha Bless, No Bug !

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;

@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "sx_notify")
public class SxNotify {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "gmt_create")
    private Date gmtCreate = new Date();

    @Column(name = "gmt_modified")
    private Date gmtModified = new Date();

    @Column(name = "content")
    private String content;

    @Column(name = "publisher")
    private String publisher = "教务处-实习小组";

    // 点赞
    @Column(name = "praise")
    private Integer praise;

    /**
     * 踩
     */
    @Column(name = "low")
    private Integer low;

    /**
     * 阅读量
     */
    @Column(name = "readnum")
    private Integer read;

    @Transient
    private Integer total;

    public Integer getPraise() {
        return praise;
    }

    public void setPraise(Integer praise) {
        this.praise = praise;
    }

    public Integer getLow() {
        return low;
    }

    public void setLow(Integer low) {
        this.low = low;
    }

    public Integer getRead() {
        return read;
    }

    public void setRead(Integer read) {
        this.read = read;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    @Override
    public String toString() {
        return "SxNotify{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                ", content='" + content + '\'' +
                ", publisher='" + publisher + '\'' +
                ", total=" + total +
                '}';
    }
}
