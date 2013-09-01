/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.app.exceptions;

import com.mongodb.MongoException;

/**
 *
 * @author boniface
 */
public class DuplicateExceptions extends MongoException.DuplicateKey {

    public DuplicateExceptions(int code, String msg) {
        super(code, msg);
    }
}
