/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pkg;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author JE5024472
 */
public class LoginAction extends ActionSupport implements SessionAware
{
    private String username;
    private String password;
    //private HibernateLogin valid;
    //private Map<String, Object> userSession;
    
    public void setSession(Map<String, Object>session) 
    {
        UserSession.userSession = session;
    }
    
    @Override
    public String execute() throws Exception
    {
        String loggedUsername = null;
        if(UserSession.userSession.containsKey("username"))
        {
            loggedUsername = (String)UserSession.userSession.get("username");
        }
        if(loggedUsername != null)
        {
            return "success";
        }
        if(username != null && password != null)
        {
            UserSession.userSession.put("username", username);
            return "success";
        }
        //userSession.put("username",username);
        return "input";
    }
    
    @Override
    public void validate()
    {
        //valid = new HibernateLogin();
        if(!HibernateLogin.validLogin(username, password) && !username.equals("") && !password.equals(""))
        {
            addActionError("Username or Password is incorrect.");
            //addFieldError("first","First Number is Odd.");            
        }
        if(username.equals(""))
        {
            addFieldError("username","Username is needed.");
        }
        if( password.equals(""))
        {
            addFieldError("password","Password is needed.");
        }
        
    }
    
//    public String logout()
//    {
//        if(UserSession.userSession.containsKey("username"))
//        {
//            UserSession.userSession.remove("username");
//        }
//        return "success";
//    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the userSession
     */
//    public Map<String, Object> getUserSession() {
//        return userSession;
//    }
//
//    /**
//     * @param userSession the userSession to set
//     */
//    public void setUserSession(Map<String, Object> userSession) {
//        this.userSession = userSession;
//    }
    

}
