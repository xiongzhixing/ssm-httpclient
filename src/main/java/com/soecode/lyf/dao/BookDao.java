package com.soecode.lyf.dao;

import com.soecode.lyf.entity.Book;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface BookDao extends Mapper<Book> {

	/**
	 * 查询所有图书
	 * @return
	 */
	List<Book> getListByPage();

	/**
	 * 减少馆藏数量
	 * 
	 * @param bookId
	 * @return 如果影响行数等于>1，表示更新的记录行数
	 */
	int reduceNumber(long bookId);

}
