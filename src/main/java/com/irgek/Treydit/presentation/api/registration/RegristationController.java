package com.irgek.Treydit.presentation.api.registration;

import com.irgek.Treydit.presentation.api.registration.RegistrationRequest;
import com.irgek.Treydit.service.RegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/registration")
@AllArgsConstructor
public class RegristationController {

    private final RegistrationService registrationService;

    @PostMapping
    public String register(@RequestBody RegistrationRequest request){
        return registrationService.register(request);
    }

    @GetMapping(path = "confirm")
    public String confirm(@RequestParam("token") String token){
        return  registrationService.confirmToken(token);
    }
}
