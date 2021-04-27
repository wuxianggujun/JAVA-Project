
import org.jsoup.nodes.Document;
import org.jsoup.Jsoup;
import java.io.IOException;public class Main4  
{
    public static void main(String[] args) throws IOException{
        Document document = null;
        String url = "https://mi.fiime.cn/umi.html";
        document = Jsoup.connect(url).get();
       System.out.println(document.html());
    }
}
