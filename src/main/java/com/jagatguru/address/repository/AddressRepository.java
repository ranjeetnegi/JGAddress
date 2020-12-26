package com.jagatguru.address.repository;

import com.jagatguru.address.entity.Address;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository("com.jagatguru.address.repository.AddressRepository")
public interface AddressRepository extends JpaRepository<Address,Integer> {

  @Query(
      "SELECT a FROM Address as a WHERE ((a.phone like CONCAT(:searchParam,'%')) OR (a.phone like"
          + " CONCAT('%,',:searchParam,'%'))) AND (:start is null or a.orderDate > :start) AND "
          + "(:end is null or a.orderDate > :end) ORDER BY a.phone ASC")
  List<Address> searchByPhoneLike(@Param("searchParam") String searchParam,
      @Param("start") Timestamp start, @Param("end") Timestamp end, Pageable pageable);
}
