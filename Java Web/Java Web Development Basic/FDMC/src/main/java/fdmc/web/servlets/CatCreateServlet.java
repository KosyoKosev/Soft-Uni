package fdmc.web.servlets;

import fdmc.util.HtmlReader;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/cats/create")
public class CatCreateServlet extends HttpServlet {

    private final static String CAT_CREATE_HTML_FILE_PATH =
            "D:\\Programirane\\SoftUni\\Java Web\\Java Web Development Basic\\Exercises\\FDMC\\src\\main\\resources\\views\\cat-create.html";

    private final HtmlReader htmlReader;

    @Inject
    public CatCreateServlet(HtmlReader htmlReader) {
        this.htmlReader = htmlReader;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println(this.htmlReader.readerHtmlFile(CAT_CREATE_HTML_FILE_PATH));
    }
}
