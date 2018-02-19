package com.qwerfghi.hotel.repository;

import com.qwerfghi.hotel.entity.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Integer> {
    //void changeDiscount(int id, Discount discount);
}