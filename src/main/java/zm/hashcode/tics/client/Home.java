/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import zm.hashcode.tics.client.web.FormDTO;
import zm.hashcode.tics.services.ui.location.LocationService;

/**
 *
 * @author boniface
 */
@Controller
public class Home {

    @Autowired
    LocationService locationService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String displayHome(Model model) {
        System.out.println("THis Was Called. Can we call a Servive here?" + locationService);

        return "/index";
    }

    @ModelAttribute
    public FormDTO createFormBean() {
        return new FormDTO();
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String submitMessage(@Valid FormDTO formDTO, BindingResult result,
            SessionStatus sessionStatus,
            RedirectAttributes redirectAttrs) {

        if (result.hasErrors()) {
            return "/home";
        }
        String message = formDTO.toString();
        sessionStatus.setComplete();
        redirectAttrs.addFlashAttribute("message", message);

        return "redirect:/";
    }
}
