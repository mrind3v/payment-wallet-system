package com.example.pws.repository;

import com.example.pws.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List ;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, String > {

    @Override
    Optional<Transaction > findById(String s ) ;
    @Query("SELECT t FROM Transaction t WHERE t.userA = :s")
    Optional<List<Transaction > > findUserAById(@Param("s") String s) ;
}
