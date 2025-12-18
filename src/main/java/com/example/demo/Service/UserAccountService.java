UserAccountService.java

package com.example.demo.Service;

import java.util.List;
import com.example.demo.entity.UserAccount;

public interface UserAccountService {

    UserAccount register(UserAccount user);

    UserAccount getUser(Long id);

    List<UserAccount> getAllUsers();

    UserAccount findByEmail(String email);
}