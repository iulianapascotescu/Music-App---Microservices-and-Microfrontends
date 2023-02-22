package cs.ubb.microservice2.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class SpotifyDto implements Serializable {
    private TracksDto tracks;
}
