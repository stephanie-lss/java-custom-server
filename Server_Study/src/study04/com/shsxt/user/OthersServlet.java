package study04.com.shsxt.user;

import study04.com.shsxt.server.core.Request;
import study04.com.shsxt.server.core.Response;
import study04.com.shsxt.server.core.Servlet;

public class OthersServlet implements Servlet {

	@Override
	public void service(Request request, Response response) {
		response.print("<html>");
		response.print("<head>");
		response.print("<meta http-equiv=\"content-type\" content=\"text/html;charset=utf-8\">");
		response.print("<title>");
		response.print("其他页面");
		response.print("</title>");
		response.print("</head>");
		response.print("<body>");
		response.print("还在开发中，敬请期待。。。");
		response.print("</body>");
		response.print("</html>");
	}

}
