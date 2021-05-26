package mvc;
public class LoginModel {
   private String user;
   private String pass;

   public LoginModel() {}

   public LoginModel(String _user, String _pass) {
      this.user = _user;
      this.pass = _pass;
   }

   public String getUser() {
      return user;
   }

   public void setUser(String _user) {
      this.user = _user;
   }

   public String getPass() {
      return pass;
   }

   public void setPass(String _pass) {
      this.pass = _pass;
   }
}
