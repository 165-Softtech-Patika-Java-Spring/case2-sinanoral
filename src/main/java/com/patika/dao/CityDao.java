package com.patika.dao;

import com.patika.model.City;
import com.patika.model.District;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityDao extends JpaRepository<City, Long> {
    City getByPlateNo(String plateNo);

    @Query("select d from District d inner join d.city c where c.id = ?1")
    List<District> getDistrictsById(Long id);
}
