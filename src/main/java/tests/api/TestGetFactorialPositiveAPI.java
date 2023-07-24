package tests.api;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestGetFactorialPositiveAPI {

    @Test
    public void TestGetFactorialPositiveAPI() throws ClientProtocolException, IOException {
        HttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost("http://192.168.8.45:6464/factorial");
        List nameValuePairs = new ArrayList(1);
        nameValuePairs.add(new BasicNameValuePair("number", "7"));
        post.setEntity(new UrlEncodedFormEntity(nameValuePairs));
        HttpResponse response = client.execute(post);
        BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        String line = "";
        while ((line = rd.readLine()) != null) {
            System.out.println(line);
            System.out.println(line.contains("5040"));
            if(line.contains("5040")){
                System.out.println("Test Passed: Response Object Contains The Expected Value: " +line.contains("5040"));
            }
        }

    }
}