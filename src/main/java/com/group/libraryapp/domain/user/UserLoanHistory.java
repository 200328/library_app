package com.group.libraryapp.domain.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

// "A라는 책을 누군가 빌려갔는지" 확인
// bookName = "A"이고 is_return = false이면, A라는 책을 반납하지 않은 기록 = A 대출중
@Entity
public class UserLoanHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = null;
    private long userId;
    private String bookName;
    private boolean isReturn;

    public UserLoanHistory() {}

    public UserLoanHistory(long userId, String bookName, boolean isReturn) {
        this.userId = userId;
        this.bookName = bookName;
        this.isReturn = isReturn;
    }

    public void doReturn(){
        isReturn = true;
    }
}
