package com.svlugovoy.spring5mvcrest.repository;

import com.svlugovoy.spring5mvcrest.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {


}
