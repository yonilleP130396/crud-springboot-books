package myProject.SimpleCrudApp.Repository;

import myProject.SimpleCrudApp.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Additional custom queries can be defined here if needed
}
