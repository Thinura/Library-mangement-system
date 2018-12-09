package models;

import io.ebean.Model;

import javax.persistence.*;

@Entity
@Table(name = "w1673694_Reader")
public class ReaderModel extends Model {

    @Id
    @Column(name = "redId")
    private int redId;

    @Column(name = "redName")
    private String redName;

    @Column(name = "redMobileNum")
    private long redMobileNum;

    @Column(name = "redEmail")
    private String redEmail;



    public ReaderModel(int redId, String redName, long redMobileNum, String redEmail) {
        this.redId = redId;
        this.redName = redName;
        this.redMobileNum = redMobileNum;
        this.redEmail = redEmail;
    }

    public int getRedId() {
        return redId;
    }

    public void setRedId(int redId) {
        this.redId = redId;
    }

    public String getRedName() {
        return redName;
    }

    public void setRedName(String redName) {
        this.redName = redName;
    }

    public long getRedMobileNum() {
        return redMobileNum;
    }

    public void setRedMobileNum(long redMobileNum) {
        this.redMobileNum = redMobileNum;
    }

    public String getRedEmail() {
        return redEmail;
    }

    public void setRedEmail(String redEmail) {
        this.redEmail = redEmail;
    }

}
