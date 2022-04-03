package com.irgek.Treydit.service;

import com.irgek.Treydit.domain.*;
import com.irgek.Treydit.foundation.TemporalValueFactory;
import com.irgek.Treydit.persistence.TreyderRepository;
import com.irgek.Treydit.service.Exception.ServiceException;
import com.irgek.Treydit.service.dto.MutateTreyderCommand;
import com.irgek.Treydit.service.dto.TreyderDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.PersistenceException;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Transactional
public class TreyderService {

    private final TreyderRepository treyderRepository;
    private final TemporalValueFactory temporalValueFactory;

    private String CANNOT_BE_NULL = "cannot be null!";
    private String CANNOT_BE_EMPTY_OR_BLANK = "cannot be empty or blank!";
    private String CANNOT_BE_BLANK = "cannot be blank!";

    public Treyder createTreyder(MutateTreyderCommand mutateTreyderCommand) {
        Treyder newTreyder = null;
        LocalDateTime created = temporalValueFactory.created_at();

        /*
        if (firstname == null) {
            throw new IllegalArgumentException("Name " + CANNOT_BE_NULL);
        } else if (firstname.isBlank() || firstname.isEmpty()) {
            throw new IllegalArgumentException("Firstname " + CANNOT_BE_EMPTY_OR_BLANK);
        } else if (lastname == null) {
            throw new IllegalArgumentException("Name " + CANNOT_BE_NULL);
        }
        else if (lastname.isBlank() || lastname.isEmpty()) {
            throw new IllegalArgumentException("Lastname " + CANNOT_BE_EMPTY_OR_BLANK);
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
            throw new IllegalArgumentException("Role " + CANNOT_BE_NULL);
        }
        else if(city == null){
            throw new IllegalArgumentException("City " + CANNOT_BE_NULL);
        }
        */
        try{
            var treyder = treyderRepository.findTreyderByUsername(mutateTreyderCommand.username);
            if(treyder.isPresent()){
                return treyder.get();
            }
             newTreyder = Treyder.builder()
                     .firstname(mutateTreyderCommand.getFirstname())
                     .lastname(mutateTreyderCommand.getLastname())
                    .gender(mutateTreyderCommand.getGender())
                    .username(mutateTreyderCommand.getUsername())
                    .email(mutateTreyderCommand.getEmail())
                    .birthDate(mutateTreyderCommand.getBirthDate())
                    .address(mutateTreyderCommand.getAddress())
                    .phonenumber(mutateTreyderCommand.getPhonenumber())
                    .password(mutateTreyderCommand.getPassword())
                    .role(mutateTreyderCommand.getRole())
                     .created(created)
                    .city(mutateTreyderCommand.getCity())
                     .build();
            return treyderRepository.save(newTreyder);
        }
        catch (PersistenceException pEx){
            throw ServiceException.cannotCreateEntity(newTreyder,pEx);

        }

    }

    public Treyder createTreyderFromDto(TreyderDto treyderDto) {
        Treyder newTreyder = null;
        LocalDateTime created = temporalValueFactory.created_at();

        try{
            var treyder = treyderRepository.findTreyderByUsername(treyderDto.username());
            if(treyder.isPresent()){
                return treyder.get();
            }
            newTreyder = Treyder.builder()
                    .firstname(treyderDto.firstname())
                    .lastname(treyderDto.lastname())
                    .gender(treyderDto.gender())
                    .username(treyderDto.username())
                    .email(treyderDto.email())
                    .birthDate(treyderDto.birthDate())
                    .address(treyderDto.address())
                    .phonenumber(treyderDto.phonenumber())
                    .password(treyderDto.password())
                    .created(created)
                    .role(treyderDto.role())
                    .city(treyderDto.city())
                    .build();
            return treyderRepository.save(newTreyder);
        }
        catch (PersistenceException pEx){
            throw ServiceException.cannotCreateEntity(newTreyder,pEx);

        }

    }

    public Treyder replaceTreyder(Long id, MutateTreyderCommand mutateTreyderCommand){
        Optional<Treyder> treyder = treyderRepository.findTreyderById(id);
        Treyder treyder1 = null;
        LocalDateTime  created = temporalValueFactory.replaced_at();

        return treyder1;
    }



    public Treyder save(Treyder treyder){
         return treyderRepository.save(treyder);
    }

    public void deleteTreyder(Treyder treyder){
        treyderRepository.delete(treyder);
    }

    public void deleteTreyders(){
        treyderRepository.deleteAll();
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
