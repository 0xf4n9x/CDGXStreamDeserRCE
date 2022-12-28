package com.cdg.utils;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;

import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;
import java.net.Proxy;
import java.net.URL;
import java.net.InetSocketAddress;

public class Http {
    public static Proxy getProxy(String proxyURL) throws MalformedURLException {
//        Proxy proxy = null;
        URL url = new URL(proxyURL);
        if (proxyURL.contains("http")) {
            return new Proxy(Proxy.Type.HTTP, new InetSocketAddress(url.getHost(),
                    url.getDefaultPort()));
        } else if (proxyURL.contains("socks")) {
            return new Proxy(Proxy.Type.SOCKS, new InetSocketAddress(url.getHost(),
                    url.getDefaultPort()));
        } else {
            return null;
        }
    }

    public static HttpResponse post(String url, String body, Map<String, String> headers,
                                    String proxyURL) throws MalformedURLException {
        HttpResponse result;
        result = HttpRequest.post(url)
                .headerMap(setHeaders(headers), true)
                .body(body)
                .setProxy(getProxy(proxyURL))
                .timeout(20000)
                .execute();
        return result;
    }

//    public static HttpResponse get(String url, Map<String, String> headers, String proxyURL) throws MalformedURLException {
//        HttpResponse result;
//        result = HttpRequest.get(url)
//                .headerMap(setHeaders(headers), true)
//                .setProxy(getProxy(proxyURL))
//                .timeout(20000)
//                .execute();
//        return result;
//    }

    private static Map<String, String> setHeaders(Map<String, String> headers) {
        Map<String, String> baseHeader = new HashMap<>();
        baseHeader.put("Accept", "*/*");
        baseHeader.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/99.0.4844.74 Safari/537.36");
        baseHeader.put("Connection", "close");

        if (headers != null) {
            // 当请求需要自定义 headers 时进行添加
            baseHeader.putAll(headers);
        }
        return baseHeader;
    }
}
