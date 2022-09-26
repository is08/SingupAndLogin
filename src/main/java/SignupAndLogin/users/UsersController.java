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

        try {
            return ResponseEntity.status(200).body(usersService.getSpecific(email));
        }
        catch (Exception e){
            return ResponseEntity.status(404).body("User doesn't exist " + e.getMessage());
        }
    }

    @PostMapping("/register")
    public ResponseEntity registerUser(@RequestBody Users newUser){

        if(usersService.registerUser(newUser) == Status.USER_ALREADY_EXISTS){
            return ResponseEntity.status(409).body(Status.USER_ALREADY_EXISTS);
        }

        try{
            usersService.registerUser(newUser);
            return ResponseEntity.status(200).body(Status.SUCCESS);
        }
        catch(Exception e){
            return ResponseEntity.status(404).body(Status.FAILURE + " " + e.getMessage());
        }

    }
}
