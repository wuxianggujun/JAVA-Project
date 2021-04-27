
import org.jsoup.nodes.Document;
import org.jsoup.Jsoup;
import org.jsoup.select.Elements;
import java.io.IOException;

public class Main2   
{
	public static void main(String[] args) throws IOException{
		
		Document document = null;
		String url = "https://mi.fiime.cn/umi.html";
		document = Jsoup.connect(url).get();
		String[] sRomNameLength={"ArrowOS","Pixel Experience Plus","Project 404","AICP","crDroid","DotOS"};
		for(int srl = 0;srl<sRomNameLength.length;srl++){
			Elements elements = document.getElementsByAttributeValue("id", sRomNameLength[srl]);
			System.out.println(elements);

			
}



}



	
	
}
