package softuni.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import softuni.users.entity.User;
import softuni.users.services.UserService;

@Component
public class Terminal implements CommandLineRunner {

    private final UserService userService;

    @Autowired
    public Terminal(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void run(String... strings) throws Exception {
        User user = new User();
        user.setUsername("Gosho");
        user.setPassword("paS123?");
        user.setEmail("pesho@pesho.com");
        userService.persist(user);
    }
}
