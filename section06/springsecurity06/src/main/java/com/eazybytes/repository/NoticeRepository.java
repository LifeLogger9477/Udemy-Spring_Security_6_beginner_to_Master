package com.eazybytes.repository;

import com.eazybytes.model.Notice;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * author : ms.Lee
 * date   : 2024-04-11
 */
@Repository
public interface NoticeRepository extends CrudRepository<Notice, Long> {

  @Query (
      value = "from Notice n " +
          "where current_date() between noticeBegDt and noticeEndDt"
  )
  List<Notice> findAllActiveNotices();
}
