package com.cydeo.repository;

import com.cydeo.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    //Write a derived query to get category by name

    //Write a derived query to get top 3 categories order by name desc
}
