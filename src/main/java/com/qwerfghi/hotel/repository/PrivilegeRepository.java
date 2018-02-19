package com.qwerfghi.hotel.repository;

import com.qwerfghi.hotel.entity.Privileges;
import org.springframework.data.repository.CrudRepository;

public interface PrivilegeRepository extends CrudRepository<Privileges, Integer> {
    //Privileges getUserPrivilege();
}