package com.example.jpademo.repository.oracle2;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.jpademo.entity.oracle2.Table2;

@Repository
public interface Table2Repository extends JpaRepository<Table2, String> {
	List<Table2> findById(Long id);

//	@Transactional
//	@Procedure(procedureName = "plus1inout")
//	Integer plus1inout(@Param("arg") Integer arg);

//	@Query(nativeQuery = true, value = "SELECT plus1inout(:arg, :res) FROM dual")
//    Integer plus1inout(@Param("arg") Integer arg, @Param("arg") Integer res);
}