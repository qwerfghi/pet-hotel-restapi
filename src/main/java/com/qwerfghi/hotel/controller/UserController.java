package com.qwerfghi.hotel.controller;

import com.qwerfghi.hotel.entity.Room;
import com.qwerfghi.hotel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/rooms")
    public List<Room> getAllRooms() {
        return userService.getAllRooms();
    }

}