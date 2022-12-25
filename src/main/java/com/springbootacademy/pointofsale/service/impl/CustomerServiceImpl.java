package com.springbootacademy.pointofsale.service.impl;

import com.springbootacademy.pointofsale.dto.CustomerDTO;
import com.springbootacademy.pointofsale.dto.request.RequestUpdateCustomerDto;
import com.springbootacademy.pointofsale.entity.Customer;
import com.springbootacademy.pointofsale.repository.CustomerRepository;
import com.springbootacademy.pointofsale.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public String saveCustomer(CustomerDTO customerDTO) {
        Customer customer = new Customer(
                //customerDTO.getCustomerId(),
                customerDTO.getCustomerName(),
                customerDTO.getCustomerAddress(),
                customerDTO.getCustomerSalary(),
                customerDTO.getNic(),
                customerDTO.getContactNumber(),
                customerDTO.isActiveState()
        );
        if (!customerRepository.existsById(customer.getCustomerId())) {
            customerRepository.save(customer);
            return customer.getCustomerName() + " saved";
        } else {
            throw new DuplicateKeyException("Customer Already Exists");
        }


    }

    @Override
    public String updateCustomer(RequestUpdateCustomerDto customerDto) {
        if (customerRepository.existsById(customerDto.getCustomerId())) {
            Customer customer = customerRepository.getById(customerDto.getCustomerId());
            customer.setCustomerName(customerDto.getCustomerName());
            customer.setCustomerAddress(customerDto.getCustomerAddress());
            customer.setCustomerSalary(customerDto.getCustomerSalary());
            customerRepository.save(customer);
            return "Saved " + customer.getCustomerId() + " " + customer.getCustomerName();
        } else {
            throw new RuntimeException("Customer is not in database");
        }

    }

    @Override
    public CustomerDTO getCustomerById(int customerId) {
//        Customer customer = customerRepository.getById(customerId);
//        if(customer!=null){
//            CustomerDTO customerDTO = new CustomerDTO(
//                    customer.getCustomerId(),
//                    customer.getCustomerName(),
//                    customer.getCustomerAddress(),
//                    customer.getCustomerSalary(),
//                    customer.getNic(),
//                    customer.getContactNumber(),
//                    customer.isActiveState()
//            );
//            return customerDTO;
//        }
//        else{
//            throw new RuntimeException("No customer found for id: "+customerId);
//        }
//
//    }

        Optional<Customer> customer = customerRepository.findById(customerId);
        if (customer.isPresent()) {
            CustomerDTO customerDTO = new CustomerDTO(
                    customer.get().getCustomerId(),
                    customer.get().getCustomerName(),
                    customer.get().getCustomerAddress(),
                    customer.get().getCustomerSalary(),
                    customer.get().getNic(),
                    customer.get().getContactNumber(),
                    customer.get().isActiveState()
            );
            return customerDTO;
        } else {
            throw new RuntimeException("Not Found");
        }
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        List<Customer> getCustomer = customerRepository.findAll();
        List<CustomerDTO> customerDTOList = new ArrayList<>();
        for(Customer customer : getCustomer){
            CustomerDTO customerDTO = new CustomerDTO(
                    customer.getCustomerId(),
                    customer.getCustomerName(),
                    customer.getCustomerAddress(),
                    customer.getCustomerSalary(),
                    customer.getNic(),
                    customer.getContactNumber(),
                    customer.isActiveState()
            );
            customerDTOList.add(customerDTO);
        }
        return customerDTOList;
    }

    @Override
    public String deleteCustomer(int customerId) {
        if(customerRepository.existsById(customerId)){
            customerRepository.deleteById(customerId);
            return "Customer "+customerId+" deleted";
        }else{
            return "No customer deleted";
        }
    }

    @Override
    public CustomerDTO getCustomerByNic(String nic) {
        Optional<Customer> customer = customerRepository.findByNic(nic);
        if (customer.isPresent()) {
            CustomerDTO customerDTO = new CustomerDTO(
                    customer.get().getCustomerId(),
                    customer.get().getCustomerName(),
                    customer.get().getCustomerAddress(),
                    customer.get().getCustomerSalary(),
                    customer.get().getNic(),
                    customer.get().getContactNumber(),
                    customer.get().isActiveState()
            );
            return customerDTO;
        } else {
            throw new RuntimeException("Not Found");
        }

    }

    @Override
    public List<CustomerDTO> getAllCustomersByState(boolean status) {
        List<Customer> getCustomer = customerRepository.findAllByActiveState(status);
        List<CustomerDTO> customerDTOList = new ArrayList<>();
        for(Customer customer : getCustomer){
            CustomerDTO customerDTO = new CustomerDTO(
                    customer.getCustomerId(),
                    customer.getCustomerName(),
                    customer.getCustomerAddress(),
                    customer.getCustomerSalary(),
                    customer.getNic(),
                    customer.getContactNumber(),
                    customer.isActiveState()
            );
            customerDTOList.add(customerDTO);
        }
        return customerDTOList;
    }
}
