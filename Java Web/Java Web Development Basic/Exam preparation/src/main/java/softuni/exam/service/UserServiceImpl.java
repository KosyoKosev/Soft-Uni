package softuni.exam.service;

import org.modelmapper.ModelMapper;
import softuni.exam.domain.entities.User;
import softuni.exam.domain.models.service.UserServiceModel;
import softuni.exam.repository.UserRepository;

import javax.inject.Inject;

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final ModelMapper modelMapper;

    @Inject
    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public UserServiceModel getUserByUsername(String username) {
        return this.modelMapper.map(this.userRepository.findByUsername(username), UserServiceModel.class);
    }

    @Override
    public UserServiceModel createUser(UserServiceModel userServiceModel) {
        return this.modelMapper.map(this.userRepository.save(this.modelMapper.map(userServiceModel, User.class)), UserServiceModel.class);
    }
}
