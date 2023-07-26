package com.group.libraryapp.service.book;

import com.group.libraryapp.domain.book.Book;
import com.group.libraryapp.domain.book.BookRepository;
import com.group.libraryapp.domain.user.User;
import com.group.libraryapp.domain.user.UserLoanHistory;
import com.group.libraryapp.domain.user.UserLoanHistoryRepository;
import com.group.libraryapp.domain.user.UserRepository;
import com.group.libraryapp.dto.book.BookCreateRequest;
import com.group.libraryapp.dto.book.BookLoanRequest;
import com.group.libraryapp.dto.book.BookReturnRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final UserRepository userRepository;
    private final UserLoanHistoryRepository userLoanHistoryRepository;
    // 위의 기능을 쓰려면 클래스가 필요. 클래스(함수)를 쓰려면 인스턴스화. 받아서 쓰려고 필드를 만듦

    public BookService(BookRepository bookRepository,
                       UserRepository userRepository,
                       UserLoanHistoryRepository userLoanHistoryRepository) {
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
        this.userLoanHistoryRepository = userLoanHistoryRepository;
    }

    @Transactional
    public void createNewBook(BookCreateRequest request){
        Book book = new Book(request.getName());
        bookRepository.save(book);
    }

    // 대출 정리 //
    // 1. 들어오는 책 이름으로 책을 찾음
    // 2. 들어오는 유저 이름으로 유저를 찾음
    // 3-1. 지금 빌리려는 책을 다른 사람이 빌린 건 아닌지 확인해서 빌렸다면 예외
    // 3-2. 빌릴 수 있는 책이면, UserLoanHistory 테이블에 데이터를 쌓아서 “대출 처리” 해줌

    @Transactional
    public void loanBook(BookLoanRequest request){
        //1. 책 찾기
        Book book = bookRepository.findByName(request.getBookName());
        if (book == null){
            throw new IllegalArgumentException();
        }

        //2. 유저 찾기
        User user = userRepository.findByName(request.getUserName());
        if (user == null){
            throw new IllegalArgumentException();
        }

        //3-1. 대출 중인 책이면 예외
        if (userLoanHistoryRepository.existsByBookNameAndIsReturn(request.getBookName(), false)){ //false: 반납되지 않았다
            throw new IllegalArgumentException(); // if true이면 대출중인 책이 있다는 것이니
        }

        //3-2. 대출 처리
        UserLoanHistory history = new UserLoanHistory(user.getId(),request.getBookName(),false);
        userLoanHistoryRepository.save(history);
    }

    // 반납 정리 //
    // 1. 들어오는 책을 찾는다.
    // 2. 들어오는 유저를 찾는다.
    // 3. 해당 대출 기록을 찾는다.
    // 4. 대출 기록의 is_return을 true로 바꿔준다.
    @Transactional
    public void returnBook(BookReturnRequest request){
        //1. 책 찾기
        Book book = bookRepository.findByName(request.getBookName());
        if (book == null){
            throw new IllegalArgumentException();
        }

        //2. 유저 찾기
        User user = userRepository.findByName(request.getUserName());
        if (user == null){
            throw new IllegalArgumentException();
        }

        //3. 대출 기록 찾기 (어떤 사람이 어떤 책을 빌렸을 때 그 기록을 가져오게끔)
        UserLoanHistory history = userLoanHistoryRepository.findByUserIdAndBookName(user.getId(), request.getBookName());
        if (history == null){
            throw new IllegalArgumentException();
        }
        // is_return -> true(반납처리)
        history.doReturn();
        //userLoanHistoryRepository.save(history); // Transactional 영속성으로 굳이 해주지는 않아도 됨!
    }

}
