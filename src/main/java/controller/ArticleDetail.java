package main.java.controller;

import main.java.dao.ArticleDAO;
import main.java.dao.impl.ArticleDAOImpl;
import main.java.dto.ArticleDetailDTO;
import main.java.dto.MovieDetailDTO;
import main.java.service.ArticleSevrvices;
import main.java.service.impl.ArticleServicesImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Article Detail", value = "/article-detail")
public class ArticleDetail extends HttpServlet {
    private ArticleSevrvices articleSevrvices;

    @Override
    public void init() {
        ArticleDAO articleDAO = new ArticleDAOImpl();

        this.articleSevrvices = new ArticleServicesImpl(articleDAO);
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        try{
            String idRaw = request.getParameter("id");

            if (idRaw != null && !idRaw.isEmpty()) {
                int articleId = Integer.parseInt(idRaw);
                ArticleDetailDTO article = articleSevrvices.getArticleById(articleId);

                if (article != null) {
                    request.setAttribute("article", article);
                    request.getRequestDispatcher("/views/article-detail.jsp").forward(request, response);
                } else {
                    response.sendRedirect(request.getContextPath() + "/home");
                }
            } else {
                response.sendRedirect(request.getContextPath() + "/home");
            }
        } catch(NumberFormatException e){
            response.sendRedirect(request.getContextPath() + "/home");
        }
    }
}
