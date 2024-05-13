package controller;

import service.MyService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/calc")
public class CalcController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 비즈니스 로직을 담당하는 부분
        // 클라이언트 폼에서 넘어온 파라미터(su1, su2)를 가져오기
        int su1 = Integer.parseInt(req.getParameter("su1"));
        int su2 = Integer.parseInt(req.getParameter("su2"));
        int sum = MyService.hap(su1, su2);

        // 프리젠테이션을 담당하는 부분 (-> controller에서 처리하지 말고 jsp에게 넘겨줘야 한다. VIEW->JSP)
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
        out.println("<td>"+sum+"</td>");
        out.println("</tr>");
        out.println("</table>");
        out.println("</body>");
        out.println("</html>");
    }
}
