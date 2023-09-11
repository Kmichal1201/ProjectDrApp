package com.DrApp.Repository;

import com.DrApp.Model.AvailableDate;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AvailableDateRepository extends JpaRepository<AvailableDate, Integer> {

}
