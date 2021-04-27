import java.util.*;

import java.net.URL;
import java.net.HttpURLConnection;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.io.BufferedReader;
import org.json.JSONObject;
import org.json.JSONException;
import java.io.OutputStream;
import java.net.URLEncoder;

public class Main {

	public static void main(String[] args) {
		System.out.println("Hello World!");
        login();
    }

    private static void login() {
        try {
            URL url = new URL("https://wd.cn.ecsxs.com/api/v1/user/login/");

            HttpURLConnection conn= (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(5000);
            conn.setRequestMethod("POST");
            conn.setConnectTimeout(10000);
            conn.setDoInput(true);
            conn.setDoOutput(true);
                String params = "username=" + URLEncoder.encode("WuXiangGuJun", "UTF-8") 
                    + "&password=" + URLEncoder.encode("3344207732", "UTF-8");
                OutputStream outputStream = conn.getOutputStream();
                outputStream.write(params.getBytes());
                outputStream.flush();
                outputStream.close(); 
                parseJson(conn);
                
                
        } catch (IOException e) {
            e.printStackTrace();
        }

    }





    private static String inputStreamToString(InputStream inputStream) {
        StringBuffer buffer= new StringBuffer();
        InputStreamReader  inputStreamReader;        
        try {
            inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String str = null;
            while ((str = bufferedReader.readLine()) != null) {
                buffer.append(str);
            }
            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();           
        } catch (UnsupportedEncodingException|IOException e) {
            e.printStackTrace();
        }
        return buffer.toString();
    }

    private static void parseJson(HttpURLConnection conn) {  
        try {
            if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {

                InputStream is = conn.getInputStream();  
            //  System.out.println(inputStreamToString(is));
                JSONObject jsonObject = new JSONObject(inputStreamToString(is));
                String name = jsonObject.getString("name");
                System.out.println(name);
                String time = jsonObject.getString("time");
                System.out.println(time);
                String msg = jsonObject.getString("msg");
                System.out.println(msg);
                int  state = jsonObject.getInt("state");
                System.out.println(state);
                JSONObject jsonData = jsonObject.getJSONObject("data");
                
                String token = jsonData.getString("token");
                System.out.println(token);
                String username = jsonData.getString("username");
                System.out.println(username);
                
            } else {

            }
        } catch (JSONException|IOException e) {
            e.printStackTrace();
        }     
    }

}
