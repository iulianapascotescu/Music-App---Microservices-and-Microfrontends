package cs.ubb.microservice1.controller;

import cs.ubb.microservice1.model.Song;
import cs.ubb.microservice1.repository.SongRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SongController {

    private final SongRepository songRepository;

    public SongController(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    @GetMapping("/songs/artist/{artistName}")
    public ResponseEntity<List<Song>> getAllSongsOfArtist(@PathVariable String artistName) {
        List<Song> songs = songRepository.findAllByArtistName(artistName);
        return ResponseEntity.ok(songs);
    }

    @GetMapping("/songs/{songId}")
    public ResponseEntity<Song> getSongById(@PathVariable int songId) {
        return ResponseEntity.ok(songRepository.findById(songId)
                .orElseThrow(() -> new RuntimeException("Song with id=" + songId + " not found.")));
    }
}
