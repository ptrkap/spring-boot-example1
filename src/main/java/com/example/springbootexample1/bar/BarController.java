package com.example.springbootexample1.bar;

import com.example.springbootexample1.Person;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bar")
public class BarController implements ErrorController {

    @RequestMapping("")
    public String foo() {
        return "This is bar";
    }

    @RequestMapping("/person")
    public Person getPerson() {
        return new Person("name2", 32);
    }

    @RequestMapping("/number")
    public int bar(){
        return 4;
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }

    @RequestMapping("/error")
    public String handleError() {
        return "Relax, take it ease - bar";
    }
}
