/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pkg;

import com.opensymphony.xwork2.ActionSupport;
import java.math.BigInteger;
import java.security.SecureRandom;


/**
 *
 * @author JE5024472
 */
public class UpdatePass extends ActionSupport
{
    private String new_pass;
    private String new_pass2;
    private String old_pass;
    
    public String execute()
    {
        SecureRandom sec = new SecureRandom();
        String salt = new BigInteger(130,sec).toString();
        String uname = (String)UserSession.userSession.get("username");
        String password = Hash.md5(new_pass + salt);
        HibernateLogin.updatePass(uname,password, salt);
        return "success";
    }
    
    public void validate()
    {
        if(!new_pass.equals(new_pass2))
        {
            addActionError("Passwords do not match.");
        }
        
        String uname = (String)UserSession.userSession.get("username");
        if(!HibernateLogin.validLogin(uname, old_pass))
        {
            addActionError("Old Password is incorrect.");   
        }
        if( new_pass.equals(""))
        {
            addFieldError("new_pass","Field is needed.");
        }
        if(new_pass2.equals(""))
        {
            addFieldError("new_pass2","Field is needed.");
        }
        if( old_pass.equals(""))
        {
            addFieldError("old_pass","Field is needed.");
        }
    }

    /**
     * @return the new_pass
     */
    public String getNew_pass() {
        return new_pass;
    }

    /**
     * @param new_pass the new_pass to set
     */
    public void setNew_pass(String new_pass) {
        this.new_pass = new_pass;
    }

    /**
     * @return the new_pass2
     */
    public String getNew_pass2() {
        return new_pass2;
    }

    /**
     * @param new_pass2 the new_pass2 to set
     */
    public void setNew_pass2(String new_pass2) {
        this.new_pass2 = new_pass2;
    }

    /**
     * @return the old_pass
     */
    public String getOld_pass() {
        return old_pass;
    }

    /**
     * @param old_pass the old_pass to set
     */
    public void setOld_pass(String old_pass) {
        this.old_pass = old_pass;
    }
}
