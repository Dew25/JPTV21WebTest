/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import entity.Author;
import entity.Book;
import entity.Reader;
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
@WebServlet(name = "MyServlet", urlPatterns = {
    "/pageJsp1",
    "/pageJsp2",
    "/books",
    "/reader",
    
})
public class MyServlet extends HttpServlet {
    
   private List<Book> books = new ArrayList<>();
  
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
        if("/books".equals(request.getServletPath())){
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
            Book book1 = new Book();
            book1.setName("12 стульев");
            book1.setCount(2);
            book1.setQuantity(2);
            book1.setPublishedYear(2022);
            Author author1 = new Author();
            author1.setFirstname("Илья");
            author1.setLastname("Ильф");
            Author author2 = new Author();
            author2.setLastname("Петров");
            author2.setFirstname("Евгений");
            book1.getAuthors().add(author1);
            book1.getAuthors().add(author2);
            author1.getBooks().add(book1);
            author2.getBooks().add(book1);
            books.add(book1);
            request.setAttribute("books", books);
            request.getRequestDispatcher("/listBooks.jsp").forward(request, response);
        }else
        if("/reader".equals(request.getServletPath())){
            Reader reader = new Reader();
            reader.setFirstname("Иван");
            reader.setLastname("Иванов");
            reader.setPhone("5665564565");
            request.setAttribute("reader", reader);
            request.getRequestDispatcher("/reader.jsp").forward(request, response);
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
