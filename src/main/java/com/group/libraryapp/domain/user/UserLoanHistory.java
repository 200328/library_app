package com.group.libraryapp.domain.user;

import javax.persistence.*;

// "A라는 책을 누군가 빌려갔는지" 확인
// bookName = "A"이고 is_return = false이면, A라는 책을 반납하지 않은 기록 = A 대출중
@Entity
public class UserLoanHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = null;
    @ManyToOne
    private User user;
    private String bookName;
    private boolean isReturn;

    protected UserLoanHistory() {}

    public UserLoanHistory(User user, String bookName) {
        this.user = user;
        this.bookName = bookName;
        this.isReturn = false;
    }

    public void doReturn(){
        isReturn = true;
    }

    public String getBookName() {
        return this.bookName;
    }
}
