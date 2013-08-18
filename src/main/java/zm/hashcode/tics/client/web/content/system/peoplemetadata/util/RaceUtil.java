/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.system.peoplemetadata.util;

import zm.hashcode.tics.client.web.content.system.peoplemetadata.model.RaceBean;
import zm.hashcode.tics.domain.ui.demographics.Race;

/**
 *
 * @author geek
 */
public class RaceUtil {

    public RaceBean getBean(Race race) {
        RaceBean bean = new RaceBean();
        bean.setId(race.getId());
        bean.setRaceName(race.getRaceName());
        return bean;
    }
}
