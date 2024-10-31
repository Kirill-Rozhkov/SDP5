package Task_1;

public class LoginPresenter {
    private final LoginView view;
    private final User validUser;

    public LoginPresenter(LoginView view) {
        this.view = view;
        this.validUser = new User("admin", "password123");
    }

    public void onLoginButtonClicked() {
        String username = view.getUsername();
        String password = view.getPassword();

        if (validateCredentials(username, password)) {
            view.showLoginSuccess();
        } else {
            view.showLoginError("Invalid username or password");
        }
    }

    private boolean validateCredentials(String username, String password) {
        return username.equals(validUser.getUsername()) && password.equals(validUser.getPassword());
    }
}
