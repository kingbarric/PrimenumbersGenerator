/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.primenumbers.primenumbersgen.facade;
 
import demo.primenumbers.primenumbersgen.model.Users;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author Eric Barima
 */
 
public interface UsersFacade {
    
     public ResponseEntity saveUser(Users users);
    
}
