package com.irgek.Treydit.service;

import com.irgek.Treydit.domain.Role;
import com.irgek.Treydit.domain.Treyder;
import com.irgek.Treydit.persistence.RoleRepository;
import com.irgek.Treydit.persistence.TreyderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class TreyderServiceImpl implements TreyderService, UserDetailsService {
    private final TreyderRepository treyderRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;


    @Override
    public Treyder loadUserByUsername(String username) throws UsernameNotFoundException {
        Treyder treyder = treyderRepository.findTreyderByUsername(username);
        if(treyder == null){
            log.error("Treyder not found in the database");
            throw new UsernameNotFoundException("User not found in the database");
        }
        else
        {
            log.info("Treyder found in the database");
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        treyder.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        });
        return Treyder.build(treyder);
    }
    @Override
    public Treyder saveTreyder(Treyder treyder) {
        log.info("Saving new treyder {} to the database", treyder.getUsername());
        treyder.setPassword(passwordEncoder.encode(treyder.getPassword()));
        return treyderRepository.save(treyder);
    }

    @Override
    public Role saveRole(Role role) {
        log.info("Saving new role {} to the database", role.getName());
        return roleRepository.save(role);
    }

    @Override
    public void addRoleToTreyder(String username, String rolename) {
        log.info("Adding role {} to treyder {}", rolename, username);
        Treyder treyder = treyderRepository.findTreyderByUsername(username);
            treyder.getRoles().add(roleRepository.findByName(rolename));

    }



    @Override
    public Treyder getTreyder(String username) {
        log.info("Fetching treyder {} ", username);
        return treyderRepository.findTreyderByUsername(username);
    }

    @Override
    public List<Treyder> getTreyder() {
        log.info("Fetching all treyders");
        return treyderRepository.findAll();
    }




}
