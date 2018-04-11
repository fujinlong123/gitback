package netmi;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class UrlTest {
	public static void main(String[] args) throws MalformedURLException, URISyntaxException {
		URI uri = new URI("//www.baidu.com/sadf");
		// URL url=new URL("//www.baidu.com/sadf");
		System.out.println(uri.getHost());
		System.out.println(uri.getPath());
		System.out.println(uri.getScheme());

		uri = new URI("/sadf/asdfaasdf/eee");
		System.out.println(uri.getHost());
		uri =new URI("http://github.com/");
		uri=new URI("//index.iqiyi.com/q/?name=“表里不一”的美食&aid=200118301");
		System.out.println(uri.getHost());

	}
}
