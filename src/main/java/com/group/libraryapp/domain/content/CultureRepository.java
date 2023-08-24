package com.group.libraryapp.domain.content;

import com.group.libraryapp.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CultureRepository extends JpaRepository<Culture, Long>{

    // SQL group by 검색 ㄱㄱㄱ
    // JPA Query group by 검색 ㄱㄱㄱ
    // @Query("SELECT Culture c FROM Culture GROUP BY type")

}
