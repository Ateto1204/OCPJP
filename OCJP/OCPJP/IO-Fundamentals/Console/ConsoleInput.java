package build;

import java.io.Console;

public class ConsoleInput {
    public static void main(String[] args) {
        Console console = System.console();
        boolean userValid = false;
        if (console != null) {
            String account;
            String password;
            do {
                account = console.readLine("%s", "Account: ");
                password = new String(console.readPassword("%s", "Password: "));
                if (account.equals("jim") && password.equals("password")) {
                    System.out.println("Correct! System quits!");
                    userValid = true;
                } else {
                    System.out.println("Wrong! Try again!\n");
                }
            } while(!userValid);
        }
    }
}
