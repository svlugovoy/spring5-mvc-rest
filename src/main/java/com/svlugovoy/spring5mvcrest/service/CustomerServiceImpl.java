package com.svlugovoy.spring5mvcrest.service;

import com.svlugovoy.spring5mvcrest.api.v1.mapper.CustomerMapper;
import com.svlugovoy.spring5mvcrest.api.v1.model.CustomerDTO;
import com.svlugovoy.spring5mvcrest.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerMapper customerMapper;
    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerMapper customerMapper, CustomerRepository customerRepository) {
        this.customerMapper = customerMapper;
        this.customerRepository = customerRepository;
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        return customerRepository
                .findAll()
                .stream()
                .map(customer -> {
                   CustomerDTO customerDTO = customerMapper.customerToCustomerDTO(customer);
                   customerDTO.setCustomerUrl("/api/v1/customers/" + customer.getId());
                   return customerDTO;
                })
                .collect(Collectors.toList());
    }

    @Override
    public CustomerDTO getCustomerById(Long id) {

        return customerRepository
                .findById(id)
                .map(customerMapper::customerToCustomerDTO)
                .orElseThrow(RuntimeException::new); //todo implement better exception handling
    }
}
