package com.selenium.vys;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.MalformedURLException;

@RestController
@RequestMapping("/api")
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class SeleniumApi {

    @GetMapping(value = "/vys")
    public String vysLoginTest() throws MalformedURLException, InterruptedException {
        System.out.println("Test vys..");

        SeleniumVys vys = new SeleniumVys("grid-chrome");
        vys.vysLoginTest();
        vys.logout();
        return "Login Test Success!";
    }

    @GetMapping(value = "/sinav")
    public String sinavLoginTest() throws MalformedURLException, InterruptedException {
        System.out.println("Test sinav..");

        SeleniumVys vys = new SeleniumVys("grid-chrome");
        vys.sinavLoginTest();
        vys.logout();
        return "Login Test Success!";
    }
}
