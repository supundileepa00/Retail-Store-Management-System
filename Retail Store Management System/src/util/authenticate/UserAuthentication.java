package util.authenticate;
import bean.User;
import service.UserService;

public class UserAuthentication {
    public static String validateUser(User user){
        UserService userService = new UserService();
        User resultUser = userService.loadSpecificUser(user.getuID());
        if(resultUser.getuID() == null){
            return "Invalid User";
        }else if(!resultUser.getuPassword().equals(user.getuPassword())){
            return "Invalid Password";
        }else{
            return "success";
        }
    }
}

