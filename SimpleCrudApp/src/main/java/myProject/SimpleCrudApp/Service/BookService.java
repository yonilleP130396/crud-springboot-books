package myProject.SimpleCrudApp.Service;

import myProject.SimpleCrudApp.Model.Book;
import java.util.List;

public interface BookService {
    List<Book> getAllBooks();
    Book getBookById(Long id);
    Book saveBook(Book book);
    void deleteBook(Long id);
}