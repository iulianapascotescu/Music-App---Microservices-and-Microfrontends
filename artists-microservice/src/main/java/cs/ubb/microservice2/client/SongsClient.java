package cs.ubb.microservice2.client;

import cs.ubb.microservice2.dto.SongDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "songsapp", url = "http://songsapp:8080")
public interface SongsClient {

    @GetMapping("/songs/artist/{artistName}")
    List<SongDto> getAllSongsForArtist(@PathVariable String artistName);

    @GetMapping("/songs/{songId}")
    SongDto getSongById(@PathVariable int songId);
}
