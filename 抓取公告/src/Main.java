import java.util.*;
import org.jsoup.nodes.Document;
import org.jsoup.Jsoup;
import java.net.URL;
import java.io.IOException;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Main {
	
	public static void main(String[] args) throws IOException {
		String url= "https://mi.fiime.cn/index.html";
        Document parse = Jsoup.parse(new URL(url),3000);
        System.out.println(parse);
        Element postlist = parse.getElementById("search");
        System.out.println("-------------------");
        System.out.println(postlist);
        Element hhhhh=postlist.select("div p:gt(1)").first();
        System.out.println("呵呵→_→"+hhhhh);
        Elements  bbb= hhhhh.select("p.not(.fa fa-search)");
        for(Element e:bbb){
            System.out.println(e);
        }
        
        
        
        Element ss= postlist.getElementsByClass("search-box").first();
        System.out.println("search-box"+ss);
        Element resultId = parse.select("h4.mb-3").first();
        System.out.println("获取的公告 : "+resultId.text());
        
        Elements huoquP=parse.select("div.popup > p");
        System.out.println("卧槽(*｀へ´*)"+huoquP.text());
      
        
        
    }
    
}
