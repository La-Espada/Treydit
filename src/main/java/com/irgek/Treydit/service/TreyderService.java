package com.irgek.Treydit.service;

import com.irgek.Treydit.domain.*;
import com.irgek.Treydit.persistence.TreyderRepository;
import com.irgek.Treydit.service.Exception.ServiceException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.PersistenceException;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Transactional
public class TreyderService {

    private final TreyderRepository treyderRepository;
    private String CANNOT_BE_NULL = "cannot be null!";
    private String CANNOT_BE_EMPTY_OR_BLANK = "cannot be empty or blank!";
    private String CANNOT_BE_BLANK = "cannot be blank!";

    public Treyder createTreyder(Name name, Gender gender, String username, String email, LocalDate birthDate, Address address, Phonenumber phonenumber, String password, Role role,City city) {
        Treyder newTreyder = null;

        if (name == null) {
            throw new IllegalArgumentException("Name " + CANNOT_BE_NULL);
        } else if (name.getFirstname().isBlank() || name.getFirstname().isEmpty()) {
            throw new IllegalArgumentException("Firstname " + CANNOT_BE_EMPTY_OR_BLANK);
        } else if (name.getLastname().isBlank() || name.getLastname().isEmpty()) {
            throw new IllegalArgumentException("Lastname " + CANNOT_BE_EMPTY_OR_BLANK);
        } else if (name.getSubname().isBlank()) {
            throw new IllegalArgumentException("Subname " + CANNOT_BE_BLANK);
        } else if (gender == null) {
            throw new IllegalArgumentException("Gender " + CANNOT_BE_NULL);
        }
        else if(phonenumber == null){
            throw new IllegalArgumentException("Phonenumber " + CANNOT_BE_NULL);
        }
        else if (username.isBlank() || username.isEmpty()) {
            throw new IllegalArgumentException("Username " + CANNOT_BE_EMPTY_OR_BLANK);
        }
        else if (email.isBlank() || email.isEmpty()) {
            throw new IllegalArgumentException("Email " + CANNOT_BE_EMPTY_OR_BLANK);
        }
        else if(birthDate == null){
            throw new IllegalArgumentException("Birthdate " + CANNOT_BE_NULL);
        }
        else if (birthDate.isAfter(LocalDate.now())){
            throw new IllegalArgumentException("Birthdate cannot be in the future!");
        }
        else if(address == null){
            throw new IllegalArgumentException("Address " + CANNOT_BE_NULL);
        }
        else if (password.isBlank() || password.isEmpty()) {
            throw new IllegalArgumentException("Username " + CANNOT_BE_EMPTY_OR_BLANK);
        }
        else if(role == null){
            throw new IllegalArgumentException("Birthdate " + CANNOT_BE_NULL);
        }
        else if(city == null){
            throw new IllegalArgumentException("Birthdate " + CANNOT_BE_NULL);
        }
        try{
            var treyder = treyderRepository.findTreyderByUsername(username);
            if(treyder.isPresent()){
                return treyder.get();
            }
             newTreyder = Treyder.builder()
                     .name(name)
                    .gender(gender)
                    .username(username)
                    .email(email)
                    .birthDate(birthDate)
                    .address(address)
                    .phonenumber(phonenumber)
                    .password(password)
                    .role(role)
                    .city(city)
                     .build();
            return treyderRepository.save(newTreyder);
        }
        catch (PersistenceException pEx){
            throw ServiceException.cannotCreateEntity(newTreyder,pEx);

        }

    }

    public void deleteTreyder(Treyder treyder){
        treyderRepository.delete(treyder);
    }

    public Optional<Treyder> getTreyderbyId(Long id){
        return treyderRepository.findTreyderById(id);
    }

    public Optional<Treyder> getTreyderbyUsername(String username){
        return treyderRepository.findTreyderByUsername(username);
    }

    public List<Treyder> getTreyderbyFirstname(String firstname){
        return treyderRepository.getTreyderbyFirstname(firstname);
    }

    public List<Treyder> getTreyders(){
        return treyderRepository.findAll();
    }
}
