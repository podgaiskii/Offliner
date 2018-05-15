package by.bsuir.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "reviews")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "user_id")
    private int userID;

    @Column(name = "mark")
    private int mark;

    @Column(name = "title")
    private String title;

    @Column(name = "contents")
    private String contents;

    @Column(name = "date")
    private Date date;

    public Review() {
        this.title = null;
        this.contents = null;
        this.date = null;
    }

    public Review(int userID, int mark, String title, String contents, Date date) {
        this.userID = userID;
        this.mark = mark;
        this.title = title;
        this.contents = contents;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Review review = (Review) o;
        return id == review.id &&
                userID == review.userID &&
                mark == review.mark &&
                Objects.equals(title, review.title) &&
                Objects.equals(contents, review.contents) &&
                Objects.equals(date, review.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userID, mark, title, contents, date);
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", userID=" + userID +
                ", mark=" + mark +
                ", title='" + title + '\'' +
                ", contents='" + contents + '\'' +
                ", date='" + date + '\'' +
                " }";
    }
}
