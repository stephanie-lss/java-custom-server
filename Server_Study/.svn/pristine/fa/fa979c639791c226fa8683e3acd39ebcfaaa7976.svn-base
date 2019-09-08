package study04.com.shsxt.user;

import study04.com.shsxt.server.core.Request;
import study04.com.shsxt.server.core.Response;
import study04.com.shsxt.server.core.Servlet;

public class RegisterServlet implements Servlet {
    @Override
    public void service(Request request, Response response) {
        //关注业务逻辑
        String[] favs = null;
        String uname = request.getParameter("uname");
        if ((favs = request.getParameterValues("fav")) != null) {
            response.print("<html>");
            response.print("<head>");
            response.print("<meta http-equiv=\"content-type\" content=\"text/html;charset=utf-8\">");
            response.print("<title>");
            response.print("注册成功");
            response.print("</title>");
            response.print("</head>");
            response.print("<body>");
            response.println("你注册的信息为:" + uname);
            response.println("你喜欢的类型为:");
            if (favs.length==1){
                for (String v : favs) {
                    if (v.equals("0")) {
                        response.print("萝莉型");
                    } else if (v.equals("1")) {
                        response.print("豪放型");
                    } else if (v.equals("2")) {
                        response.print("经济节约型");
                    }
                }
            }else {
                for (String v : favs) {
                    if (v.equals("0")) {
                        response.print("萝莉型 ");
                    } else if (v.equals("1")) {
                        response.print(" 豪放型 ");
                    } else if (v.equals("2")) {
                        response.print("经济节约型");
                    }
                }
            }

            response.print("</body>");
            response.print("</html>");
        } else {
            response.print("<html>");
            response.print("<head>");
            response.print("<meta http-equiv=\"content-type\" content=\"text/html;charset=utf-8\">");
            response.print("<title>");
            response.print("注册成功");
            response.print("</title>");
            response.print("</head>");
            response.print("<body>");
            response.println("你注册的信息为:" + uname);
            response.println("你没有喜欢的类型啊！");
        }


    }

}
