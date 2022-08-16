package com.example.demo.services;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * AspectLogger
 *
 * Handles the generic logging of every single method from every single class.
 *
 * @author Tyler Kukkola
 */
@Aspect
@Component
public class AspectLogger {

    /***************************************************
     * Handles logging of OMDBController methods
     */
    @Before("execution(* com.example.demo.controllers.OMDBController.search*(..))")
    public void beforeOMDBController(JoinPoint p) {
        Signature sig = p.getSignature();
        System.out.println("Entered " + sig.getName());
    }

    @After("execution(* com.example.demo.controllers.OMDBController.search*(..))")
    public void afterOMDBController(JoinPoint p) {
        Signature sig = p.getSignature();
        System.out.println("Left " + sig.getName());
    }

    // more logging coverage would go here
}
