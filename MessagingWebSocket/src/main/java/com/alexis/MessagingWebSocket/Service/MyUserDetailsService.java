package com.alexis.MessagingWebSocket.Service;

import com.alexis.MessagingWebSocket.Models.MyUserDetails;
import com.alexis.MessagingWebSocket.Models.User;
import com.alexis.MessagingWebSocket.Repositories.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service @AllArgsConstructor
public class MyUserDetailsService implements UserDetailsService {

    private final static String USER_NO_FOUND_MESSAGE=
            "user with %s not found";
    private final UserRepo userRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.getUserByUsername(username);
        if(user==null){
            throw new UsernameNotFoundException(String.format(USER_NO_FOUND_MESSAGE, username ));
        }
        System.out.println(user);
        return new MyUserDetails(user);
    }
}
