package com.group.libraryapp.controller.hospital;

import com.group.libraryapp.dto.hospital.AnimalCardCreateRequest;
import com.group.libraryapp.dto.hospital.AnimalCardResponse;
import com.group.libraryapp.service.hospital.AnimalCardService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AnimalCardController {

    private final AnimalCardService animalCardService;

    public AnimalCardController(AnimalCardService animalService) {
        this.animalCardService = animalService;
    }

    @PostMapping("/animal-card")
    public void saveAnimal(@RequestBody AnimalCardCreateRequest request){
        animalCardService.createNew(request);
    }

    @GetMapping("/animal-card")
    public List<AnimalCardResponse> findAll(){
        return animalCardService.findAll();
    }

}
