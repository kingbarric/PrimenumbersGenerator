/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.primenumbers.primenumbersgen.repository;

 
import demo.primenumbers.primenumbersgen.model.StatsModel;
import demo.primenumbers.primenumbersgen.model.Users;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Eric Barima
 */
//@Repository
public interface StatsModelRepo  extends CrudRepository<StatsModel, Integer>{
    public List<StatsModel> findByUser(Users user);
    
}
