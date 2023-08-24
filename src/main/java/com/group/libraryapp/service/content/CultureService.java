package com.group.libraryapp.service.content;


import com.group.libraryapp.domain.content.Culture;
import com.group.libraryapp.domain.content.CultureRepository;
import com.group.libraryapp.dto.content.CultureUpdateRequest;
import com.group.libraryapp.dto.content.request.CultureCreateRequest;
import com.group.libraryapp.dto.content.response.CultureResponse;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CultureService {

    private final CultureRepository cultureRepository;

    public CultureService(CultureRepository cultureRepository) {
        this.cultureRepository = cultureRepository;
    }

    // 글 작성 및 저장 //
    public void saveCulture(CultureCreateRequest request) {
        cultureRepository.save(new Culture(request.getTitle(), request.getRegister_date(), request.getType(), request.getRate(), request.getReview()));
        // save 메소드에 객체를 넣어주면 INSERT SQL문이 자동으로 날라감
    }

    // 글 조회 //
    public List<CultureResponse> getCulture() {
        List<Culture> cultures = cultureRepository.findAll(Sort.by(Sort.Direction.DESC, "id")); //내림차순 정렬
        return cultures.stream()
                .map(culture -> new CultureResponse(culture.getId(), culture.getTitle(), culture.getRegister_date(), culture.getType(), culture.getRate(), culture.getReview()))
                .collect(Collectors.toList());
        // findAll: 자동으로 sql을 날려서 해당 테이블에 있는 모든 데이터 갖고 옴
        // == select * from culture
    }

    public XXX getCultureStat() {


    }

    // 평점 수정 //
    public void updateRate(CultureUpdateRequest request){
        // select * from content where id = ?;
        // Optional<Culture>
        Culture culture = cultureRepository.findById(request.getId())  // 자바의 optional이 등장
                .orElseThrow(IllegalArgumentException::new);
                // 없는 경우 예외가 던져짐.
        culture.updateRate(request.getRate()); // 객체 업데이트,
        cultureRepository.save(culture);    // save 메서드 호출 -> 자동으로 update 됨.
    }

    // 후기 수정 //
    public void updateReview(CultureUpdateRequest request){
        // select * from content where id = ?;
        // Optional<Culture>
        Culture culture = cultureRepository.findById(request.getId())  // 자바의 optional이 등장
                .orElseThrow(IllegalArgumentException::new);

        culture.updateReview(request.getReview());
        cultureRepository.save(culture);
    }

}
