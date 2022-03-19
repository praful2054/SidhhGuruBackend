package com.exam.examportal.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.exam.examportal.entities.exam.Category;

@Repository
public interface CategoryRepository extends MongoRepository<Category, Long>{

}
