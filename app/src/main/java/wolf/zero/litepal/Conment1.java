package wolf.zero.litepal;

import org.litepal.crud.DataSupport;

/**
 * @author sineom
 * @version 1.0
 * @time 2017/7/5 21:55
 * @des ${TODO}
 * @updateAuthor ${Author}
 * @updataTIme 2017/7/5
 * @updataDes ${描述更新内容}
 */

public class Conment1 extends DataSupport{
    private String title;

    private String content;

    private String collect_count;
    private String year;
    private String conmentId;


    private String original_title;
    private String subtype;
    private String alt;


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

    public String getCollect_count() {
        return collect_count;
    }

    public void setCollect_count(String collect_count) {
        this.collect_count = collect_count;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getConmentId() {
        return conmentId;
    }

    public void setConmentId(String conmentId) {
        this.conmentId = conmentId;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public String getSubtype() {
        return subtype;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }
}
