package cn.suishoucm.weixin.netmi.controller;

import java.net.URI;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.BasicCookieStore;
import org.jsoup.Jsoup;
import org.jsoup.helper.StringUtil;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.suishoucm.weixin.netmi.util.ByteArrayResponse;
import cn.suishoucm.weixin.netmi.util.HttpUtils;

@Controller

public class UrlLoadController {
	Logger logger = LoggerFactory.getLogger(UrlLoadController.class);
	private static HttpClientContext context = HttpClientContext.create();
	private static Map<String, String> map = new ConcurrentHashMap<>();

	static {
		context.setCookieStore(new BasicCookieStore());
	}

	@RequestMapping(value = "")

	public void openUrl(String url, Model model, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.getSession().setAttribute("host", url);
		page(url, model, response);

	}
	
	@RequestMapping("{a1:.+}")
	public void a1(@PathVariable("a1") String a1, Model model,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		String relativePath = a1 ;
		String url = getHost("", request)+"/"+relativePath;
		page(url, model, response);
	}


	@RequestMapping("{a1}/{a2:.+}")
	public void a1a2(@PathVariable("a1") String a1, @PathVariable("a2") String a2, Model model,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		String relativePath = a2 ;
		String url = getHost(a1, request)+"/"+relativePath;
		page(url, model, response);
	}

	@RequestMapping("{a1}/{a2}/{a3:.+}")
	public void a1a2a3(@PathVariable("a1") String a1, @PathVariable("a2") String a2, @PathVariable("a3") String a3,
			Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String relativePath = a2 + "/" + a3;

		String url = getHost(a1, request)+"/"+relativePath;

		page(url, model, response);
	}

	@RequestMapping("{a1}/{a2}/{a3}/{a4:.+}")
	public void a1a2a3a4(@PathVariable("a1") String a1, @PathVariable("a2") String a2, @PathVariable("a3") String a3,
			@PathVariable("a4") String a4, Model model, HttpServletRequest request, HttpServletResponse response)
					throws Exception {
		String relativePath = a2 + "/" + a3 + "/" + a4;

		String url = getHost(a1, request)+"/"+relativePath;

		page(url, model, response);
	}

	@RequestMapping("{a1}/{a2}/{a3}/{a4}/{a5:.+}")
	public void a1a2a3a4a5(@PathVariable("a1") String a1, @PathVariable("a2") String a2, @PathVariable("a3") String a3,
			@PathVariable("a4") String a4, @PathVariable("a5") String a5, Model model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String relativePath = a2 + "/" + a3 + "/" + a4 + "/" + a5;
		String url = getHost(a1, request)+"/"+relativePath;
		page(url, model, response);
	}

	@RequestMapping("{a1}/{a2}/{a3}/{a4}/{a5}/{a6:.+}")
	public void a1a2a3a4a5a6(@PathVariable("a1") String a1, @PathVariable("a2") String a2,
			@PathVariable("a3") String a3, @PathVariable("a4") String a4, @PathVariable("a5") String a5,
			@PathVariable("a6") String a6, Model model, HttpServletRequest request, HttpServletResponse response)
					throws Exception {
		String relativePath = a2 + "/" + a3 + "/" + a4 + "/" + a5 + "/" + a6;
		String url = getHost(a1, request)+"/"+relativePath;
		page(url, model, response);
	}

	@RequestMapping("{a1}/{a2}/{a3}/{a4}/{a5}/{a6}/{a7:.+}")
	public void a1a2a3a4a5a6a7(@PathVariable("a1") String a1, @PathVariable("a2") String a2,
			@PathVariable("a3") String a3, @PathVariable("a4") String a4, @PathVariable("a5") String a5,
			@PathVariable("a6") String a6, @PathVariable("a7") String a7, Model model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String relativePath = a2 + "/" + a3 + "/" + a4 + "/" + a5 + "/" + a6 + "/" + a7;

		String url = getHost(a1, request)+"/"+relativePath;
		page(url, model, response);
	}

	@RequestMapping("{a1}/{a2}/{a3}/{a4}/{a5}/{a6}/{a7}/{a8:.+}")
	public void a1a2a3a4a5a6a7a8(@PathVariable("a1") String a1, @PathVariable("a2") String a2,
			@PathVariable("a3") String a3, @PathVariable("a4") String a4, @PathVariable("a5") String a5,
			@PathVariable("a6") String a6, @PathVariable("a7") String a7, @PathVariable("a8") String a8, Model model,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		String relativePath = a2 + "/" + a3 + "/" + a4 + "/" + a5 + "/" + a6 + "/" + a7 + "/" + a8;
		String url = getHost(a1, request)+"/"+relativePath;
		page(url, model, response);
	}

