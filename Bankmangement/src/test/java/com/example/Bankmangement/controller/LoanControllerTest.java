package com.example.Bankmangement.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.Bankmangement.repository.LoanRepository;
import com.example.Bankmangement.service.impl.LoanServiceImpl;




@SpringBootTest
class LoanControllerTest {

	
	
	@Autowired
	private LoanServiceImpl service;
	
	
	@MockBean
	private LoanRepository repository;
	
	
	public void LoanServiceTest() {
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	@Test
//	void test() {
//		fail("Not yet implemented");
//	}

}
