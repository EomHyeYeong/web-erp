package controller;

import entity.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import repository.BookDAO;

import java.util.List;

@Controller // mvc-api, POJO 클래스임을 명시
public class BookController { // Spring Container (객체가 관리되는 메모리 공간)에 올라간다.
    // 책과 관련된 일을 하는 컨트롤러
    @RequestMapping("/bookList")
    public String list(Model model) { // spring: HttpServletRequest -> Model
        // 책 리스트 가져오기
        // View: list
        BookDAO dao = new BookDAO();
        List<Book> list = dao.bookList();
        model.addAttribute("list", list);
        return "list"; // View의 논리적인 이름 (list.jsp)
    }

    @GetMapping("/register") // GET - 등록화면
    public String registerGET() {
        return "register"; // forward
    }

    @PostMapping("/register") // POST - 등록
    public String registerPOST(Book book) { // 파라미터 수집 -> Book으로
        BookDAO dao = new BookDAO();
        dao.bookRegister(book);
        // 등로기 성공 다시 리스트로 가기
        return "redirect:/bookList"; // redirect
    }
}
