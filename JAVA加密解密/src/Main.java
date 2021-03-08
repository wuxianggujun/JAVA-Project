import java.util.*;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class Main {
	
	public static void main(String[] args) throws UnsupportedEncodingException {
	
        String base64encodeString = Base64.getEncoder().encodeToString("无相孤君".getBytes("UTF-8"));
        System.out.println(base64encodeString);
        Base64Utils.base64("无相孤君");
        String str = MD5Utils.Md5Encode("无相孤君");
        System.out.println(str);
    }
    
}
