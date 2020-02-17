/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.primenumbers.primenumbersgen.model;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
/**
 *
 * @author mac
 * timestamp, range, time elapsed, algorithm chosen and number of primes returned
 */
@Entity
public class StatsModel implements Serializable {
    
      @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false) 
    private Integer id;
      
      private Integer startPosition;
      
      private Integer endPosition;
      
      private String timeElapsed;
      
      private String algorithm;
      
      private Integer numberReturned;
      
       @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private Users  user;

    public StatsModel(Integer id, Integer startPosition, Integer endPosition, String timeElapsed, String algorithm, Integer numberReturned, Users user) {
        this.id = id;
        this.startPosition = startPosition;
        this.endPosition = endPosition;
        this.timeElapsed = timeElapsed;
        this.algorithm = algorithm;
        this.numberReturned = numberReturned;
        this.user = user;
    }

    public StatsModel() {
    }

 
       

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStartPosition() {
        return startPosition;
    }

    public void setStartPosition(Integer startPosition) {
        this.startPosition = startPosition;
    }

    public Integer getEndPosition() {
        return endPosition;
    }

    public void setEndPosition(Integer endPosition) {
        this.endPosition = endPosition;
    }

   

    public String getTimeElapsed() {
        return timeElapsed;
    }

    public void setTimeElapsed(String timeElapsed) {
        this.timeElapsed = timeElapsed;
    }

    public String getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
    }

    public Integer getNumberReturned() {
        return numberReturned;
    }

    public void setNumberReturned(Integer numberReturned) {
        this.numberReturned = numberReturned;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
      
      
      
}
