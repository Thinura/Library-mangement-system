package models;

import io.ebean.Model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "w1673694_Author")
public class AuthorModel extends Model {

    @Id
    @GeneratedValue
    @Column(name = "authId")
    private int authId;

    @Column(name = "authName")
    private String authName;

    public AuthorModel(String authName) {
        this.authName = authName;
    }

    @ManyToMany
    private List<BookModel> w1673694_Books;

    public List<BookModel> getW1673694_Books() {
        return w1673694_Books;
    }

    public void setW1673694_Books(List<BookModel> w1673694_Books) {
        this.w1673694_Books = w1673694_Books;
    }

    public int getAuthId() {
        return authId;
    }

    public void setAuthId(int authId) {
        this.authId = authId;
    }

    public String getAuthName() {
        return authName;
    }

    public void setAuthName(String authName) {
        this.authName = authName;
    }

}
