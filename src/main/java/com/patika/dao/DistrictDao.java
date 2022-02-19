package com.patika.dao;

import com.patika.model.District;
import com.patika.model.Neighborhood;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DistrictDao extends JpaRepository<District, Long> {
    @Query("select n from Neighborhood n inner join n.district d where d.id = ?1")
    List<Neighborhood> getNeighborhoodsById(Long id);
}
