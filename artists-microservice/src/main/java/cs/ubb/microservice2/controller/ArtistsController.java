package cs.ubb.microservice2.controller;

import cs.ubb.microservice2.client.SongsClient;
import cs.ubb.microservice2.dto.SongDto;
import cs.ubb.microservice2.model.Artist;
import cs.ubb.microservice2.repository.ArtistsRepository;
import cs.ubb.microservice2.service.SpotifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
public class ArtistsController {

    @Autowired
    private SongsClient songsClient;

    @Autowired
    private SpotifyService spotifyService;

    @Autowired
    private ArtistsRepository artistsRepository;

    @GetMapping("/login")
    public ResponseEntity<Void> login(){
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/artists")
    public ResponseEntity<List<Artist>> getAllArtists(){
        return ResponseEntity.ok(artistsRepository.findAll());
    }

    @GetMapping("/artists/{artistId}/songs")
    public ResponseEntity<List<SongDto>> getAllSongsOfArtist(@PathVariable int artistId){
        Artist artist = artistsRepository.findById(artistId).orElseThrow(() -> new RuntimeException(""));
        List<SongDto> songs = songsClient.getAllSongsForArtist(artist.getName());
        return ResponseEntity.ok(songs);
    }

    @GetMapping("/artists/songs/{songId}")
    public ResponseEntity<Long> getDurationOfSong(@PathVariable int songId) throws IOException, InterruptedException {
        SongDto song = songsClient.getSongById(songId);
        Long duration = spotifyService.getDurationOfSong(song.getName());
        return ResponseEntity.ok(TimeUnit.MILLISECONDS.toSeconds(duration));
    }
}
