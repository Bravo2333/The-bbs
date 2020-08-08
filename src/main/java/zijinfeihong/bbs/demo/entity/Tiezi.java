package zijinfeihong.bbs.demo.entity;

import java.util.Date;
import java.util.List;

/**
 * @author sherman
 * @create 2020--08--05 23:25
 */
public class Tiezi {

    private int id;
    private String author;
    private Date time;
    private int like;
    private String content;
    private List<Remark> remarks;

    public Tiezi(String author, String content, Date time) {
        this.author = author;
        this.content = content;
        this.time = time;
    }

    public Tiezi(int id, String author, Date time, int like, String content, List<Remark> remarks) {
        this.id = id;
        this.author = author;
        this.time = time;
        this.like = like;
        this.content = content;
        this.remarks = remarks;
    }

    public Tiezi(int id, String author, Date time, int like, String content) {
        this.id = id;
        this.author = author;
        this.time = time;
        this.like = like;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public String getContent() {
        return content;
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

    public List<Remark> getRemarks() {
        return remarks;
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

    public void setRemarks(List<Remark> remarks) {
        this.remarks = remarks;
    }
}
