package com.jagatguru.address.service;

import com.jagatguru.address.entity.Address;

import java.sql.Timestamp;
import java.util.List;

public interface AddressService {
  /**
   * Saving/Updating address
   *
   * @param newAddress
   * @return
   */
  Address updateAndSave(Address newAddress);

  /**
   * Search Address by Phone number
   *
   * @param param
   * @param resultSize
   * @param start
   * @param end
   * @return
   */
  List<Address> searchAddressByPhoneNumber(String param, Integer resultSize, Timestamp start,
      Timestamp end);
}
