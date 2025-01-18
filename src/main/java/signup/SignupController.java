package signup;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SignupController {
	
	private SendUserData sendUserData;
	
	@PostMapping("/signup")
	public String registerUser(@ModelAttribute("user") UserInfo user) {
		
		sendUserData.saveUserInfo(user);
		
		return "redirect:/index";
	}
}
