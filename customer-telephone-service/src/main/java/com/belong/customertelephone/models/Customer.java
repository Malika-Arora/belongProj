package com.belong.customertelephone.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "customer")
public class Customer {
 @Id
 @GeneratedValue(strategy = GenerationType.AUTO)
 private int customerId;
 private String firstName;
 private String lastName;
 private String email;
 
 @OneToMany(mappedBy = "customer", orphanRemoval = true, cascade = { CascadeType.ALL })
 private List<CustomerTelephone> phoneNumbers;
}
