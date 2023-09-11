package com.DrApp.Repository;

import com.DrApp.Model.Specialist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SpecialistRepository extends JpaRepository<Specialist,Integer> {
}
