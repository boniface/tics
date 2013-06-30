/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.app.util.sec;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author boniface
 */
public class RequestHolder {

    private static final ThreadLocal<HttpServletRequest> THREAD_LOCAL = new ThreadLocal<HttpServletRequest>();

    public static HttpServletRequest getRequest() {

        return THREAD_LOCAL.get();
    }

    public static void setRequest(HttpServletRequest request) {

        THREAD_LOCAL.set(request);
    }

    public static void clean() {

        THREAD_LOCAL.remove();
    }
}
