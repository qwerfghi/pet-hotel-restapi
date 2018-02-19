package com.qwerfghi.hotel.service;

import com.google.common.collect.Lists;
import com.qwerfghi.hotel.entity.*;
import com.qwerfghi.hotel.repository.AddressRepository;
import com.qwerfghi.hotel.repository.AnimalRepository;
import com.qwerfghi.hotel.repository.OwnerRepository;
import com.qwerfghi.hotel.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AdminService {

    @Autowired
    private AnimalRepository animalRepository;

    @Autowired
    private OwnerRepository ownerRepository;

    @Autowired
    private StaffRepository staffRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Transactional(readOnly = true)
    public Owner getOwnerById(int id) {
        return ownerRepository.findOne(id);
    }

    public void addAnimal(Animal animal, int idOwner) {
        animal.setOwner(ownerRepository.findOne(idOwner));
        animalRepository.save(animal);
    }

    public void deleteAnimal(int id) {
        animalRepository.delete(id);
    }

    @Transactional(readOnly = true)
    public List<Animal> getAllAnimals() {
        return Lists.newArrayList(animalRepository.findAll());
    }

    @Transactional(readOnly = true)
    public List<Staff> getAllStaff() {
        return Lists.newArrayList(staffRepository.findAll());
    }

    public void addStaff(Staff staff) {
        staffRepository.save(staff);
    }

    public void deleteStaff(int id) {
        staffRepository.delete(id);
    }

    @Transactional(readOnly = true)
    public List<Owner> getAllOwners() {
        return Lists.newArrayList(ownerRepository.findAll());
    }

    public void changeDiscount(int id, Discount discount) {
        //ownerRepository.changeDiscount(id, discount);
    }

    public void addOwner(Owner owner, Address address) {
        addressRepository.save(address);
        owner.setAddress(address);
        ownerRepository.save(owner);
    }

    public void deleteOwner(int id) {
        ownerRepository.delete(id);
    }
}