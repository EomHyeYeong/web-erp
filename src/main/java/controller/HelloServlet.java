package controller;

import service.MyService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/hello") // servlet mapping
public class HelloServlet extends HttpServlet {     // servlet: 웹에서 실행 가능한 클래스. HttpServlet 클래스를 상속한다.

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int hap = MyService.hap();

        // 응답시 한글 깨짐 처리
        resp.setContentType("text/html;charset=UTF-8"); // MIME Type, 한글 깨짐 처리

        // 클라이언트에 응답할 출력 스트림(빨대)을 만들어야 한다.
        PrintWriter out = resp.getWriter(); // 응답 스트림 생성

        // 1 ~ 10 까지의 총 합?
        // 어떻게? 1. 직접 구한다 2. 별도의 클래스에서 처리한다.(O, How? service 클래스를 이용)
        // <html> tag를 이용해서 응답 코드 작성
        out.println("<html>");
        out.println("<body>");
        out.println("<table border='1'>");
        out.println("<tr>");
        out.println("<td>총합</td>");
        out.println("<td>"+hap+"</td>");
        out.println("</tr>");
        out.println("</table>");
        out.println("</body>");
        out.println("</html>");
    }
}
