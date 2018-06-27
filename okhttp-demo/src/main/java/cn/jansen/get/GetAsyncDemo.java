package cn.jansen.get;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class GetAsyncDemo {

	private static final String GET_URL = "https://api.coinmarketcap.com/v2/ticker/1/?convert=CNY";
	private static OkHttpClient client = null;
	private static Request request = null;

	public static void main(String[] args) throws IOException {
		client = new OkHttpClient();
		request = new Request.Builder().url(GET_URL).build();
		
		client.newCall(request).enqueue(new Callback() {

			@Override
			public void onFailure(Call call, IOException e) {
				System.out.println("异常");
			}

			@Override
			public void onResponse(Call call, Response response) throws IOException {
				System.out.println(response.body().string());
			}

		});
	}

}
