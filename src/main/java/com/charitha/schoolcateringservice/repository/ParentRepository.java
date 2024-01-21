package com.charitha.schoolcateringservice.repository;

import com.charitha.schoolcateringservice.model.Guardian;
import org.springframework.data.repository.CrudRepository;

public interface ParentRepository extends CrudRepository<Guardian, Integer> {
}
