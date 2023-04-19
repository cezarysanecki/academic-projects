package pl.csanecki.AITSI.service;

import pl.csanecki.AITSI.entity.User;

public interface UserService {
    User findUserByEmail(String email);
    User saveUser(User user);
}