	@RequestMapping("{a1}/{a2}/{a3}/{a4}/{a5}/{a6}/{a7}/{a8}/{a9:.+}")
	public void a1a2a3a4a5a6a7a9(@PathVariable("a1") String a1, @PathVariable("a2") String a2,
			@PathVariable("a3") String a3, @PathVariable("a4") String a4, @PathVariable("a5") String a5,
			@PathVariable("a6") String a6, @PathVariable("a7") String a7, @PathVariable("a8") String a8,
			@PathVariable("a9") String a9, Model model, HttpServletRequest request, HttpServletResponse response)
					throws Exception {
		String relativePath = a2 + "/" + a3 + "/" + a4 + "/" + a5 + "/" + a6 + "/" + a7 + "/" + a8 + "/" + a9;
		String url = getHost(a1, request)+"/"+relativePath;
		page(url, model, response);
	}

	@RequestMapping("{a1}/{a2}/{a3}/{a4}/{a5}/{a6}/{a7}/{a8}/{a9}/{a10:.+}")
	public void a1a2a3a4a5a6a7a9a10(@PathVariable("a1") String a1, @PathVariable("a2") String a2,
			@PathVariable("a3") String a3, @PathVariable("a4") String a4, @PathVariable("a5") String a5,
			@PathVariable("a6") String a6, @PathVariable("a7") String a7, @PathVariable("a8") String a8,
			@PathVariable("a9") String a9, @PathVariable("a10") String a10, Model model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String relativePath = a2 + "/" + a3 + "/" + a4 + "/" + a5 + "/" + a6 + "/" + a7 + "/" + a8 + "/" + a9 + "/"
				+ a10;
		String url = getHost(a1, request)+"/"+relativePath;
		page(url, model, response);
	}

	private void page(String url, Model model, HttpServletResponse response) throws Exception {
		logger.info("º”‘ÿ£∫" + url);
		URI baseUri = new URI(url);
		ByteArrayResponse bar = HttpUtils.getBinary(url);
		if (bar.getMimeType().equals("text/html")) {
			String html = new String(bar.getResponseBody(), bar.getCharset());
			Document doc = Jsoup.parse(html, bar.getCharset().toString());

			Elements eles = doc.getElementsByTag("script");
			attrFilter(eles, baseUri, "src");

			eles = doc.select("link[rel!='dns-prefetch']");
			attrFilter(eles, baseUri, "href");
			// eles = doc.select("a");
			// attrFilter(eles, baseUri, "href");

			html = doc.toString();
			bar.setResponseBody(html.getBytes(bar.getCharset()));

		}
		response.setContentType(bar.getMimeType());
		if (bar.getCharset() != null) {
			response.setCharacterEncoding(bar.getCharset().toString());
		}
		response.setContentLength(bar.getResponseBody().length);
		response.getOutputStream().write(bar.getResponseBody());

	}

	private void attrFilter(Elements eles, URI baseUri, String attrName) {
		for (Element ele : eles) {
			try {
				String src = ele.attr(attrName);
				if (!"".equals(src)) {
					URI uri = new URI(src);
					String host = uri.getHost();
					if (host == null) {
						host = baseUri.getHost();
					}
					String id = "mirrorId_" + DigestUtils.md5Hex(host);
					String scheme = uri.getScheme();
					if (scheme == null || (!scheme.equals("http") && !scheme.equals("https"))) {
						scheme = baseUri.getScheme();
					}
					map.put(id, scheme + "://" + host);
					src = id + (uri.getPath().startsWith("/") ? uri.getPath() : "/" + uri.getPath());
					ele.attr(attrName, "/" + src + (uri.getQuery() == null ? "" : "?" + uri.getQuery()));
				}
			} catch (Exception e) {
				logger.error(ele.toString(), e);
			}

		}
	}

	private String getHost(String key, HttpServletRequest request) {
		String host = map.get(key);
		if (host == null) {
			host = (String) request.getSession().getAttribute("host");
			host=host.endsWith("/")?host.substring(0, host.length()-1):host;
					
			host=host+ "/" + key;
		}
		return host;
	}

}
