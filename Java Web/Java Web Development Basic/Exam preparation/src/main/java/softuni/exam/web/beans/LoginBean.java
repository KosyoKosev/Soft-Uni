package softuni.exam.web.beans;

import softuni.exam.domain.models.binding.UserLoginBindingModel;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.IOException;

@Named("loginBean")
@RequestScoped
public class LoginBean extends BaseBean{

    private UserLoginBindingModel userLoginBindingModel;

    public LoginBean() {
    }

    @PostConstruct
    public void init(){
        this.userLoginBindingModel = new UserLoginBindingModel();
    }

    public UserLoginBindingModel getUserLoginBindingModel() {
        return userLoginBindingModel;
    }

    public void setUserLoginBindingModel(UserLoginBindingModel userLoginBindingModel) {
        this.userLoginBindingModel = userLoginBindingModel;
    }

    public void login() {
        this.redirect("/index");
    }
}
