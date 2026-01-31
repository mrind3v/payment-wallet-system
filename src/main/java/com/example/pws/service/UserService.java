package com.example.pws.service;

import com.example.pws.dto.CreateUserRequest;
import com.example.pws.dto.UpdateEmailRequest;
import com.example.pws.model.User;
import com.example.pws.model.Wallet;
import com.example.pws.repository.UserRepository;
/* import com.example.pws.repository.WalletRepository ; */
import org.springframework.beans.factory.annotation.Autowired;
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

    public User getUserById(String id )
    {
        User user= userRepository.findById(id ).orElse(null ) ;
        return user ;
    }

    public User updateEmailById(String id, UpdateEmailRequest request )
    {
        User user= getUserById(id ) ;
        if(user== null ) {
            return null;
        }
        user.setEmail(request.getMessage() ) ;
        userRepository.save(user ) ;
        return user ;
    }

    public String deleteUserById(String id )
    {
        User user= getUserById(id ) ;
        if(user== null ) {
            return null;
        }
        String walletId= user.getWalletId() ;
        userRepository.delete(user );
        walletService.deleteWalletById(walletId ) ;
        String message= "User does not exist anymore!" ;
        return message ;
    }
}
