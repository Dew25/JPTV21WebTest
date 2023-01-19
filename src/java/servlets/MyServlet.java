/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import entity.Author;
import entity.Book;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Melnikov
 */
@WebServlet(name = "MyServlet", urlPatterns = {"/pageJsp2","/pageJsp1","/book"})
public class MyServlet extends HttpServlet {
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        if("/pageJsp1".equals(request.getServletPath())){
            request.setAttribute("info", "Эта информация передана из Java в jsp страницу");
            request.getRequestDispatcher("/pageJsp1.jsp").forward(request, response);
        }else
        if("/pageJsp2".equals(request.getServletPath())){
            request.setAttribute("info", "Эта информация передана из Java в jsp страницу");
            request.getRequestDispatcher("/WEB-INF/pageJsp2.jsp").forward(request, response);
        }else
        if("/book".equals(request.getServletPath())){
            Author author = new Author();
            author.setFirstname("Лев");
            author.setLastname("Толстой");
            List<Author> authors = new ArrayList<>();
            authors.add(author);
            Book book = new Book();
            book.setName("Война и мир");
            book.setAuthors(authors);
            book.setPublishedYear(2010);
            book.setQuantity(3);
            book.setCount(3);
            List<Book> books = new ArrayList<>();
            books.add(book);
            author.setBooks(books);
            request.setAttribute("book", book);
            request.getRequestDispatcher("/book.jsp").forward(request, response);
        }
    }
  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
