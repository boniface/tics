/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.system.positions.util;

import zm.hashcode.tics.client.web.content.system.positions.model.PositionTypeBean;
import zm.hashcode.tics.domain.ui.position.PositionType;

/**
 *
 * @author geek
 */
public class PositionTypeUtil {

    public PositionTypeBean getBean(PositionType positionType) {
        PositionTypeBean bean = new PositionTypeBean();
        bean.setId(positionType.getId());
        bean.setName(positionType.getName());
        return bean;
    }
}
