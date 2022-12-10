package com.springbootacademy.pointofsale.service;

import com.springbootacademy.pointofsale.dto.CustomerDTO;
import com.springbootacademy.pointofsale.dto.request.RequestUpdateCustomerDto;

import java.util.List;

public interface CustomerService {
    public String saveCustomer(CustomerDTO customerDTO);

    String updateCustomer(RequestUpdateCustomerDto customerDto);

    CustomerDTO getCustomerById(int customerId);

    List<CustomerDTO> getAllCustomers();

    String deleteCustomer(int customerId);
}
