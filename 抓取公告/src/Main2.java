
import java.net.URL;
import org.jsoup.nodes.Document;
import org.jsoup.Jsoup;
import java.io.IOException;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Element;
public class Main2 
{
   public static void main(String[] args) throws IOException{
       URL url = new URL("https://mi.fiime.cn/index.html");
       Document doc = Jsoup.parse(url,3000);
       System.out.println("打印全部: "+doc+"\n----------------------");
       
       Elements elements = doc.getElementsByClass("popup");
       for(Element e:elements){
           System.out.println(e);
           System.out.println("打印公告 : "+e.getElementsByClass("mb-3").text());
           Element ee = e.select("div p:gt(1)").first();
           String str= ee.text().replaceAll(" ",",");
           
           String str2 = str.substring(0,str.indexOf("↑"));
          /* char i=str2.charAt(str2.lastIndexOf(","));
           System.out.println(i);
           System.out.println("文本"+str2.replace(i,'。'));
           */
           System.out.println(str2);
           System.out.println(str2.lastIndexOf(","));
           System.out.println(str2.length());
          
           if(str2.lastIndexOf(",")==(str2.length()-1)){
               String str3=str2.substring(0,str2.lastIndexOf(","));
               System.out.println(str3);
            // String str3=str2+ "。";
             System.out.println("我是句号结尾的 :"+str3+"。");
           }else{
               String str3=str2;
               System.out.println(str3);
           }
           
           
         /*  System.out.println(str.substring(0,str.lastIndexOf(",")));
           System.out.println(ee.select("a[href]"));
           System.out.println(ee.getElementsByAttribute("href"));
           System.out.println(ee.select("[href^=http]").html());  
           
           */
       }
   }
}
