package cn.jansen.get;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class GetDemo {
	
	private static final String GET_URL = "https://api.coinmarketcap.com/v2/ticker/1/?convert=CNY";
	private OkHttpClient client = null;
	private Request request = null;

	@Before
	public void setUp() throws Exception {
		client = new OkHttpClient();
		request = new Request.Builder().url(GET_URL).build();
	}

	@Test
	public void testGetDemo() throws IOException {
		Response response = client.newCall(request).execute();
		System.out.println(response.body().string());
	}

}
