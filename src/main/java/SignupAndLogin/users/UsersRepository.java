package SignupAndLogin.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository                     //tells spring to use this class for database management
public interface UsersRepository extends JpaRepository<Users, String> {                 //JpaRepository interacts with our table in the database
}
