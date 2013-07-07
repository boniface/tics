/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.test.client;



import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.testng.annotations.Test;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.testng.annotations.BeforeMethod;
import zm.hashcode.tics.client.Home;

/**
 *
 * @author boniface
 */

public class HomeTest {
    private MockMvc mockMvc;
 
    @BeforeMethod
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(new Home()).build();
    }
     
    @Test
    public void getHome() throws Exception {
        this.mockMvc.perform(get("/"))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(forwardedUrl("/index"));
    }
     
    @Test
    public void postEmptyData() throws Exception {
        this.mockMvc.perform(post("/"))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(model().attributeHasFieldErrors("formDTO", "messageFromUser"))
            .andExpect(forwardedUrl("/home"));
    }
     
    @Test
    public void postSomething() throws Exception {
         
        this.mockMvc.perform(post("/").param("messageFromUser", "hello"))
            .andDo(print())
            .andExpect(status().isMovedTemporarily()) // 302 redirect
            .andExpect(model().hasNoErrors())
            .andExpect(flash().attributeExists("message"))
            .andExpect(redirectedUrl("/"));
    }
}
    

