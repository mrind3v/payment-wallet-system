package com.example.pws.repository;

import com.example.pws.model.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Optional;

@Repository
public interface WalletRepository extends JpaRepository<Wallet, String > {

    @Override
    Optional<Wallet> findById(String s) ;

    @Query("SELECT w.balance FROM Wallet w WHERE w.id = :id")
    Optional<BigDecimal> findBalanceById(@Param("id") String id);
}
