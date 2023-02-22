package cs.ubb.microservice2.repository;

import cs.ubb.microservice2.model.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistsRepository extends JpaRepository<Artist, Integer> {

}
