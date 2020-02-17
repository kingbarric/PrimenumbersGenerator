/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.primenumbers.primenumbersgen.facade;

 
import demo.primenumbers.primenumbersgen.model.StatsModelDTO;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author Eric Barima
 */
 
public interface StatsModelFacade {
    public ResponseEntity getAlgorithmTypes();
       public ResponseEntity findAllModelStatistics();
       public ResponseEntity saveStats(StatsModelDTO stats);
     public ResponseEntity findStatsByUserID(int userId) ;
}
