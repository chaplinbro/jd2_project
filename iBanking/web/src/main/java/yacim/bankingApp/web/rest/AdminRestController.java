package yacim.bankingApp.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import yacim.bankingApp.data.dao.UserDao;
import yacim.bankingApp.data.entity.User;
import yacim.bankingApp.data.model.UserForAdminDto;

import java.util.ArrayList;
import java.util.List;

@Secured("ROLE_ADMIN")
@RestController
public class AdminRestController {

    @Autowired
    private UserDao userDao;

//    @GetMapping("/users")
//    public ResponseEntity<List<User>> getUsers() {
//        List<User> users = userDao.getAllUsers();
//        if (users.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        return new ResponseEntity<>(users, HttpStatus.OK);
//    }


    @GetMapping("/users")
    public ResponseEntity<List<UserForAdminDto>> getUsers() {

        List<UserForAdminDto> userDto = new ArrayList<>();
        List<User> users = userDao.getAllUsers();

        for (User user : users) {
            UserForAdminDto userForAdminDto = new UserForAdminDto();
            userForAdminDto.setId(user.getId());
            userForAdminDto.setUsername(user.getUsername());
            userForAdminDto.setName(user.getName());
            userForAdminDto.setSurname(user.getSurname());
            userDto.add(userForAdminDto);
        }
        if (userDto.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

}
