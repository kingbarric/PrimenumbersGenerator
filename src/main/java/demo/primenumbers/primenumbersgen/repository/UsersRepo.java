/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.primenumbers.primenumbersgen.repository;

 
import demo.primenumbers.primenumbersgen.model.Users;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author mac
 */
public interface UsersRepo extends CrudRepository<Users, Integer>{
    public Optional<Users> findByUsername(String username);
}
