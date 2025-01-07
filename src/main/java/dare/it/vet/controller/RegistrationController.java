package dare.it.vet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import dare.it.vet.repository.UserRepo;

@Controller
public class RegistrationController {

    @Autowired
    private UserRepo userRepo;

}
