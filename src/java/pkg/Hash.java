
package pkg;
import java.io.UnsupportedEncodingException;
 import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;



public class Hash {
 
 public byte[] getHash(String password) throws NoSuchAlgorithmException, UnsupportedEncodingException {
       MessageDigest digest = MessageDigest.getInstance("SHA-1");
       digest.reset();
       byte[] input = digest.digest(password.getBytes("UTF-8"));
       return input;
    }
 
    public static String md5(String input) {
         
        String md5 = null;
         
        if(null == input) return null;
         
        try {
             
        //Create MessageDigest object for MD5
        MessageDigest digest = MessageDigest.getInstance("MD5");
         
        //Update input string in message digest
        digest.update(input.getBytes(), 0, input.length());
 
        //Converts message digest value in base 16 (hex) 
        md5 = new BigInteger(1, digest.digest()).toString(16);
 
        } catch (NoSuchAlgorithmException e) {
 
            e.printStackTrace();
        }
        return md5;
    } 
 
//    public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException 
//    {
////        Hash h = new Hash();
////        byte[] bytes = h.getHash("admin1pass");
////        System.out.println(bytes.toString());
////        String s = new String(bytes);
////        System.out.println(s);
//          SecureRandom sec = new SecureRandom();
//          String password = "admin2pass";
//          //String salt = new BigInteger(130,sec).toString();
//          String salt = "109527042595388724195321488368710009176";
//          System.out.println(salt);
//           System.out.println("MD5 in hex: " + md5(password + salt));
//            System.out.println("MD5 in hex: " + md5(password));
//             System.out.println("MD5 in hex: " + md5(null));
//    }
}
