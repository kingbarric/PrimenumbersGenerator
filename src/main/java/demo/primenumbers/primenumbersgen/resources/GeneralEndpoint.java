/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.primenumbers.primenumbersgen.resources;

 
import demo.primenumbers.primenumbersgen.facade.StatsModelFacade;
import demo.primenumbers.primenumbersgen.facade.UsersFacade;
import demo.primenumbers.primenumbersgen.facadeimplementation.StatsModelServiceImpl;
import demo.primenumbers.primenumbersgen.facadeimplementation.UserServiceImpl;
import demo.primenumbers.primenumbersgen.model.StatsModelDTO;
import demo.primenumbers.primenumbersgen.model.Users;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author mac This end point is meant for exposing two services since they are
 * minimal api action , other wise each service would have their own endpoint
 */
@RestController
@RequestMapping("/api")
public class GeneralEndpoint {

    @Autowired
    private StatsModelFacade modelFacade;

    @Autowired
    private UsersFacade usersFacade;

    @ApiOperation(value = "Run algorithm of prime numbers", notes = "This api execute and save stats of prime numbers from a given range of start and end position")

    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Successfully called, returns the statistics of prime numbers")
        ,
			@ApiResponse(code = 500, message = "error occured")
    })
    @PostMapping(path = "/runalgo", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity saveStats(@Valid @RequestBody StatsModelDTO smdto) {

        return modelFacade.saveStats(smdto);
    }

    @ApiOperation(value = "Save and return user id based on the username", notes = "This api  saves user based on the username")

    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Successfully called, returns user info after saving or simply id if the user")
        ,
			@ApiResponse(code = 500, message = "error occured")
    })
    @PostMapping(path = "/saveandgetuser", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity saveAndGetUser(@Valid @RequestBody Users user) {

        return usersFacade.saveUser(user);
    }

    @ApiOperation(value = "find stats by user", notes = "find statitics by userid")

    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Successfully called, returns Statistics of Primenumbers generated")
        ,
			@ApiResponse(code = 500, message = "error occured")
    })
    @GetMapping(path = "/findstatsbyuserid/{userid}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity findStatsByUserId(@Valid @PathVariable("userid") Integer userid) {

        return modelFacade.findStatsByUserID(userid);
    }

    @ApiOperation(value = "find all user", notes = "find all primenumbers statitics ")

    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Successfully called, returns Statistics of Primenumbers generated")
        ,
			@ApiResponse(code = 500, message = "error occured")
    })
    @GetMapping(path = "/findallstatistics", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity findAllStatistics() {

        return modelFacade.findAllModelStatistics();
    }

}
