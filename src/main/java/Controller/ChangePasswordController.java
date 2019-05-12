package Controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import spring.AuthInfo;
import spring.ChangePasswordService;
import spring.WrongIdPasswordException;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/edit/changePassword")
public class ChangePasswordController {

    private ChangePasswordService service;

    public void setService(ChangePasswordService service) {
        this.service = service;
    }

    @GetMapping
    public String form(
        @ModelAttribute("command") ChangePasswordCommand command) {
        return "edit/changePasswordForm";
    }

    @PostMapping
    public String submit(
        @ModelAttribute("command") ChangePasswordCommand command,
        Errors errors,
        HttpSession session) {
        new ChangePasswordCommandValidator().validate(command, errors);

        if (errors.hasErrors()) {
            return "edit/changePasswordForm";
        }

        AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");
        try {
            service.changePassword(
                authInfo.getEmail(),
                command.getCurrentPassword(),
                command.getNewPassword());

            return "edit/changedPassword";
        } catch (WrongIdPasswordException e) {
            errors.rejectValue("currentPassword", "notMatching");

            return "edit/changePasswordForm";
        }
    }
}
