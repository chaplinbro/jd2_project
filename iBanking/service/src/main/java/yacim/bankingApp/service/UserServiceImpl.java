package yacim.bankingApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import yacim.bankingApp.data.dao.UserDao;
import yacim.bankingApp.data.entity.User;
import yacim.bankingApp.data.model.RegistrationDto;
import yacim.bankingApp.data.model.UserRole;

import java.util.List;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    private UserDao userDao;

    @Override
    public void registration(RegistrationDto registrationDto) {
        User user = new User();
        user.setUsername(registrationDto.getUsername());
        user.setName(registrationDto.getName());
        user.setSurname(registrationDto.getSurname());
        user.setPassword(registrationDto.getPassword());
        user.setRole(UserRole.ROLE_USER.toString());
        userDao.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            User appUser = userDao.getByUsername(username);
            if (appUser == null) {
                throw new UsernameNotFoundException("User not found: " + username);
            }

            return new org.springframework.security.core.userdetails.User(
                    appUser.getUsername(),
                    appUser.getPassword(),
                    true, true, true, true,
                    List.of(new SimpleGrantedAuthority(appUser.getRole()))
            );

        } catch (Exception e) {
            throw new UsernameNotFoundException("User not found: " + username, e);
        }
    }
}