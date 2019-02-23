package softuni.exam.service;

import softuni.exam.domain.models.service.UserServiceModel;

public interface UserService {

    UserServiceModel getUserByUsername(String username);

    UserServiceModel createUser(UserServiceModel userServiceModel);
}
