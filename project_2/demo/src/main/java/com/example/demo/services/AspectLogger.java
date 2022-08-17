package com.example.demo.services;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

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
    private static Logger logger = LogManager.getLogger(AspectLogger.class.getName());

    /***************************************************
     * Handles logging of OMDBController methods
     */
    @Before("execution(* com.example.demo.controllers.OMDBController.search*(..))")
    public void beforeOMDBController(JoinPoint p) {
        Signature sig = p.getSignature();
        logger.info("Entered " + sig.getName() + " " + Arrays.toString(p.getArgs()));
    }

    @After("execution(* com.example.demo.controllers.OMDBController.search*(..))")
    public void afterOMDBController(JoinPoint p) {
        Signature sig = p.getSignature();
        logger.info("Returned from " + sig.getName());
    }

    // more logging coverage would go here
}
