package controller;

import entity.Book;
import repository.BookDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")
public class BookRegisterController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // title, price, author, page : form 파라미터 -> 받아서 DTO에 담기 (파라미터 수집), spring은 이를 자동 수집해준다.
        req.setCharacterEncoding("UTF-8");
        String title = req.getParameter("title");
        int price = Integer.parseInt(req.getParameter("price"));
        String author = req.getParameter("author");
        int page = Integer.parseInt(req.getParameter("page"));

        Book dto = new Book();
        dto.setTitle(title);
        dto.setPrice(price);
        dto.setAuthor(author);
        dto.setPage(page);

        // 수집 완료한 파라미터를 db 저장
        BookDAO dao = new BookDAO();
        int cnt = dao.bookRegister(dto);

        // 성공: 다시 리스트 페이지로 가기
        // 실패: 예외 발생

    }
}
