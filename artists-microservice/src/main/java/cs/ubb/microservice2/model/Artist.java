package cs.ubb.microservice2.model;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "artist")
public class Artist {
    @Id
    @Column(name = "artist_id")
    private int artistId;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

    @Column(name = "genre")
    private String genre;
}
