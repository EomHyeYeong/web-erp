package controller;

public class ViewResolver {
    public static String makeView(String view) { // view: 뷰의 이름
        return "WEB-INF/views/" + view + ".jsp";
    }
}
