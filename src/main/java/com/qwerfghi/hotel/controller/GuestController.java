package com.qwerfghi.hotel.controller;

import com.qwerfghi.hotel.entity.Animal;
import com.qwerfghi.hotel.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/guest")
public class GuestController {

    @Autowired
    private GuestService guestService;

    @PostMapping("/animals")
    public void addAnimal(Animal animal) {
        guestService.addAnimal(animal);
    }

}