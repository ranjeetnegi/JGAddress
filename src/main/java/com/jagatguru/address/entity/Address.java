package com.jagatguru.address.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Getter
@Setter
@Entity
@Builder
@Table(name = "ADDRESS")
public class Address {

  @Id
  @GeneratedValue
  @Column(name = "ID")
  private Integer id;

  @Column(name = "NAME")
  private String name;

  @Column(name = "PHONE")
  private String phone;

  @Column(name = "PIN")
  private String pin;

  @Column(name = "STATE")
  private String state;

  @Column(name = "DISTRICT")
  private String district;

  @Column(name = "BLOCK")
  private String block;

  @Column(name = "BOOK")
  private String book;

  @Column(name = "ADDRESS")
  private String address;

  @Column(name = "RAW_ADDRESS")
  private String rawAddress;

  @Column(name = "ORDER_DATE")
  private Timestamp orderDate;
}
