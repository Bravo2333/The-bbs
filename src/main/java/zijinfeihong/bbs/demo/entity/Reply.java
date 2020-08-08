package zijinfeihong.bbs.demo.entity;

import java.util.Date;

/**
 * @author sherman
 * @create 2020--08--06 17:30
 */
public class Reply {
    private int id;
    private String author;
    private Date time;
    private int like;
    private String content;
    private int rid;
    private int isThird;

    public Reply(String author, Date time, String content, int rid, int isThird) {
        this.author = author;
        this.time = time;
        this.content = content;
        this.rid = rid;
        this.isThird=isThird;
    }

    public Reply(int id, String author, Date time, int like, String content, int rid, int isThird) {
        this.id = id;
        this.author = author;
        this.time = time;
        this.like = like;
        this.content = content;
        this.rid = rid;
        this.isThird=isThird;
    }

    public int getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public Date getTime() {
        return time;
    }

    public int getLike() {
        return like;
    }

    public String getContent() {
        return content;
    }

    public int getRid() {
        return rid;
    }

    public int getIsThird() {
        return isThird;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public void setIsThird(int isThird) {
        this.isThird = isThird;
    }
}
