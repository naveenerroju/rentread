package com.naveen.rentread.controller;

import com.naveen.rentread.domain.Book;
import com.naveen.rentread.model.BookCreationRequest;
import com.naveen.rentread.service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/manage/book")
@Validated
public class ManageBooksController {

    @Autowired
    BookService service;

    @PostMapping()
    public ResponseEntity<Book> createBook(@Valid @RequestBody BookCreationRequest creationRequest){
        return ResponseEntity.ok(service.createBook(creationRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable(value = "id") Long id){
        service.deleteBook(id);
        return ResponseEntity.noContent().build();
    }

}
