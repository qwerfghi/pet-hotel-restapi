package com.qwerfghi.hotel.repository;

import com.qwerfghi.hotel.entity.Room;
import org.springframework.data.repository.CrudRepository;

public interface RoomRepository extends CrudRepository<Room, Integer> {
    //List<Room> getAllFreeRooms(AnimalType animalType, Date checkInDate);
    Room getRoomByNumber(int number);
}