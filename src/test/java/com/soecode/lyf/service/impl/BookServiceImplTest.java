package com.soecode.lyf.service.impl;

import static org.junit.Assert.fail;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.soecode.lyf.BaseTest;
import com.soecode.lyf.dto.AppointExecution;
import com.soecode.lyf.service.BookService;

public class BookServiceImplTest extends BaseTest {

	@Autowired
	private BookService bookService;

	@Test
	public void testAppoint() throws Exception {
		long bookId = 1001;
		long studentId = 12345678910L;
		AppointExecution execution = bookService.appoint(bookId, studentId);
		System.out.println(execution);
	}

	@Test
	public void testPage() throws Exception {
		System.out.println(bookService.getListByPage(1,2));
	}



}
