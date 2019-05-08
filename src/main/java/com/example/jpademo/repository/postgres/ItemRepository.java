package com.example.jpademo.repository.postgres;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.jpademo.entity.postgres.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, String> {
	List<Item> findById(Long id);

}
