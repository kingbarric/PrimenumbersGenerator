# PrimenumbersGenerator

Part 1 - Prime Number Generator

Please provide us with a concise, efficient and robust prime number generator written in Java that gives all prime numbers in the range between two numbers provided by the user (e.g. user gives 1 and 10 and you return "2, 3, 5, 7"). 

You should offer the user at least 3 different prime number generation strategies with different performance optimizations. Please include some simple but slow strategy and some others that increase performance at the expense of increased complexity. Consider also the use of multiple cores: if there is a gain, you could offer also a parallel implementation. Think also about memory usage (besides execution time).

You are allowed to take ideas from Internet or somewhere else, but not code. You should do the implementation yourself and from scratch. That said, using your own algorithms would be a nice extra.

Include some unit tests to validate the correctness of the program.

Make your program is usable via the command-line, allowing the user to select the generation strategy.

Part 2 - Prime Number Generator Server

Using the code from part 1 as the generation engine, write a server application (also in Java giving the user the chance to use your prime number generator over a REST API over HTTP (API frameworks/libraries are allowed and encouraged) . 

For all users, record each execution in a database, including timestamp, range, time elapsed, algorithm chosen and number of primes returned. 

For simplicity of implementation, you can use an in-memory database, like (for example) HSQLDB.




SOLUTION:

First part of assignment is in demo.primenumbers.primenumbersgen.facadeimplementation  package. The file called PrimeNumberCMDRunner takes input from command line to perform the operation.

Second solution: run the app as a jar file.
To perform an algorithm, a user id has to be obtained. By performing this call
/api/saveandgetuser
Save and return user id based on the username
With this values {“username” : “king”}.

This will create a new user with the username and return id, or simply return the user if the username exist.

Then /api/runalgo
Run algorithm of prime numbers
{
algorithm": "string",
      "endPosition": 0, 
      "startPosition": 0,
}

This will return elapsed time, username, algorithm,range.

The API Doc can be located at http://localhost:8080/swagger-ui.html


