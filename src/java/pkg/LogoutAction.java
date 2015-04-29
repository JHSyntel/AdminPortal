/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pkg;

import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;

public class LogoutAction implements SessionAware
{
    public String execute()
    {
        if(UserSession.userSession.containsKey("username"))
        //if(UserSession.clearSession())
        {
            //UserSession.clearSession();
            UserSession.userSession.remove("username");
            HibernateLogin.validLogout();
            return "success";  
        }
        //UserSession.userSession.clear();
        return "error";        
    }
    
    public void setSession(Map<String, Object>session) 
    {
        UserSession.userSession = session;
    }
}
