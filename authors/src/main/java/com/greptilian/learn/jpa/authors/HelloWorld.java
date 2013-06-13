package com.greptilian.learn.jpa.authors;

import javax.ejb.Stateless;

@Stateless
public class HelloWorld {

    public String hello(String message) {
        System.out.println("===========");
        System.out.println("message: " + message);
        System.out.println("===========");

        return "Echo: " + message;

    }
}
