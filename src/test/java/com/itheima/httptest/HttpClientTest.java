package com.itheima.httptest;


import com.itheima.http.HttpMethod;
import com.itheima.http.HttpRequest;
import com.itheima.http.HttpResponse;
import org.testng.annotations.Test;

public class HttpClientTest {

	@Test
	public void test() {
		HttpRequest req = HttpRequest
				.get("http://192.168.1.20:8080/sns-api/user/topNActiveUser?loginUserId=1");
		HttpResponse res = req.query("loginUserId", "2")
				.query("usernmae", "aa").send();
		String body = res.body();
		System.out.println(body);
		System.out.println(res.firstHeader("Server"));
	}

	@Test
	public void test2() {
		HttpRequest req = HttpRequest
				.get("http://192.168.1.20:8080/sns-api/user/topNActiveUser?loginUserId=1&loginUserId=2");
		HttpResponse res = req.send();
		String body = res.body();
		System.out.println(body);
		System.out.println(res.firstHeader("Server"));
	}

	@Test
	public void test1() {
		HttpRequest req = new HttpRequest();
		req.method(HttpMethod.GET).host("192.168.1.20").port(8080)
				.path("/sns-api/user/topNActiveUser").query("loginUserId", "1");
		HttpResponse res = req.send();
		String body = res.body();
		System.out.println(body);
		System.out.println(res.firstHeader("Server"));
		System.out.println(res);
	}

	@Test
	public void postXmlTest() {
		HttpRequest req = new HttpRequest();
		req.method(HttpMethod.POST)
				.host("101.200.167.51")
				.port(8080)
				.path("/http/method1")
				.contentType("application/xml")
				.data("<?xml version='1.0' encoding='ISO-8859-1'?><note><to>George</to><from>John</from><heading>Reminder</heading><body>Don't forget the meeting!</body></note>");
		HttpResponse res = req.send();
		String body = res.body();
		System.out.println(body);
		System.out.println(res.firstHeader("Server"));
		System.out.println(res);
	}

	@Test
	public void postJsonTest() {
		HttpRequest req = new HttpRequest();
		HttpMethod[] values = HttpMethod.values();
		req.method(HttpMethod.POST)
				.host("101.200.167.51")
				.port(8080)
				.path("/http/method1")
				.contentType("application/json")
				.data("{'id':1,'name':'Yan  Kunpeng','email':'yankunpeng85@sina.com','birthday':{'birthday':'19850101'},'regDate':'2015-07-07 11:35:08'}");
		HttpResponse res = req.send();
		String body = res.body();
		System.out.println(body);
		System.out.println(res.firstHeader("Server"));
		System.out.println(res);
	}
}
