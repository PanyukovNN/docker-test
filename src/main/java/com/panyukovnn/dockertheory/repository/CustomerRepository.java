package com.panyukovnn.dockertheory.repository;

import com.panyukovnn.dockertheory.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
