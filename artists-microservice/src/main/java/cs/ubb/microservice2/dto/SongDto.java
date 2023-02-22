package cs.ubb.microservice2.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class SongDto implements Serializable {
    private int songId;
    private String name;
    private int releaseYear;
    private String artistName;
}
