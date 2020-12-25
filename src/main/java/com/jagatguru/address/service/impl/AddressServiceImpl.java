package com.jagatguru.address.service.impl;

import com.jagatguru.address.entity.Address;
import com.jagatguru.address.repository.AddressRepository;
import com.jagatguru.address.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

@Service("com.jagatguru.address.service.impl.AddressServiceImpl")
public class AddressServiceImpl implements AddressService {

  @Autowired
  @Qualifier("com.jagatguru.address.repository.AddressRepository")
  private AddressRepository addressRepository;


  @Override
  @Transactional
  public Address updateAndSave(Address newAddress) {
    return addressRepository.save(newAddress);
  }

  @Override
  public List<Address> searchAddressByPhoneNumber(String searchParam, int resultSize,
      Timestamp start, Timestamp end) {
    return addressRepository.searchAddressByPhoneNumber(searchParam, resultSize, start, end);
  }
}