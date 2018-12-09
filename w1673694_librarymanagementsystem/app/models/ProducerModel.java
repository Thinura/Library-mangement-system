package models;

import io.ebean.Model;

import javax.persistence.*;

@Entity
@Table(name = "w1673694_Producer")
public class ProducerModel extends Model {

    @Id
    @Column(name = "proId", unique = true, nullable = false)
    private int proId;

    @Column(name = "proName", nullable = false)
    private String proName;

    public ProducerModel(String proName) {
        this.proName = proName;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public int getProId() {
        return proId;
    }

    public void setProId(int proId) {
        this.proId = proId;
    }

}
