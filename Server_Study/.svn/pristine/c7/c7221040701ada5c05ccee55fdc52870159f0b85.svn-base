package study03.com.shsxt.server;

import java.io.IOException;
import java.net.Socket;

/**
 * @author LiSheng
 * @date 2019/7/13 12:27
 */
public class Dispatch1 implements Runnable {
    Socket client;
    Request request;
    Response response;

    public Dispatch1(Socket client) {
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
            Servlet servlet = WebApp.getServletFromUrl(request.getUrl());
            if (null != servlet) {
                servlet.service(request, response);
                //关注了状态码
                response.pushToBrowser(200);
            } else {
                //错误....
                response.pushToBrowser(404);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("客户端错误");
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
