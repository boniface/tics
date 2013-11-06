/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.password.util;

import java.io.Serializable;
import zm.hashcode.tics.app.security.GetUserCredentials;
import zm.hashcode.tics.app.security.PasswordEncrypt;

import zm.hashcode.tics.domain.users.User;

/**
 *
 * @author boniface
 */
public class PasswordCheckUtil implements Serializable {

    private final GetUserCredentials creds = new GetUserCredentials();
    private final User user = creds.getLoggedInUser();

    public boolean checkOldPassowrd(String password) {
        boolean isCorrect = false;
        String passwd = PasswordEncrypt.encrypt(password);
        String savedPassword = user.getPasswd();
        if (passwd.equals(savedPassword)) {
            isCorrect = true;
        }
        return isCorrect;
    }

    public static boolean comparePasswords(String password, String repeat) {
        boolean isSame = false;
        if (password.equals(repeat)) {
            isSame = true;
        }
        return isSame;
    }
}
