package com.springbootacademy.pointofsale.repository;

import com.springbootacademy.pointofsale.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@EnableJpaRepositories
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    Optional<Customer> findByNic(String nic);

    List<Customer> findAllByActiveState(boolean status);
}
