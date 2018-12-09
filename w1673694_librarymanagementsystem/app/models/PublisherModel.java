package models;

import io.ebean.Model;

import javax.persistence.*;

@Entity
@Table(name = "w1673694_Publisher")
public class PublisherModel extends Model {

    @Id
    @Column(name = "pubId", unique = true, nullable = false)
    private int pubId;

    @Column(name = "pubComName", nullable = false)
    private String pubComName;

    public PublisherModel(String pubComName) {
        this.pubComName = pubComName;
    }

    public int getPubId() {
        return pubId;
    }

    public void setPubId(int pubId) {
        this.pubId = pubId;
    }

    public String getPubComName() {
        return pubComName;
    }

    public void setPubComName(String pubComName) {
        this.pubComName = pubComName;
    }

}
