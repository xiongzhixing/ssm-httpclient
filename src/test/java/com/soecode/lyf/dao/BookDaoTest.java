package com.soecode.lyf.dao;

import com.soecode.lyf.BaseTest;
import com.soecode.lyf.entity.Book;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

public class BookDaoTest extends BaseTest {

	@Autowired
	private BookDao bookDao;

	@Test
	public void testQueryById() throws Exception {
		Book book = bookDao.selectByPrimaryKey(1000l);
		System.out.println(book);

		Example example = new Example(Book.class);
		example.createCriteria().andLike("name","数据");


		List<Book> list =  bookDao.selectByExample(example);
        System.out.println(list);

        System.out.println(bookDao.selectCount(new Book()));

        Book book1 = new Book(1l,"asd",123);
    }

	@Test
	public void testQueryAll() throws Exception {
		List<Book> books = bookDao.getListByPage();
		for (Book book : books) {
			System.out.println(book);
		}
	}

	@Test
	public void testReduceNumber() throws Exception {
		long bookId = 1000;
		int update = bookDao.reduceNumber(bookId);
		System.out.println("update=" + update);
	}

}
