package controller;

import entity.Book;
import repository.BookDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/bookList")
public class BookListController extends HttpServlet {
    // GET  : doGet()   >> @GetMapping()
    // POST : doPost()  >> @PostMapping()
    // GET, POST : service()

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // req, resp : 요청을 보낸 client의 정보가 포함되어 있다.

        // Database(DAO)에서 책 목록을 가져오기: List -> ArrayList
//        List<Book> list = new ArrayList<Book>();
//        list.add(new Book(1, "자바1", 12000, "홍길동", 500));
//        list.add(new Book(2, "자바2", 13000, "박길동", 600));
//        list.add(new Book(3, "자바3", 14000, "이길동", 700));

        BookDAO dao = new BookDAO();
        List<Book> list = dao.bookList();
        req.setAttribute("list", list); // 객체 바인딩(연결) ⭐️⭐️⭐️ 문자 "list"에 list 객체의 주소값을 담는다.

        // view(jsp)와 연동하기 (= forward, dispatcher)
        // 요청 의뢰 객체(RequestDispatcher)를 얻어오는 방법
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/list.jsp"); // s: 요청을 의뢰할 대상
        rd.forward(req, resp);  // client의 요청을 처리하기 위해 jsp에 req와 resp를 그대로 넘겨줘야 한다.
    }
}