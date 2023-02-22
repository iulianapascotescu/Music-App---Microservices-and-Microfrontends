package cs.ubb.microservice1.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "song")
public class Song {

    @Id
    @Column(name = "song_id")
    private int songId;

    @Column(name = "name")
    private String name;

    @Column(name = "release_year")
    private int releaseYear;

    @Column(name = "artist_name")
    private String artistName;
}
