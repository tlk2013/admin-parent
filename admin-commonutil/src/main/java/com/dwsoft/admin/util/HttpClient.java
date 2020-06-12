package com.dwsoft.admin.util;

import java.io.IOException;
import java.net.URL;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ssl.DefaultHostnameVerifier;
import org.apache.http.conn.util.PublicSuffixMatcher;
import org.apache.http.conn.util.PublicSuffixMatcherLoader;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;



public class HttpClient {
	
	/*@Autowired
	private OrderService orderService;*/
	
	private RequestConfig requestConfig = RequestConfig.custom()
            .setSocketTimeout(15000)
            .setConnectTimeout(15000)
            .setConnectionRequestTimeout(15000)
            .build();
	
	
	
	/*public static void main(String[] args) throws UnsupportedEncodingException {
		
		String data = "";
		
		//data = invokeIsForwardHttpsPost();
		
		//data = invokeOrderHttpPost();
		
		//JSONObject userInfo = invokeUserInfoPost("18585012313");
		
		
		//System.out.println(userInfo);
	    
	    
	    JSONObject json = invokeLocalQueryOrderInfo("20190510221301196093","999999900510221301196107");
	    //JSONObject json = invokeUserInfoPost(mobile);
	    //invokeOrderFsrPost(mobile,cityCode,"1");
	}*/
	
	




    
    /**
     * 发送 get请求Https
     * @param httpUrl
     */
    public  String sendHttpsGet(String httpUrl) {
        HttpGet httpGet = new HttpGet(httpUrl);// 创建get请求
        return sendHttpsGet(httpGet);
    }
    
    /**
     * 发送Get请求Https
     * @param
     * @return
     */
    private  String sendHttpsGet(HttpGet httpGet) {
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse response = null;
        HttpEntity entity = null;
        String responseContent = null;
        try {
            // 创建默认的httpClient实例.
            PublicSuffixMatcher publicSuffixMatcher = PublicSuffixMatcherLoader.load(new URL(httpGet.getURI().toString()));
            DefaultHostnameVerifier hostnameVerifier = new DefaultHostnameVerifier(publicSuffixMatcher);
            httpClient = HttpClients.custom().setSSLHostnameVerifier(hostnameVerifier).build();
            httpGet.setConfig(requestConfig);
            // 执行请求
            response = httpClient.execute(httpGet);
            entity = response.getEntity();
            responseContent = EntityUtils.toString(entity, "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // 关闭连接,释放资源
                if (response != null) {
                    response.close();
                }
                if (httpClient != null) {
                    httpClient.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return responseContent;
    }

    public static void main(String[] args) {
        System.out.println(new HttpClient().sendHttpsGet("http://123.56.230.134:8080/marks/results?mid=10&date=2020-05-26"));
    }
    
    
}
