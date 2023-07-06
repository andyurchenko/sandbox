package it.sevenbits.sixthpractice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * The type Hello controller.
 */
@Controller
public class HelloController {
    private static final String TEMPLATE = "Hello, %s";

    /**
     * Hello world string.
     *
     * @param name the name
     * @return the string
     */
    @RequestMapping(value = "/hello", method = RequestMethod.GET, produces = "text/plain")
    @ResponseBody
    public String helloWorld(@RequestParam(value = "name", defaultValue = "World") final String name) {
        return String.format(TEMPLATE, name);
    }

}
