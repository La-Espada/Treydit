package com.irgek.Treydit.persistence;

import com.irgek.Treydit.domain.ERole;
import com.irgek.Treydit.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
