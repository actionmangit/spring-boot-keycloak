package com.actionman.keycloak.dao;

import com.actionman.keycloak.model.Customer;

import org.springframework.data.repository.CrudRepository;

public interface CustomerDAO extends CrudRepository<Customer, Long> {

}
