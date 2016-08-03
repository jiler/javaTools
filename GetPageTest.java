import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
//得到一个网页的内容
public class GetPageTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Document doc = Jsoup.connect("http://www.queshu.com/link/978031620164/100980395/").get();
		String page_url = doc.head().child(0).data();
		if(page_url.contains("duomai")){
			String[] arr = page_url.split("jd.com%2F");
			String id = arr[1].substring(0,arr[1].length()-6);
			System.err.println(id);
		}
		else{
			String[] arr = doc.head().child(0).data().split("jdc");
			String redirect_url = "http://union.click.jd.com/jda"+arr[1].substring(0,arr[1].length()-1);
			System.out.println(redirect_url);
		}	
	}
}
