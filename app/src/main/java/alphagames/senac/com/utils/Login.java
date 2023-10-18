package alphagames.senac.com.utils;

public class Login {
    private boolean isLogged = false;

    public Login(boolean isLogged) {
        this.isLogged = isLogged;
    }

    public Login() {
    }

    public boolean isLogged() {
        return isLogged;
    }

    public void setLogged(boolean logged) {
        isLogged = logged;
    }
}
