package com.example.pws.service;

import com.example.pws.exception.ResourceNotFoundException;
import com.example.pws.dto.CreateUserRequest;
import com.example.pws.dto.UpdateEmailRequest;
import com.example.pws.model.User;
import com.example.pws.model.Wallet;
import com.example.pws.repository.UserRepository;
/* import com.example.pws.repository.WalletRepository ; */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository ;

    @Autowired
    private WalletService walletService ;

    public User createUser(CreateUserRequest usr )
    {
        User user= new User() ;
        user.setName(usr.getName() ) ;
        user.setEmail(usr.getEmail() ) ;
        user.setPassword(usr.getPassword() ) ;
        Wallet wallet= walletService.createWallet(usr.getBalance() ) ;
        user.setWalletId(wallet.getId() ) ;
        user.setStatus("HERE" ) ;
        userRepository.save(user ) ;
        return user ;
    }

    @Cacheable(value= "users", key= "#id" )
    public User getUserById(String id ) throws ResourceNotFoundException
    {
        User user= userRepository.findById(id ).orElse(null) ;
        if (user==null) throw new ResourceNotFoundException("User not found");
        return user ;
    }

    @CachePut(value= "users", key= "#id" )
    public User updateEmailById(String id, UpdateEmailRequest request ) throws ResourceNotFoundException
    {
        User user= getUserById(id ) ;
        if(user== null ) {
            throw new ResourceNotFoundException("User not found");
        }
        user.setEmail(request.getEmail() ) ;
        System.out.println("=====================================================================");
        System.out.println(request.getEmail());
        System.out.println("======================================================================");
        userRepository.save(user ) ;
        return user ;
    }

    @CacheEvict(value= "users", key= "#id" )
    public String deleteUserById(String id ) throws ResourceNotFoundException
    {
        User user= getUserById(id ) ;
        if(user== null ) {
            throw new ResourceNotFoundException("User not found");
        }
        String walletId= user.getWalletId() ;
        userRepository.delete(user );
        walletService.deleteWalletById(walletId ) ;
        String message= "User does not exist anymore!" ;
        return message ;
    }

    public boolean validateWalletId(String userId, String walletId ) throws ResourceNotFoundException
    {
        User user= getUserById(userId );
        if((user.getWalletId() ).equals(walletId ) ) {
            return true;
        }
        else {
            throw new ResourceNotFoundException("Unauthorized Access To Wallet" ) ;
        }
    }
}
