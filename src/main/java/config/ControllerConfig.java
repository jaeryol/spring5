package config;

import Controller.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.AuthService;
import spring.ChangePasswordService;
import spring.MemberRegisterService;

@Configuration
public class ControllerConfig {

    @Autowired
    private MemberRegisterService memberRegisterService;

    @Autowired
    private AuthService authService;

    @Autowired
    private ChangePasswordService changePasswordService;

    @Bean
    public RegisterController registerController() {
        RegisterController controller = new RegisterController();
        controller.setMemberRegisterService(memberRegisterService);

        return controller;
    }

    @Bean
    public SurveyConroller surveyConroller() {
        return new SurveyConroller();
    }

    @Bean
    public LoginController loginController() {
        LoginController controller = new LoginController();
        controller.setAuthService(authService);

        return controller;
    }

    @Bean
    public LogoutController logoutController() {
        return new LogoutController();
    }

    @Bean
    public ChangePasswordController changePasswordController() {
        ChangePasswordController controller = new ChangePasswordController();
        controller.setService(changePasswordService);

        return controller;
    }
}
