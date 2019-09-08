package study03.com.shsxt.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 目标: 整合配置文件
 *
 * @author 裴新 QQ:3401997271
 */
public class Server08 {
    private ServerSocket serverSocket;
    private Boolean isRunning;
    public static void main(String[] args) {
        Server08 server = new Server08();
        server.start();
    }

    //启动服务
    public void start() {
        try {
            serverSocket = new ServerSocket(8888);
            isRunning = true;
            receive();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("服务器启动失败....");
        }
    }

    //接受连接处理
    public void receive() {
        while (isRunning){
            try {
                Socket client = serverSocket.accept();
                System.out.println("一个客户端建立了连接....");
                new Thread(new Dispatch1(client)).start();
            }catch (Exception e){
                e.printStackTrace();
                System.out.println("客服端错误！");
            }
        }
    }

    //停止服务
    public void stop() {
        isRunning = false;
        try {
            serverSocket.close();
            System.out.println("服务器已停止！");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
