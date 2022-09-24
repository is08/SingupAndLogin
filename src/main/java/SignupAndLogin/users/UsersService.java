package SignupAndLogin.users;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class UsersService {

    @Autowired
    private UsersRepository usersRepository;

    public List<Users> getAll() {
        return usersRepository.findAll().stream().map(users -> new Users(users.getFirstName(), users.getLastName(), users.getEmail(), users.getLoggedIn())).collect(Collectors.toList());
    }


    public Users getSpecific(String email) {
        return usersRepository.findById(email).get();
    }
}
