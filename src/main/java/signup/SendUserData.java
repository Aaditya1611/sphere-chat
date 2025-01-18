package signup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SendUserData {
	
	@Autowired
	private UserInfoRepo userInfoRepo;
	
	public void saveUserInfo(UserInfo user) {
		
		userInfoRepo.save(user);
	}
	

}
