/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package zm.hashcode.tics.domain.training.schedule;

import java.io.Serializable;
import org.springframework.data.mongodb.core.mapping.DBRef;
import zm.hashcode.tics.domain.ui.util.Funder;

/**
 *
 * @author boniface
 */

public class CourseFunders implements Serializable {
    @DBRef
    private Funder funder;
}
