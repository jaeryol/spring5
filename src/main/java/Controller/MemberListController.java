package Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import spring.MemberDao;

import spring.Member;
import java.util.List;

@Controller
public class MemberListController {

    private MemberDao memberDao;

    public void setMemberDao(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    @RequestMapping("/members")
    public String list (
        @ModelAttribute("cmd") ListCommand command,
        Errors errors,
        Model model) {

        if (errors.hasErrors()) {
            return "member/memberList";
        }

        if (command.getFrom() != null && command.getTo() != null) {
            List<Member> members = memberDao.selectByRegdate(
                command.getFrom(), command.getTo());
            model.addAttribute("members", members);
        }

        return "member/memberList";
    }
}
