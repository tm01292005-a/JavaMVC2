package com.example.jpademo.repository.oracle1;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.jpademo.entity.oracle1.Table1;

@Repository
public interface Table1Repository extends JpaRepository<Table1, String> {
	List<Table1> findById(Long id);

	List<Table1> findByColumn1(String column1);
}