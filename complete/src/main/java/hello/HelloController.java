package hello;

import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import org.apache.log4j.Logger;

@RestController
public class HelloController {
	
	private static final Logger LOGGER = Logger.getLogger(HelloController.class);

	//No Swagger here!
    @RequestMapping("/hello")
    
    public String index() {
        return "Greetings from Spring Boot!";
    }
    

    @ApiOperation(notes = "say hello", value = "say hello", nickname = "sayHello", tags = {"Hello"} )
    @ApiResponses({
    	@ApiResponse(code = 200, message = "Nice!", response = HelloResponse.class),
    	@ApiResponse(code = 400, message = "Invalid input", response = HelloResponse.class),
    	@ApiResponse(code = 404, message = "Not found", response = HelloResponse.class)
    })
	@RequestMapping(value = "/hello/sayhello/{theName}", method = RequestMethod.GET, produces = "application/json")
    
    public @ResponseBody HelloResponse SayHello(@ApiParam(value = "Name of the person to be greeted", required = true) @PathVariable("theName") String theName) {
    	
    	LOGGER.info("sayHello invocation");
    	return new HelloResponse("Hello "+ theName);	
    	
    }
    
}
