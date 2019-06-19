package com.example.jpademo.repository.oracle2;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

@Repository
public class CallFuncRepository {

	@PersistenceContext
	EntityManager entityManager;


	public Integer plus1inout() {

	//	Author a = entityManager.createQuery("SELECT a FROM Author a WHERE a.id = function('plus1inout', 1)", Author.class).getSingleResult();

		List query = (List) entityManager.createQuery(":RET=call plus1inout(:PARAM)")
		.setParameter("PARAM", 1)
		.getSingleResult();

		 return 0;
	}

}
