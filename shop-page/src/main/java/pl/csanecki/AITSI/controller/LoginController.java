package pl.csanecki.AITSI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.csanecki.AITSI.entity.User;
import pl.csanecki.AITSI.service.UserService;

import javax.validation.Valid;

@Controller
public class LoginController {
    private UserService userService;

    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/registration")
    public String registration(Model model) {
        User user = new User();

        model.addAttribute("user", user);

        return "registration";
    }

    @PostMapping("registration")
    public String createNewUser(@Valid User user, BindingResult bindingResult, Model model) {
        User userExists = userService.findUserByEmail(user.getEmail());

        if(userExists != null) {
            bindingResult
                    .rejectValue("email", "error.user",
                            "Istnieje już w bazie użytkownik o takim emailu.");
        }

        if(bindingResult.hasErrors()) {
            return "registration";
        } else {
            userService.saveUser(user);

            model.addAttribute("successMessage", "Pomyślenie zarejestrowano użytkownika.");

            return "login";
        }
    }

    @GetMapping("/loginFailed")
    public String loginFail(Model model) {
        model.addAttribute("error", true);

        return "login";
    }

    @GetMapping("/logout")
    private String logout() {
        return "/welcome";
    }
}
