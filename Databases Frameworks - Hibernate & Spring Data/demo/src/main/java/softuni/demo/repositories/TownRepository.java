package softuni.demo.repositories;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.demo.entities.Town;

import java.util.List;

@Repository
public interface TownRepository extends JpaRepository<Town, Long> {

     List<Town> findAllById(Long id);
}
