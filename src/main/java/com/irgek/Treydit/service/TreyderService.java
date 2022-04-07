package com.irgek.Treydit.service;

import com.irgek.Treydit.domain.*;
import com.irgek.Treydit.foundation.TemporalValueFactory;
import com.irgek.Treydit.persistence.TreyderRepository;
import com.irgek.Treydit.presentation.api.registration.token.ConfirmationToken;
import com.irgek.Treydit.presentation.api.registration.token.ConfirmationTokenService;
import com.irgek.Treydit.service.Exception.ServiceException;
import com.irgek.Treydit.service.dto.MutateTreyderCommand;
import com.irgek.Treydit.service.dto.TreyderDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.PersistenceException;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
@Transactional
public class TreyderService implements UserDetailsService {

    private final TreyderRepository treyderRepository;
    private final TemporalValueFactory temporalValueFactory;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final ConfirmationTokenService confirmationTokenService;

    private String CANNOT_BE_NULL = "cannot be null!";
    private String CANNOT_BE_EMPTY_OR_BLANK = "cannot be empty or blank!";
    private String CANNOT_BE_BLANK = "cannot be blank!";

    public Treyder createTreyder(MutateTreyderCommand mutateTreyderCommand) {
        Treyder newTreyder = null;
        LocalDateTime created = temporalValueFactory.created_at();

        try{
            var treyder = treyderRepository.findTreyderByEmail(mutateTreyderCommand.getEmail());
            if(treyder.isPresent()){
                return treyder.get();
            }
             newTreyder = Treyder.builder()
                     .firstname(mutateTreyderCommand.getFirstname())
                     .lastname(mutateTreyderCommand.getLastname())
                    .gender(mutateTreyderCommand.getGender())
                    //.username(mutateTreyderCommand.getUsername())
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
            var treyder = treyderRepository.findTreyderByEmail(treyderDto.email());
            if(treyder.isPresent()){
                return treyder.get();
            }
            newTreyder = Treyder.builder()
                    .firstname(treyderDto.firstname())
                    .lastname(treyderDto.lastname())
                    .gender(treyderDto.gender())
                    //.username(treyderDto.username())
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

    /*public Optional<Treyder> getTreyderbyUsername(String username){
        return treyderRepository.findTreyderByUsername(username);
    }

     */

    public List<Treyder> getTreyderbyFirstname(String firstname){
        return treyderRepository.getTreyderbyFirstname(firstname);
    }

    public List<Treyder> getTreyders(){
        return treyderRepository.findAll();
    }

    private static final String CANNOT_FIND_USER_BY_EMAIL ="Cannot find the user by email!";

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return treyderRepository.findTreyderByEmail(email)
                .orElseThrow(()->
                        new UsernameNotFoundException(String.format(CANNOT_FIND_USER_BY_EMAIL,email)));
    }


    public String signUpTreyder(Treyder treyder){
    boolean treyderExists = treyderRepository.findTreyderByEmail(treyder.getEmail())
             .isPresent();
            if(treyderExists){
                throw new IllegalStateException("Email already taken");
            }
           String encodedPassword = bCryptPasswordEncoder.encode(treyder.getPassword());
            treyder.setPassword(encodedPassword);

            treyderRepository.save(treyder);

            String token = UUID.randomUUID().toString();
            // TODO: Send confirmation token
            ConfirmationToken confirmationToken = new ConfirmationToken(
                    token,
                    LocalDateTime.now(),
                    LocalDateTime.now().plusMinutes(15),
                    treyder
            );
            confirmationTokenService.saveConfirmationToken(confirmationToken);
            // TODO: send email
        return token;
    }
    public int enableTreyder(String email){
        return treyderRepository.enableTreyder(email);
    }
}
