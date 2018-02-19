package com.qwerfghi.hotel.controller;

import com.qwerfghi.hotel.entity.Animal;
import com.qwerfghi.hotel.entity.Owner;
import com.qwerfghi.hotel.entity.Staff;
import com.qwerfghi.hotel.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/animals")
    public List<Animal> getAllAnimals() {
        return adminService.getAllAnimals();
    }

    @GetMapping("/owners")
    public List<Owner> getAllOwners() {
        return adminService.getAllOwners();
    }

    @GetMapping("/staff")
    public List<Staff> getAllStaff() {
        return adminService.getAllStaff();
    }

}