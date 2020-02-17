/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.primenumbers.primenumbersgen.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author mac
 */
@Entity
public class Users implements  Serializable{
       @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false) 
    private Integer id;
       
       private String username;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
       
        @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<StatsModel> statsModels;

    public Users(Integer id, String username, List<StatsModel> statsModels) {
        this.id = id;
        this.username = username;
        this.statsModels = statsModels;
    }

    public Users() {
    }

 
        
        

    @JsonIgnore
    public List<StatsModel> getStatsModels() {
        return statsModels;
    }

    public void setStatsModels(List<StatsModel> statsModels) {
        this.statsModels = statsModels;
    }

    
        
        
        
}
