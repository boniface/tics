/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.app.util.sec;

/**
 *
 * @author boniface
 */
public class LoginEvent {

    private final String login;
    private final String password;

    public LoginEvent(String login, String password) {

        this.login = login;
        this.password = password;
    }

    public String getLogin() {

        return login;
    }

    public String getPassword() {

        return password;
    }
}
