/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web;

import javax.validation.constraints.NotNull;

/**
 *
 * @author boniface
 */
public class FormDTO {

    @NotNull
    private String messageFromUser;

    public String getMessageFromUser() {
        return messageFromUser;
    }

    public void setMessageFromUser(String messageFromUser) {
        this.messageFromUser = messageFromUser;
    }

    @Override
    public String toString() {
        return "FormDTO [messageFromUser=" + messageFromUser + "]";
    }
}
