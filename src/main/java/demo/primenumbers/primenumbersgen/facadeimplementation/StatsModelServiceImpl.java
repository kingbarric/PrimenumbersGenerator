/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.primenumbers.primenumbersgen.facadeimplementation;

import demo.primenumbers.primenumbersgen.facade.StatsModelFacade;
import demo.primenumbers.primenumbersgen.model.StatsModel;
import demo.primenumbers.primenumbersgen.model.StatsModelDTO;
import demo.primenumbers.primenumbersgen.model.Users;
import demo.primenumbers.primenumbersgen.repository.StatsModelRepo;
import demo.primenumbers.primenumbersgen.repository.UsersRepo;
import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

/**
 *
 * @author Eric Barima
 */
@Service
public class StatsModelServiceImpl implements StatsModelFacade {

    @Autowired
    private StatsModelRepo statsModelRepo;
    Map message = new HashMap();

    @Autowired
    private UsersRepo usersRepo;
    private final String[] algo = {"bruteForceMethod", "Java8Stream", "SieveEratosthenes"};

    /**
     *
     * @param statsdto
     * @return ResponseEntity of currently save Stats model
     */
    @Override
    public ResponseEntity saveStats(StatsModelDTO statsdto) {
        message.clear();
        try {
            StatsModel stats = new ModelMapper().map(statsdto, StatsModel.class);
            if (stats.getStartPosition() == null) {

                message.put("code", 1);
                message.put("response", "Starts Position cannot be empty");
                return ResponseEntity.ok(message);
            }
            if (stats.getEndPosition() == null) {
                message.put("code", 1);
                message.put("response", "End Position cannot be empty");
                return ResponseEntity.ok(message);
            }

            if (stats.getAlgorithm().length() == 0) {

                message.put("code", 1);
                message.put("response", "Algorithm Position cannot be empty");
                return ResponseEntity.ok(message);
            }

            Optional< Users> user = usersRepo.findById(statsdto.getUserId());
            if (user.isPresent()) {
                stats.setUser(user.get());
            } else {
                message.put("code", 1);
                message.put("response", "No such user with the ID:  " + statsdto.getUserId() + " , Use getUser api to obtain one");
                return ResponseEntity.ok(message);

            }

            if (stats.getAlgorithm().equals(algo[0])) {
                //bruteForceMethod
                Instant start = Instant.now();
                LinkListHelper l = PrimeNumbers.bruteForceMethod(statsdto.getStartPosition(), statsdto.getEndPosition());
                int size = l.getSize();
                Instant end = Instant.now();

                String duration = Duration.between(start, end).toString();
                stats.setTimeElapsed(duration);
                stats.setNumberReturned(size);

            } else if (stats.getAlgorithm().equals(algo[1])) {
                //Java8Stream
                Instant start = Instant.now();
                LinkListHelper l = PrimeNumbers.java8Method(statsdto.getStartPosition(), statsdto.getEndPosition());
                int size = l.getSize();
                Instant end = Instant.now();

                String duration = Duration.between(start, end).toString();
                stats.setTimeElapsed(duration);
                stats.setNumberReturned(size);
                System.err.println("Size: " + size + "Duration:  " + duration);

            } else if (stats.getAlgorithm().equals(algo[2])) {
                //SieveEratosthenes
                Instant start = Instant.now();
                LinkListHelper l = PrimeNumbers.theSieveEratosthenesMethod(statsdto.getStartPosition(), statsdto.getEndPosition());
                int size = l.getSize();
                Instant end = Instant.now();

                String duration = Duration.between(start, end).toString();
                stats.setTimeElapsed(duration);
                stats.setNumberReturned(size);

            } else {
               

                    message.put("code", 1);
                    message.put("response", "Invalid Algorithm, try 'bruteForceMethod', 'Java8Stream', 'SieveEratosthenes'");
                    return ResponseEntity.ok(message);
             
            }
            StatsModel statsModel = this.statsModelRepo.save(stats);
            message.put("code", 0);
            message.put("Response", statsModel);
            return ResponseEntity.ok(message);

        } catch (Exception e) {
            // e.printStackTrace(); 
            message.put("code", 0);
            message.put("Response", "Error occured while saving Stats");
            return ResponseEntity.ok(message);
        }
    }

    /**
     *
     * @return ResponseEntity containing map of algorithm types
     */
    @Override
    public ResponseEntity getAlgorithmTypes() {

        Map mapper = new HashMap();
        mapper.put(1, algo[0]);
        mapper.put(2, algo[1]);
        mapper.put(3, algo[2]);

        return ResponseEntity.ok(mapper);
    }

    /**
     *
     * @return ResponseEntity containing all Statistic model
     */
    @Override
    public ResponseEntity findAllModelStatistics() {
        message.put("code", 0);
        message.put("Response", this.statsModelRepo.findAll());
        return ResponseEntity.ok(message);

    }

    @Override
    public ResponseEntity findStatsByUserID(int userId) {
        message.clear();
        Optional<Users> u = this.usersRepo.findById(userId);
        if (u.isPresent()) {
            List<StatsModel> userList = this.statsModelRepo.findByUser(u.get());

            message.put("code", 0);
            message.put("Response", userList);
            return ResponseEntity.ok(message);
        } else {

            message.put("code", 0);
            message.put("Response", "No user with the id : " + userId + " exist.");
            return ResponseEntity.ok(message);
        }

    }

}
