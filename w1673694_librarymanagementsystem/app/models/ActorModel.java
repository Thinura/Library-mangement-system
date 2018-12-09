package models;

import io.ebean.Model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "w1673694_Actor")
public class ActorModel extends Model{

    @Id
    @Column(name = "actId")
    private int actId;

    @Column(name = "actName")
    private String actName;

    public ActorModel(String actName) {
        this.actName = actName;
    }

    @ManyToMany
    private List<DVDModel> w1673694_DVD;

    public List<DVDModel> getW1673694_DVD() {
        return w1673694_DVD;
    }

    public void setW1673694_DVD(List<DVDModel> w1673694_DVD) {
        this.w1673694_DVD = w1673694_DVD;
    }

    public int getActId() {
        return actId;
    }

    public void setActId(int actId) {
        this.actId = actId;
    }

    public String getActName() {
        return actName;
    }

    public void setActName(String actName) {
        this.actName = actName;
    }

}
