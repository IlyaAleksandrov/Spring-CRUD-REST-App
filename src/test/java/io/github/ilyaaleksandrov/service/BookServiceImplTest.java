package io.github.ilyaaleksandrov.service;

import io.github.ilyaaleksandrov.dao.BookDao;
import io.github.ilyaaleksandrov.model.Book;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.*;

public class BookServiceImplTest {

	@Mock
    BookDao dao;
	
	@InjectMocks
    BookServiceImpl employeeService;
	
	@Spy
	List<Book> books = new ArrayList<Book>();
	
	@BeforeClass
	public void setUp(){
		MockitoAnnotations.initMocks(this);
		books = getBookList();
	}

	@Test
	public void addBook(){
		doNothing().when(dao).addBook(any(Book.class));
		employeeService.addBook(any(Book.class));
		verify(dao, atLeastOnce()).addBook(any(Book.class));
	}

	@Test
	public void updateBook(){
		Book emp = books.get(0);
		when(dao.getBook(anyInt())).thenReturn(emp);
		employeeService.updateBook(emp);
		verify(dao, atLeastOnce()).getBook(anyInt());
	}

	@Test
	public void removeBook() {
		doNothing().when(dao).removeBook(anyInt());
		employeeService.removeBook(anyInt());
		verify(dao, atLeastOnce()).removeBook(anyInt());
	}

	@Test
	public void getBook(){
		Book emp = books.get(0);
		when(dao.getBook(anyInt())).thenReturn(emp);
		Assert.assertEquals(employeeService.getBook(emp.getId()),emp);
	}
	
	@Test
	public void listBooks(){
		when(dao.listBooks()).thenReturn(books);
		Assert.assertEquals(employeeService.listBooks(), books);
	}
	
	
	public List<Book> getBookList(){
		Book book1 = new Book();
		book1.setId(1);
		book1.setBookTitle("Don Quixote");
		book1.setPublishedIn(2014);
		book1.setBookAuthor("Miguel de Cervantes");
		
		Book book2 = new Book();
		book2.setId(2);
		book2.setBookTitle("War and Peace");
		book2.setPublishedIn(2017);
		book2.setBookAuthor("Leo Tolstoy");
		
		books.add(book1);
		books.add(book2);
		return books;
	}
	
}
