package com.example.jpademo.repository.oracle2;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.jpademo.entity.oracle2.Table2;

@Repository
public interface Table2Repository extends JpaRepository<Table2, String> {
	List<Table2> findById(Long id);

}