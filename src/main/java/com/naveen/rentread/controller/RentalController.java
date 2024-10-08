package com.naveen.rentread.controller;

import com.naveen.rentread.domain.Rental;
import com.naveen.rentread.service.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rent")
public class RentalController {

    @Autowired
    private RentalService service;

    @PutMapping("/borrow/{bookId}")
    public ResponseEntity<Rental> borrowBook(@PathVariable(value = "bookId") Long bookId){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return ResponseEntity.ok(service.rentBook(authentication.getName(), bookId));
    }

    @PutMapping("/return/{rentalId}")
    public ResponseEntity<Void> returnBook(@PathVariable(value = "rentalId") Long rentalId){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        service.returnBook(authentication.getName(), rentalId);
        return ResponseEntity.ok().build();
    }

}
