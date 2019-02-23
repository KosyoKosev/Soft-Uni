package softuni.exam.web.beans;

import org.modelmapper.ModelMapper;
import softuni.exam.domain.models.binding.UserRegisterBindingModel;
import softuni.exam.domain.models.service.UserServiceModel;
import softuni.exam.service.UserService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named("registerBean")
@RequestScoped
public class RegisterBean extends BaseBean{

    private UserService userService;

    private ModelMapper modelMapper;

    private UserRegisterBindingModel userRegisterBindingModel;

    public RegisterBean() {
    }

    public RegisterBean(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @PostConstruct
    public void init(){
        this.userRegisterBindingModel = new UserRegisterBindingModel();
    }

    public UserRegisterBindingModel getUserRegisterBindingModel() {
        return userRegisterBindingModel;
    }

    public void setUserRegisterBindingModel(UserRegisterBindingModel userRegisterBindingModel) {
        this.userRegisterBindingModel = userRegisterBindingModel;
    }

    public void register(){
        if(!this.userRegisterBindingModel.getPassword()
                .equals(this.userRegisterBindingModel.getConfirmPassword())) {
            return;
        }

        this.userService.createUser(
                this.modelMapper.map(this.userRegisterBindingModel, UserServiceModel.class));
        this.redirect("/login");
    }
}
