package repository;
// JDBC -> MyBatis -> Spring MyBatis -> Hibernate(ORM) -> JPA
// JDBC: Java 소스코드 + SQL -> 유지보수가 어렵다, 생산성이 떨어진다.

import entity.Book;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

public class BookDAO {
    private static SqlSessionFactory sqlSessionFactory;

    // API: SqlSessionFactoryBuilder -> config.xml을 분석 -> Connecton Pool(Connection(SqlSession): 5~7) 생성
    static{
        try{
            String resource = "mybatis-config/config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory =
                    new SqlSessionFactoryBuilder().build(inputStream);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    // CRUD Method
    public List<Book> bookList() {
        // SqlSession을 꺼내오기
        SqlSession session = sqlSessionFactory.openSession();

        // select * from book : SQL 전송 (BookMapper.xml)
        List<Book> list = session.selectList("bookList"); // sql의 id (메서드 이름으로 통일하는게 원칙)
        session.close(); // 반납
        return list;
    }

    public int bookRegister(Book book) {
        SqlSession session = sqlSessionFactory.openSession();
        int cnt = session.insert("bookRegister", book); // insert return type: int, 성공여부 반환
        session.commit(); // 완료(Insert, Delete, Update -> commit 필요)
        session.close();
        return cnt;
    }
}
