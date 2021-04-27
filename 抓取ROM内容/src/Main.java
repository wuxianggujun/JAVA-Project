
import org.jsoup.nodes.Document;
import org.jsoup.Jsoup;
import org.jsoup.select.Elements;
import java.io.IOException;
import org.jsoup.nodes.Element;

public class Main {

	public static void main(String[] args) throws IOException {
		Document document = null;
        String url = "https://mi.fiime.cn/umi.html";

        document = Jsoup.connect(url).get();
        String[] siaoao={"ArrowOS","Pixel Experience Plus","Project 404","AICP","crDroid","DotOS"};

        for (int i= 0;i < siaoao.length;i++) {
            Elements elements = document.getElementsByAttributeValue("id", siaoao[i]);
			System.out.println(elements);
            for (Element e:elements) {
                System.out.println("ROM名字 : " + e.getElementsByAttributeValue("class", "text-muted para-desc mb-0 mx-auto").text());
                // System.out.println(e.select("div.section-title.ml-lg-5"));
                Elements elements2 = e.select("div.section-title.ml-lg-5");
                for (Element e2:elements2) {
                   // System.out.println(e2);
                    System.out.println(e2.select(".left >li>b").get(0).parent());
                    //System.out.println(e2.select(".right >li>b"));
                    System.out.println(e2.select(".left >li").text());
                    //String str = e2.select(".left >li").text();
                    //String name = str.substring(0,str.indexOf(":"));
                    //System.out.println(name);
                    //String content = 
                    //System.out.println("字符串长度 :" + str.length());
                    //System.out.println(str.substring(str.indexOf(":"),str.length()));
                    
                    
                    //System.out.println(e2.select(".left > li").get(0).text());

                }




            }
            //  System.out.println(elements);
            /* Element element = document.getElementById(siaoao[i]);


             System.out.println(element.getElementsByClass("section-title mb-20").first().text());

             System.out.println(element.select(".section-title.mb-20"));
             */              
        }




    }

}
