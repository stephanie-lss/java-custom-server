package study03.com.shsxt.server;

import java.io.*;
import java.net.Socket;

/**
 * @author LiSheng
 * @date 2019/7/13 12:27
 */
public class Dispatch2 implements Runnable {
    Socket client;
    Request request;
    Response response;
    BufferedReader br;

    public Dispatch2(Socket client) {
        this.client = client;
        try {
            //获取响应协议
            response = new Response(client);
            //获取请求协议
            request = new Request(client);
        } catch (Exception e) {
            e.printStackTrace();
            release();
        }
    }

    @Override
    public void run() {
        try {
            if (null == request.getUrl() || request.getUrl().equals("")) {
                br = new BufferedReader(new InputStreamReader(Thread.currentThread().getContextClassLoader().getResourceAsStream("study03/index.html")));
                StringBuilder sb = new StringBuilder();
                String line = null;
                while ((line = br.readLine()) != null) {
                    sb.append(line + "\n");
                }
                response.print(sb.toString());
                response.pushToBrowser(200);
                br.close();
                release();
            }
            Servlet servlet = WebApp.getServletFromUrl(request.getUrl());
            if (null != servlet) {
                servlet.service(request, response);
                //关注了状态码
                response.pushToBrowser(200);
            } else {
                //错误....
                br = new BufferedReader(new InputStreamReader(Thread.currentThread().getContextClassLoader().getResourceAsStream("study03/error.html")));
                StringBuilder sb = new StringBuilder();
                String line = null;
                while ((line = br.readLine()) != null) {
                    sb.append(line + "\n");
                }
                response.print(sb.toString());
                br.close();
                response.pushToBrowser(404);
            }
        } catch (IOException e) {
            try {
                response.print("你好我不好，我会马上好！");
                response.pushToBrowser(500);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        release();
    }

    private void release() {
        try {
            client.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}
