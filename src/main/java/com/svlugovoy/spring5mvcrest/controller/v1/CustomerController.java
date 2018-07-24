package com.svlugovoy.spring5mvcrest.controller.v1;

import com.svlugovoy.spring5mvcrest.api.v1.model.CustomerDTO;
import com.svlugovoy.spring5mvcrest.api.v1.model.CustomerListDTO;
import com.svlugovoy.spring5mvcrest.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping(path = {"", "/"})
    public ResponseEntity<CustomerListDTO> getListOfCustomers(){

        return new ResponseEntity<CustomerListDTO>(new CustomerListDTO(customerService.getAllCustomers()),
                HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable Long id){
        return new ResponseEntity<CustomerDTO>(customerService.getCustomerById(id), HttpStatus.OK);
    }

}
