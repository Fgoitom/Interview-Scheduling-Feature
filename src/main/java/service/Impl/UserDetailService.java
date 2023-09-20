package service.Impl;



import model.User;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import repository.UserRepo;

@Service
public class UserDetailService  {

    private UserRepo userRepo;

    public UserDetailService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }


    public User loadUserByUsername(String username) throws UsernameNotFoundException {
       var user1 = userRepo.findByUser(username);

        return user1;
    }
}
