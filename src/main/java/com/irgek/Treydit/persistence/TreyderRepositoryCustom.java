package com.irgek.Treydit.persistence;


import com.irgek.Treydit.domain.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TreyderRepositoryCustom  {
    Treyder addTreyder(Treyder treyder);
    Treyder getByUsername(String username);
    List<Treyder> getTreyderbyFirstname(String firstname);
}
