package com.example.spring.mongodb;

import static org.junit.Assert.*;

import org.junit.Test;

import com.mmnaseri.utils.spring.data.dsl.factory.RepositoryFactoryBuilder;


public class CustomerRepositoryTest {

	@Test
	public void testItWorks() {
		CustomerRepository repository = RepositoryFactoryBuilder.builder().mock(CustomerRepository.class);
		
		repository.deleteAll();

		// save a couple of customers
		repository.save(new Customer("Alice", "Smith"));
		repository.save(new Customer("Bob", "Smith"));

		// fetch all customers
		System.out.println("Customers found with findAll():");
		System.out.println("-------------------------------");
		for (Customer customer : repository.findAll()) {
			System.out.println(customer);
		}
		System.out.println();

		// fetch an individual customer
		System.out.println("Customer found with findByFirstName('Alice'):");
		System.out.println("--------------------------------");
		System.out.println(repository.findByFirstName("Alice"));

		System.out.println("Customers found with findByLastName('Smith'):");
		System.out.println("--------------------------------");
		for (Customer customer : repository.findByLastName("Smith")) {
			System.out.println(customer);
		}
		
	}
}
