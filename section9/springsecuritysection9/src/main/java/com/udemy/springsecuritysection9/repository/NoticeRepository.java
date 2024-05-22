package com.udemy.springsecuritysection9.repository;

import com.udemy.springsecuritysection9.model.Notices;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoticeRepository extends CrudRepository<Notices, Integer> {
	
	@Query(value = "from Notices n where CURDATE() BETWEEN noticeBegDt AND noticeEndDt")
	List<Notices> findAllActiveNotices();

}