package mvc;
import java.util.Scanner;
public class LoginView {
   public static Scanner scanner = new Scanner(System.in);

   public void showMessage(String msg) {
      System.out.println(msg);
   }

   public LoginModel getInfo() {
      System.out.println("_____LOGIN_____");
      System.out.println();

      LoginModel user = new LoginModel();
      System.out.print("Username: ");
      user.setUser(scanner.next());
      System.out.print("Password: ");
      user.setPass(scanner.next());
      return user;
   }
}