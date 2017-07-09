package wolf.zero.litepal;

import java.util.Date;

/**
 * @author sineom
 * @version 1.0
 * @time 2017/7/5 21:55
 * @des ${TODO}
 * @updateAuthor ${Author}
 * @updataTIme 2017/7/5
 * @updataDes ${描述更新内容}
 */

public class News {
    private int id;

    private String title;

    private String content;

    private Date publishDate;

    private int commentCount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }
}
