
import java.util.Base64;

public class Base64Utils 
{
    public static void base64(String str){
        byte[] bytes = str.getBytes();
        String encoded = Base64.getEncoder().encodeToString(bytes);
        System.out.println("Base64加密后 : " + encoded);
        
        byte[] decoded = Base64.getDecoder().decode(encoded);
        String decodeStr = new String(decoded);
        System.out.println("Base64解密后 : "+decodeStr);
        
    }
}
