
import java.net.URL;
import org.jsoup.nodes.Document;
import org.jsoup.Jsoup;
import java.net.MalformedURLException;
import java.io.IOException;
import org.jsoup.nodes.Element;
public class Main3 {
    public static void main(String[] args) throws IOException, MalformedURLException {
        URL url = new URL("https://mi.fiime.cn/index.html");
        Document doc = Jsoup.parse(url, 3000);
        System.out.println("打印全部: " + doc + "\n----------------------");
        Element placardTitle = doc.getElementsByClass("mb-3").first();
        System.out.println(placardTitle.text());
        Element placardContent = doc.getElementsByClass("search-box").first();
        System.out.println(placardContent.text());

        System.out.println(modifyString(placardContent.text()));
    }

    private static  String modifyString(String strs) {
        if (strs == null) return "null";
        String str= strs.replaceAll(" ", ",");
        String str2= str.substring(0, str.indexOf("↑"));
        if (str2.lastIndexOf(",") == str2.length() - 1) {
            String str3=str2.substring(0, str2.lastIndexOf(","));
            System.out.println("句号 : "+str3+"。");
        }
        return str;

    }
}
