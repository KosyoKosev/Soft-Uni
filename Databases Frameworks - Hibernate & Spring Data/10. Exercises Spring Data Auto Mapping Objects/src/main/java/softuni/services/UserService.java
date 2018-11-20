package softuni.services;

import softuni.models.binModels.user.RegisterUser;

public interface UserService {
    void persist(RegisterUser registerUser);
}
