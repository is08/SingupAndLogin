package SignupAndLogin.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    UsersService usersService;

    @GetMapping("")
    public ResponseEntity getAllUsers(){
        return ResponseEntity.status(200).body(usersService.getAll());
    }

    @GetMapping("/user")
    public ResponseEntity getSpecificUser(@RequestBody String email){

        System.out.println(email);

        try {
            return ResponseEntity.status(200).body(usersService.getSpecific(email));
        }
        catch (Exception e){
            return ResponseEntity.status(404).body("User doesn't exist " + e.getMessage());
        }
    }
}
