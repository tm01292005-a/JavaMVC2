package com.example.jpademo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jpademo.entity.postgres.Item;
import com.example.jpademo.repository.postgres.ItemRepository;
import com.example.jpademo.service.TestService3;

@Service
public class TestService3Impl implements TestService3 {
	@Autowired
//	@Qualifier("secondaryjdbc")
	private ItemRepository itemRepository;

	@Override
	public List<Item> getItem() {
		return itemRepository.findAll();
	}
}
