
package mvc;
public class MVCPattern {

   public static void main(String[] args) {
      LoginView view = new LoginView();
      LoginController control = new LoginController(view);

      control.login();
   }
}