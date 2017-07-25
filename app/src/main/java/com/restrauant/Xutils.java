package com.restrauant;

import android.util.Log;

import org.codehaus.jackson.jaxrs.JacksonJsonProvider;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by duanbiwei on 2016/11/4.
 */
public class Xutils {
    private static final String AFTERCHARGEURL = "http://221.208.198.45:900/ChatOnline/rest/order/addbill";
    public static final String OPENID = "JHf30dcbe21a66042bb156367a47f02117";
    public static String Post(String targetURL) {
        URL url;
        HttpURLConnection connection = null;
        try {
            url = new URL(targetURL);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setUseCaches(false);
            connection.setDoOutput(true);
            connection.setRequestProperty("charset", "utf-8");
            connection.setRequestProperty("Content-Type","application/json");
            connection.connect();
            int HttpResult = connection.getResponseCode();
            Log.d("POSTCODE", "=================== " + HttpResult + " ===================");
            if(HttpResult == HttpURLConnection.HTTP_OK){
                Log.d("Post", "succeed++++++++++++++++++++++++++++++");
                InputStream in = connection.getInputStream();
                String resultData = null;      //存储处理结果
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] data = new byte[1024];
                int len = 0;
                try {
                    while((len = in.read(data)) != -1) {
                        byteArrayOutputStream.write(data, 0, len);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                resultData = new String(byteArrayOutputStream.toByteArray());
                return resultData;
            }else if (HttpResult == HttpURLConnection.HTTP_BAD_METHOD){
                Log.e("+++++++post+++++++", "===========timeout!=========");
            }
            else{
                Log.d("Post", connection.getResponseMessage());
            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection != null)
            connection.disconnect();
        }
        return null;
    }

    public static void Get(String targetUrl) {
        URL url;
        HttpURLConnection connection = null;
        try {
            url = new URL(targetUrl);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setDoOutput(true);
            connection.setUseCaches(false);
            InputStream ins = url.openStream();
            byte[] buf = new byte[1024];
            long total = 0;
            int count;
            while((count = ins.read(buf)) != -1) {// logcat提示问题出现在这里
                total += count;
            }
            ins.close();
            Log.d("GET++++=====","============ " + total + "=============");
            int HttpResult = connection.getResponseCode();
            if (HttpResult == HttpURLConnection.HTTP_OK) {
                Log.d("GET", "===================succeed++++++=========");
            } else {
                Log.e("GEt", connection.getResponseMessage());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }

    public static String POST(String url, Map<String, Object> map) {

        Client client = ClientBuilder.newClient().register(JacksonJsonProvider.class);
        WebTarget target = client.target(url);
        Response response = target.request().buildPost(Entity.entity(map, MediaType.APPLICATION_JSON)).invoke();
        String json = response.readEntity(String.class);
        if(json.contains("提交成功")) {
            Log.d("POST++++++++++++", "==============succeed============");
        }
        Log.d("POST++++++++++++", json);
        response.close();
        return json;
    }

    public static String PostWithPlain(String url, Map<String, Object> map) {
        Client client = ClientBuilder.newClient().register(JacksonJsonProvider.class);
        WebTarget target = client.target(url);
        Response response = target.request().buildPost(Entity.entity(map, MediaType.TEXT_PLAIN_TYPE)).invoke();
        String json = response.readEntity(String.class);
        if(json.contains("提交成功")) {
            Log.d("POST++++++++++++", "==============succeed============");
        }
        Log.d("POST++++++++++++", json);
        response.close();
        return json;
    }
    public static String GET(String url) {
        System.out.println("addUser");

        Client client = ClientBuilder.newClient().register(JacksonJsonProvider.class);
        WebTarget target = client.target(url);
        Response response = target.request(MediaType.APPLICATION_JSON).get();
        String json = response.readEntity(String.class);
        if(json.contains("提交成功")) {
            Log.d("POST++++++++++++", "==============succeed============");
        }
        Log.d("POST++++++++++++", json);
        response.close();
        return json;
    }

    public static boolean checkPhone(String phone) {
        Pattern pattern = Pattern
                .compile("^(13[0-9]|15[0-9]|153|15[6-9]|180|18[23]|18[5-9])\\d{8}$");
        Matcher matcher = pattern.matcher(phone);

        if (matcher.matches()) {
            return true;
        }
        return false;
    }

    public static void PostCostDetails(Map<String, Object> map) {
        POST(AFTERCHARGEURL, map);
    }

    public static String buildOrderid(Date createDate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        StringBuilder out  = new StringBuilder(dateFormat.format(createDate));
        dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String strdate = dateFormat.format(createDate);// 2011-07-10
        Date date = createDate;
        try {
            date = dateFormat.parse(strdate);
        } catch (ParseException e) {e.printStackTrace();}
        return out.toString();
    }
    public static String get1(String url) {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(url);

        Response response = target.request().get();
        String json = response.readEntity(String.class);
        System.out.println(json);
        response.close();

        client = ClientBuilder.newClient();
        target = client.target(url);

        response = target.request().get();
        json = response.readEntity(String.class);
        return json;
    }
}
