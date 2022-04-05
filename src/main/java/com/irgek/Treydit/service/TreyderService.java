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

        try{
            var treyder = treyderRepository.findTreyderByUsername(mutateTreyderCommand.getUsername());
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
        LocalDateTime  updated = temporalValueFactory.replaced_at();
        Treyder treyder1 = null;
        if(treyder.isPresent()){
            treyder1 = treyder.get();
        }
        try{
            treyder1.setFirstname(mutateTreyderCommand.getFirstname());
            treyder1.setLastname(mutateTreyderCommand.getLastname());
            treyder1.setAddress(mutateTreyderCommand.getAddress());
            treyder1.setBirthDate(mutateTreyderCommand.getBirthDate());
            treyder1.setCity(mutateTreyderCommand.getCity());
            treyder1.setEmail(mutateTreyderCommand.getEmail());
            treyder1.setGender(mutateTreyderCommand.getGender());
            treyder1.setPhonenumber(mutateTreyderCommand.getPhonenumber());
            treyder1.setPassword(mutateTreyderCommand.getPassword());
            treyder1.setUpdated(updated);
            return treyderRepository.save(treyder1);
        }
        catch(PersistenceException ex){
            throw ServiceException.cannotUpdateEntity(treyder1,ex);
        }
    }

    public Treyder paritallyUpdate(Long id, MutateTreyderCommand mutateTreyderCommand){
        Optional<Treyder> entity = treyderRepository.findTreyderById(id);
        LocalDateTime partiallyUpdated = temporalValueFactory.replaced_at();
        Treyder treyder = null;

        if(entity.isPresent()) {
            treyder = entity.get();
            if (mutateTreyderCommand.getFirstname() != null) {
                treyder.setFirstname(mutateTreyderCommand.getFirstname());
            }
            if (mutateTreyderCommand.getLastname() != null) {
                treyder.setLastname(mutateTreyderCommand.getLastname());
            }
            if (mutateTreyderCommand.getAddress() != null) {
                treyder.setAddress(mutateTreyderCommand.getAddress());
            }
            if (mutateTreyderCommand.getBirthDate() != null) {
                treyder.setCity(mutateTreyderCommand.getCity());
            }
            if (mutateTreyderCommand.getGender() != null) {
                treyder.setGender(mutateTreyderCommand.getGender());
            }
            if (mutateTreyderCommand.getPassword() != null) {
                treyder.setPassword(mutateTreyderCommand.getPassword());
            }
            if (mutateTreyderCommand.getPhonenumber() != null) {
                treyder.setPhonenumber(mutateTreyderCommand.getPhonenumber());
            }
            treyder.setUpdated(partiallyUpdated);
            return treyderRepository.save(treyder);
        }
        return entity.get();
    }


    public Treyder save(Treyder treyder){
         return treyderRepository.save(treyder);
    }

    public void deleteTreyder(Long id){
        Treyder treyder = null;
        Optional<Treyder> entity = treyderRepository.findTreyderById(id);
        try{
            if(entity.isPresent()){
                treyder = entity.get();
                treyderRepository.delete(treyder);
            }
        }catch(PersistenceException ex){
            throw ServiceException.cannotDeleteEntity(treyder,ex);
        }
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
