package zijinfeihong.bbs.demo.entity;

import java.util.Date;
import java.util.List;

/**
 * @author sherman
 * @create 2020--08--06 17:25
 */
public class Remark {

    private int id;
    private String author;
    private Date time;
    private int like;
    private String content;
    private int tid;
    private List<Reply> replies;

    public Remark(String author, Date time, String content, int tid) {
        this.author = author;
        this.time = time;
        this.content = content;
        this.tid = tid;
    }

    public Remark(int id, String author, Date time, int like, String content, int tid, List<Reply> replies) {
        this.id = id;
        this.author = author;
        this.time = time;
        this.like = like;
        this.content = content;
        this.tid = tid;
        this.replies = replies;
    }

    public Remark(int id, String author, Date time, int like, String content, int tid) {
        this.id = id;
        this.author = author;
        this.time = time;
        this.like = like;
        this.content = content;
        this.tid = tid;
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

    public int getTid() {
        return tid;
    }

    public List<Reply> getReplies() {
        return replies;
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

    public void setTid(int tid) {
        this.tid = tid;
    }

    public void setReplies(List<Reply> replies) {
        this.replies = replies;
    }
}
