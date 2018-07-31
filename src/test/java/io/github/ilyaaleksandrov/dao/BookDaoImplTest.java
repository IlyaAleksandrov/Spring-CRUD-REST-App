package io.github.ilyaaleksandrov.dao;

import io.github.ilyaaleksandrov.model.Book;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;


public class BookDaoImplTest extends EntityDaoImplTest{

	@Autowired
    BookDao bookDao;

	@Override
	protected IDataSet getDataSet() throws Exception{
		IDataSet dataSet = new FlatXmlDataSet(this.getClass().getClassLoader().getResourceAsStream("Book.xml"));
		return dataSet;
	}


	@Test
	public void addBook(){
		bookDao.addBook(getSampleBook());
		Assert.assertEquals(bookDao.listBooks().size(), 3);
	}

	@Test
	public void updateBook(){
		bookDao.updateBook(getSampleBook());
		Assert.assertEquals(bookDao.getBook(0).getBookTitle(), "Moby Dick");
	}

	@Test
	public void removeBook(){
		bookDao.removeBook(1);
		Assert.assertEquals(bookDao.listBooks().size(), 1);
	}

	@Test
	public void getBook(){
		Assert.assertNotNull(bookDao.getBook(1));
	}

	@Test
	public void listBooks(){
		Assert.assertEquals(bookDao.listBooks().size(), 2);
	}


	public Book getSampleBook(){
		Book book = new Book();
		book.setBookTitle("Moby Dick");
		book.setPublishedIn(2008);
		book.setBookAuthor("Herman Melville");
		return book;
	}

}
