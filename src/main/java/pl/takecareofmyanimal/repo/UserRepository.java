package pl.takecareofmyanimal.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.takecareofmyanimal.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}