package com.group.libraryapp.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserLoanHistoryRepository extends JpaRepository<UserLoanHistory, Long> {

    //existBy : 그 값이 있는지 없는지 알려줌. 주어진 책 이름이 같고 isReturn이 같은 값
    // select * from user_loan_history where book_name = ? and is_return = ?;
    boolean existsByBookNameAndIsReturn(String bookName, boolean isReturn);

    // A유저가 B책을 빌린 기록 -> select * from user_loan_history where user_id = ? and book_name =?;
    UserLoanHistory findByUserIdAndBookName(long userId, String bookName);


}
