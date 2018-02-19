package com.qwerfghi.hotel.service;

import com.google.common.collect.Lists;
import com.qwerfghi.hotel.entity.Animal;
import com.qwerfghi.hotel.entity.AnimalType;
import com.qwerfghi.hotel.entity.Room;
import com.qwerfghi.hotel.repository.AnimalRepository;
import com.qwerfghi.hotel.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class UserService {

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private AnimalRepository animalRepository;

    @Transactional(readOnly = true)
    public List<Room> getAllFreeRooms(AnimalType animalType) {
        //return roomRepository.getAllFreeRooms(animalType, null);
        return null;
    }

    @Transactional(readOnly = true)
    public List<Room> getAllRooms() {
        return Lists.newArrayList(roomRepository.findAll());
    }

    public void reserveRoom(int number, Date dateBeg, Date dateEnd, Animal animal) {
        Room room = roomRepository.getRoomByNumber(number);
        room.setDateBeg(dateBeg);
        room.setDateEnd(dateEnd);
        roomRepository.save(room);
        animalRepository.save(animal);
    }
}