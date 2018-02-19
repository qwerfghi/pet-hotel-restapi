package com.qwerfghi.hotel.repository;

import com.qwerfghi.hotel.entity.Animal;
import org.springframework.data.repository.CrudRepository;

public interface AnimalRepository extends CrudRepository<Animal, Integer> {
}