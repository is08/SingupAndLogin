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
        Users tempUser = usersRepository.findById(email).get();

        return new Users(tempUser.getFirstName(), tempUser.getLastName(), tempUser.getEmail(), tempUser.getLoggedIn());
    }

    public Status registerUser(Users newUser) {
        if(usersRepository.existsById(newUser.getEmail())){
            return Status.USER_ALREADY_EXISTS;
        }
        else{
            newUser.setLoggedIn(false);
            usersRepository.save(newUser);
        }

        return Status.SUCCESS;
    }

    public Status login(String email) {

        if(!usersRepository.existsById(email)){
            return Status.USER_DOES_NOT_EXIST;
        }

        Users tempUser = usersRepository.findById(email).get();

        tempUser.setLoggedIn(true);

        usersRepository.save(tempUser);
        return Status.SUCCESS;
    }

    public Status delete(String email) {
        if(!usersRepository.existsById(email)){
            return Status.USER_DOES_NOT_EXIST;
        }

        usersRepository.deleteById(email);
        return Status.SUCCESS;
    }
}
