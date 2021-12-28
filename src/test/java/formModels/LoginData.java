package formModels;

public class LoginData {
    public String name, password, confirmPass, email;

    public LoginData(String name, String password, String confirmPass, String email) {
        this.name = name;
        this.password = password;
        this.confirmPass = confirmPass;
        this.email = email;
    }
}
