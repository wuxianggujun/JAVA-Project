
import java.security.MessageDigest;

public class MD5Utils 
{
    private static final String hexDigIts[] = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};
    /**
    Md5加密 32位
    */
    public static String Md5Encode(String str){
        String resultString= null;
        try{
            resultString = new String(str);
            MessageDigest md = MessageDigest.getInstance("MD5");
            resultString = byteArrayToHexString(md.digest(resultString.getBytes("utf-8")));
            }catch(Exception e){
            e.printStackTrace();
        }
       return resultString;
    }

    private static String byteArrayToHexString(byte[] digest) {
        StringBuffer resultsb = new StringBuffer();
        for(int i= 0;i<digest.length;i++){
            resultsb.append(byteToHexString(digest[i]));
        }
        return resultsb.toString();
    }

    private static String byteToHexString(byte digest) {
        int n = digest;
        if(n<0){
            n += 256;
        }
        int d1= n / 16;
        int d2 = n % 16;
        
        return hexDigIts[d1] + hexDigIts[d2];
    }
    
}
