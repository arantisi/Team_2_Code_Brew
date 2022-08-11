package com.example.demo.services;

import com.example.demo.repositories.MyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyService {

    private MyRepo myRepo;

    @Autowired
    public MyService(MyRepo myRepo) {
        this.myRepo = myRepo;
        System.out.println("Creating an instance of MyService");
    }

    public void makeTheRepoDoSomething() {
        System.out.println("Making the repo do something");
        myRepo.doSomething();
    }
}
