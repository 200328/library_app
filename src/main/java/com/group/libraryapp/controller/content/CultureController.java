package com.group.libraryapp.controller.content;

import com.group.libraryapp.dto.content.CultureUpdateRequest;
import com.group.libraryapp.dto.content.request.CultureCreateRequest;
import com.group.libraryapp.dto.content.response.CultureResponse;
import com.group.libraryapp.service.content.CultureService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CultureController {

    private final CultureService cultureService;

    public CultureController(CultureService cultureService) {
        this.cultureService = cultureService;
    }

    // 글 작성 및 저장 //
    @PostMapping("/culture")
    public void saveCulture(@RequestBody CultureCreateRequest request) {
        cultureService.saveCulture(request);
    }

    // 글 불러옴 //
    @GetMapping("/culture")
    public List<CultureResponse> getCulture() {
       return cultureService.getCulture();
    }

    // 평점 수정 //
    @PutMapping("/culture")
    public void updateRate(@RequestBody CultureUpdateRequest request) throws IllegalAccessException {
        cultureService.updateRate(request);
    }

    // 후기 수정 //
    @PutMapping("/culture")
    public void updateReview(@RequestBody CultureUpdateRequest request) throws IllegalAccessException {
        cultureService.updateReview(request);
    }
}
