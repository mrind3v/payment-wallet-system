package com.example.pws.repository;

import com.example.pws.model.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Optional;

@Repository
public interface WalletRepository extends JpaRepository<Wallet, String > {

    @Override
    Optional<Wallet> findById(String s) ;

    Optional<BigDecimal > findBalanceById(String s ) ;
}
