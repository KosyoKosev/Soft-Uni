package softuni.users.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.users.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
}
