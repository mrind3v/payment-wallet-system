package com.example.pws.repository;

import com.example.pws.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List ;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, String > {

    @Override
    Optional<Transaction > findById(String s ) ;

    Optional<List<Transaction > > findUserAById(String s ) ;
}
