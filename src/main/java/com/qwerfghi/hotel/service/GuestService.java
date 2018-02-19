package com.qwerfghi.hotel.service;

import com.qwerfghi.hotel.entity.*;
import com.qwerfghi.hotel.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class GuestService {

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private OwnerRepository ownerRepository;

    @Autowired
    private PrivilegeRepository privilegeRepository;

    @Autowired
    private AnimalRepository animalRepository;

    @Autowired
    private RecallRepository recallRepository;

    @Transactional(readOnly = true)
    public User getByUsernameAndPassword(String username, String password) {
        return userRepository.getByUsernameAndPassword(username, password);
    }

    @Transactional(readOnly = true)
    public List<Room> getAllFreeRooms(AnimalType type, Date checkInDate) {
        //return roomRepository.getAllFreeRooms(type, checkInDate);
        return null;
    }

    public void addUser(User user, Owner owner, Address address) {
        addressRepository.save(address);
        owner.setDiscount(Discount.ZERO);
        owner.setAddress(address);
        ownerRepository.save(owner);
        //user.setPrivilegeEntity(privilegeRepository.getUserPrivilege());
        user.setOwner(owner);
        userRepository.save(user);
    }

    public void addAnimal(Animal animal) {
        animalRepository.save(animal);
    }

    public void addRecall(Recall entity) {
        recallRepository.save(entity);
    }
}