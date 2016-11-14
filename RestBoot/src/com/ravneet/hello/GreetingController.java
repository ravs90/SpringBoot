package com.ravneet.hello;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class GreetingController {

	private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }
    
    @RequestMapping("/testfunction")
    public String myFunctionTest(@RequestParam(value="param1") String kuchbhi){
    	return new String("How are you dear "+ kuchbhi+ "?");
    }
    
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String myFunctionTestPost(@RequestBody Greeting input){
    	return new String("How are you dear "+input.getContent()+". Good to see you back");
    }
}
