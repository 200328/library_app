package com.group.libraryapp.temp;

import org.springframework.transaction.annotation.Transactional;

public class PersonService {
    private final AddressRepository addressRepository;
    private final PersonRepository personRepository;

    public PersonService(AddressRepository addressRepository, PersonRepository personRepository) {
        this.addressRepository = addressRepository;
        this.personRepository = personRepository;
    }

    @Transactional
    public void savePerson(){
        Person person = personRepository.save(new Person()); // Person 저장
        Address address = addressRepository.save(new Address()); // Address 저장
        person.setAddress(address); // 둘을 연결시켜준다
        //address.setPerson(person); // 연관관계의 주인 효과로 아무 일도 일어나지 않는다
    }
}
