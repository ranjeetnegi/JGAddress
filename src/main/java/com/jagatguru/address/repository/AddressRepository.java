package com.jagatguru.address.repository;

import com.jagatguru.address.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository("com.jagatguru.address.repository.AddressRepository")
public interface AddressRepository extends JpaRepository<Address,Integer> {

  @Query("Select a FROM Address a WHERE (a.phone like (%:searchParam%) or a.phone like (%,"
      + ":searchParam%)) AND (:startTime is NULL or a.orderDate >= :startTime) AND (:endTime "
      + "is NULL or a.orderDate <= :endTime) ORDER BY a.phone ASC")
  List<Address> searchAddressByPhoneNumber(@Param("searchParam") String searchParam,
      @Param("resultSize") int resultSize, @Param("startTime") Timestamp start,
      @Param("endTime") Timestamp end);
}
