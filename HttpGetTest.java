

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
//得到重定向地址
public class HttpGetTest {

	public static void main(String[] args){
		String path = "http://union.click.jd.com/jda?e=&p=AyIBZRprFDJWWA1FBCVbV0IUEEULWldTCQQAQB1AWQkFWxUFGgZWE1oKW1dbCCsaVH1WcCFYPnACZFA1cjt8A1REB1kNGQ4iBFwZXxYBEQVRK18WARo3ZXopJTIiB1AZUhUEFQddHFwWBA%3D%3D&t=W1dCFBBFC1pXUwkEAEAdQFkJBVsVBRoGVhNaCltXWwg%3D";
		HttpURLConnection conn;
		try {
			conn = (HttpURLConnection) new URL(path).openConnection();
			conn.setInstanceFollowRedirects(false);  
			String final_url = conn.getHeaderField("Location");
	    System.err.println(final_url);   
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}    

	}

}
