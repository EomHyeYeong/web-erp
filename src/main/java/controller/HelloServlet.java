package controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HelloServlet extends HttpServlet {     // servlet: 웹에서 실행 가능한 클래스. HttpServlet 클래스를 상속한다.

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // <html> tag를 이용해서 응답 코드 작성
    }
}
