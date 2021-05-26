package mvc;
public class LoginController {
   private LoginView view;

   public LoginController(LoginView view) {
      this.view = view;
   }

   private boolean check(LoginModel user) {
      if ((user.getUser().equals("admin")) 
      && (user.getPass().equals("123"))) {
         return true;
      }
      return false;
   }

   public void login() {
      while (true) {
         LoginModel user = view.getInfo();
         if (check(user)) {
            view.showMessage("Login successfully");
            break;
            } else {
            view.showMessage("Wrong username or password");
         }
      }
   }
}