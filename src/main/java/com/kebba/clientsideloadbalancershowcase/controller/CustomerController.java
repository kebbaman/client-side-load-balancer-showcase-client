package com.kebba.clientsideloadbalancershowcase.controller;

import com.kebba.clientsideloadbalancershowcase.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/get-served")
    public ResponseEntity<String> getServed(){
        return ResponseEntity.ok(customerService.getServed());
    }
}
