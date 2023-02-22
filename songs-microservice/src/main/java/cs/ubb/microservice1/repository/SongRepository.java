package cs.ubb.microservice1.repository;

import cs.ubb.microservice1.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SongRepository extends JpaRepository<Song, Integer> {
    List<Song> findAllByArtistName(String artistName);
}
