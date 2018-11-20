package softuni.serviceImpls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.entities.User;
import softuni.entities.enums.Role;
import softuni.util.ModelParser;
import softuni.models.binModels.user.RegisterUser;
import softuni.repositories.UserRepository;
import softuni.services.UserService;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void persist(RegisterUser registerUser) {

        User user = ModelParser.getInstance().map(registerUser, User.class);

        if (this.userRepository.findAll().size() > 0){
            user.setRole(Role.USER);
        }else {
            user.setRole(Role.ADMIN);
        }
        this.userRepository.saveAndFlush(user);
    }
}
