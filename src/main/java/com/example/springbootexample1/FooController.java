package com.example.springbootexample1;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FooController implements ErrorController {

    @RequestMapping("/")
    public String foo() {
        return "This is foo";
    }

    @RequestMapping("/person")
    public Person getPerson() {
        return new Person("name1", 32);
    }

    @RequestMapping("/number")
    public int bar(){
        return 3;
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }

    @RequestMapping("/error")
    public String handleError() {
        return "Relax, take it ease";
    }
}
