/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.primenumbers.primenumbersgen.facadeimplementation;

 
import demo.primenumbers.primenumbersgen.facade.UsersFacade;
import demo.primenumbers.primenumbersgen.model.Users;
import demo.primenumbers.primenumbersgen.repository.UsersRepo;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 *
 * @author mac
 */

@Service
public class UserServiceImpl  implements UsersFacade{
    
    @Autowired
    private UsersRepo usersRepo;
    
    
    /**
     *  
     * @param users
     * @return ResponseEntity containing existing user or create one and return, else error message
     *  
     * Save new user  or return one
     */
    @Override
    public ResponseEntity saveUser(Users users){
        
        try {
            Users user;
            //find if username is not empty
            if(users.getUsername().length()==0){
                return  ResponseEntity.ok("Username cannot be empty");
            }
            Optional<Users> optionalUser = this.usersRepo.findByUsername(users.getUsername());
            if(!optionalUser.isPresent()){
           user =     usersRepo.save(users);
            }else {
                user = optionalUser.get();
            }
            
            return  ResponseEntity.ok(user);
            
            
        } catch (Exception e) {
            //rare case of exception
            return ResponseEntity.ok("Error occured while saving user");
        }
    }
}
