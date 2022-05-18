package com.irgek.Treydit.service;

import com.irgek.Treydit.domain.Role;
import com.irgek.Treydit.domain.Treyder;

import java.util.List;
import java.util.Optional;

public interface TreyderService {
    Treyder saveTreyder(Treyder treyder);
    Role saveRole(Role role);
    void addRoleToTreyder(String username, String rolename);
    Treyder getTreyder(String username);
    List<Treyder> getTreyder();
}
