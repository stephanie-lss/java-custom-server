package study02.com.shsxt.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 目标: 封装请求信息中参数转成map
 * 
 * @author 裴新 QQ:3401997271
 *
 */
public class Server05 {
	private ServerSocket serverSocket ;
	public static void main(String[] args) {
		Server05 server = new Server05();
		server.start();
	}
	//启动服务
	public void start() {
		try {
			serverSocket =  new ServerSocket(8888);
			 receive();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("服务器启动失败....");
		}
	}
	//接受连接处理
	public void receive() {
		try {
			Socket client = serverSocket.accept();
			System.out.println("一个客户端建立了连接....");
			//获取请求协议
			Request2 request =new Request2(client);
			
			Response response =new Response(client);
			//关注了内容
			response.print("<html>"); 
			response.print("<head>"); 
			response.print("<title>");
			response.print("服务器响应成功");
			response.print("</title>");
			response.print("</head>");
			response.print("<body>");
			response.print("shsxt server终于回来了。。。。"+request.getParameter("uname"));
			response.print("</body>");
			response.print("</html>");
			//关注了状态码
			response.pushToBrowser(200);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("客户端错误");
		}
	}
	//停止服务
	public void stop() {
		
	}
}
