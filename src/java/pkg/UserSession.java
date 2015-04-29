/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pkg;

import java.util.Map;

public class UserSession
{
    public static Map<String, Object> userSession;

    public static boolean clearSession()
    {
        userSession.clear();
        if(userSession.size() > 0)
            return true;
        else
            return false;
    }
}
