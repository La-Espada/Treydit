package com.irgek.Treydit.presentation.api;


import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.irgek.Treydit.domain.*;
import com.irgek.Treydit.domain.saveImages.FileUploadUtil;
import com.irgek.Treydit.domain.security.PasswordHash;
import com.irgek.Treydit.payload.request.ItemRequest;
import com.irgek.Treydit.payload.request.LoginRequest;
import com.irgek.Treydit.payload.request.SignupRequest;
import com.irgek.Treydit.payload.response.JwtResponse;
import com.irgek.Treydit.payload.response.MessageResponse;
import com.irgek.Treydit.persistence.ItemRepository;
import com.irgek.Treydit.persistence.RoleRepository;
import com.irgek.Treydit.persistence.TreyderRepository;
import com.irgek.Treydit.service.TreyderServiceImpl;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
/*import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;*/
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.net.URI;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.time.Clock;
import java.util.*;
import java.util.stream.Collectors;


import static java.util.Arrays.stream;
import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.http.HttpStatus.FORBIDDEN;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@AllArgsConstructor

@Slf4j
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class TreyderRestController {

    /*@Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    JwtUtils jwtUtils;*/
  /*  @Autowired
    PasswordEncoder encoder;*/
    @Autowired
    TreyderRepository treyderRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    ItemRepository itemRepository;

    private final TreyderServiceImpl treyderService;
    @Autowired
    PasswordHash hash;






    @GetMapping("/treyder")
    public ResponseEntity<List<Treyder>> getTreyder() {
        return ResponseEntity.ok().body(treyderService.getTreyder());
    }

    @GetMapping("/item")
    public ResponseEntity<List<Item>> getItems(){
        return ResponseEntity.ok().body(itemRepository.findAll());
    }

    @GetMapping("/{id}/item")
    public ResponseEntity<List<Item>> getItems(@PathVariable Long id){
        Treyder treyder = treyderRepository.findTreyderById(id);
        return ResponseEntity.ok().body(treyder.getItems());
    }


    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody SignupRequest signupRequest) throws NoSuchAlgorithmException, InvalidKeySpecException {

        if(treyderRepository.existsByEmail(signupRequest.getEmail())){
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email ist already in use!"));
        }
        if(treyderRepository.existsByUsername(signupRequest.getUsername())){
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Username ist already in use!"));
        }
        /*SecureRandom random = new SecureRandom();

        byte[] salt = new byte[16];
        random.nextBytes(salt);
        KeySpec spec = new PBEKeySpec(signupRequest.getPassword().toCharArray(), salt, 65536, 128);
        SecretKeyFactory f = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        byte[] hash = f.generateSecret(spec).getEncoded();
        Base64.Encoder enc = Base64.getEncoder();
        System.out.printf("salt: %s%n", enc.encodeToString(salt));
        System.out.printf("hash: %s%n", enc.encodeToString(hash));*/
        String hashedPassword = hash.encrypt(signupRequest.getPassword());



        Treyder treyder =new Treyder(signupRequest.getUsername(),signupRequest.getEmail(),hashedPassword,
                signupRequest.getFirstname(),signupRequest.getLastname(),signupRequest.getGender(),signupRequest.getPhonenumber());

        treyderRepository.save(treyder);
        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }





    @PostMapping("/login")
    public ResponseEntity<Treyder> login(@Valid @RequestBody LoginRequest loginRequest){
        Treyder treyder= null;
        if(treyderRepository.existsByEmail(loginRequest.getEmail())){
             treyder = treyderRepository.findTreyderByEmail(loginRequest.getEmail());
             String inputPassword = hash.encrypt(loginRequest.getPassword());
             String databasePassword = hash.decrypt(treyder.getPassword());

             System.out.println(inputPassword);
             System.out.println(databasePassword);

            if(loginRequest.getPassword().equals(databasePassword)){
                System.out.println(treyder.getUsername());
                return ResponseEntity.ok().body(treyder);
            }
            return ResponseEntity.badRequest().body(treyder);
            //body(new MessageResponse("Wrong password!"));
        }
        return ResponseEntity.badRequest().body(treyder);
        //.body(new MessageResponse("User doesnt exists!"));
    }


    @PostMapping("/{id}/addItem")
    public ResponseEntity<?> addItemtoUser(@Valid @PathVariable("id") Long id, @RequestBody ItemRequest item) throws IOException {

        List<Item> items = null;
        Item item1 = null;
        Treyder treyder = treyderRepository.findTreyderById(id);
        if(treyder == null){
            log.error("No right user");
            return ResponseEntity.badRequest().body(new MessageResponse("User does not exists!"));
        }
        else {
           // String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());

            item1 = new Item(item.getName(),item.getDescription(),item.getCost(),item.getCondition(),item.getCategory(),treyder,item.getImage());
            treyder.getItems().add(item1);
            System.out.println(treyder.getItems().size());
            //String uploadDir = "item-imagess/" + item1.getId();
            //FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
            itemRepository.save(item1);
            return ResponseEntity.ok(item1);
        }

    }

    /*@PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);


        Treyder treyder = (Treyder) authentication.getPrincipal();
        List<String> roles = treyder.getAuthorities().stream()
                .map(item-> item.getAuthority())
                .collect(Collectors.toList());
        return ResponseEntity.ok(new JwtResponse(jwt,treyder.getId(),treyder.getUsername(),treyder.getEmail(),roles));
    }*/

    /*@PostMapping("/register")
    public ResponseEntity<?> registerTreyder(@Valid @RequestBody SignupRequest signupRequest){
        if(treyderRepository.existsByUsername(signupRequest.getUsername())){
            return ResponseEntity.
                    badRequest()
                    .body(new MessageResponse("Error: Username is already taken!"));
        }
        if(treyderRepository.existsByEmail(signupRequest.getEmail())){
            return ResponseEntity.
                    badRequest()
                    .body(new MessageResponse("Error: Email is already in use!"));
        }

        Treyder treyder = new Treyder(signupRequest.getUsername(),signupRequest.getEmail(),encoder.encode(signupRequest.getPassword()),
                signupRequest.getFirstname(),signupRequest.getLastname(),signupRequest.getGender(),signupRequest.getPhonenumber());
        Set<String> strRoles = signupRequest.getRole();
        Set<Role> roles = new HashSet<>();
        if (strRoles == null) {
            Role userRole = roleRepository.findByName(String.valueOf(ERole.ROLE_TREYDR));
                    //.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
        }
        else{
            strRoles.forEach(role -> {
                switch (role) {
                    case "admin":
                        Role adminRole = roleRepository.findByName(String.valueOf(ERole.ROLE_ADMIN));
                                //.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(adminRole);
                        break;
                    case "mod":
                        Role modRole = roleRepository.findByName(String.valueOf(ERole.ROLE_MODERATOR));
                                //.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(modRole);
                        break;
                    default:
                        Role userRole = roleRepository.findByName(String.valueOf(ERole.ROLE_TREYDR));
                                //.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(userRole);
                }
            });
        }
        treyder.setRoles(roles);
        treyderRepository.save(treyder);
        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }*/

    @PostMapping("/treyder/add")
    public ResponseEntity<Treyder> addTreyder(@RequestBody Treyder treyder) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/treyder/add").toUriString());
        return ResponseEntity.created(uri).body(treyderService.saveTreyder(treyder));
    }

    @GetMapping("/treyder/{id}")
    public Treyder getTreyder(@PathVariable Long id) {
        return treyderRepository.findTreyderById(id);
    }

    @PostMapping("/role/add")
    public ResponseEntity<Role> addRole(@RequestBody Role role) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/role/add").toUriString());
        return ResponseEntity.created(uri).body(treyderService.saveRole(role));
    }



    @PostMapping("/role/addtoTreyder")
    public ResponseEntity<?> addRole(@RequestBody RoleToUserForm form) {
        treyderService.addRoleToTreyder(form.getUsername(), form.getRolename());
        return ResponseEntity.ok().build();

    }

    /*@GetMapping("/token/refresh")
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String authorizationHeader = request.getHeader(AUTHORIZATION);
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            try {
                String refresh_token = authorizationHeader.substring("Bearer ".length());
                Algorithm algorithm = Algorithm.HMAC256("secret".getBytes());
                JWTVerifier verifier = JWT.require(algorithm).build();
                DecodedJWT decodedJWT = verifier.verify(refresh_token);
                String username = decodedJWT.getSubject();
                Treyder treyder = treyderService.getTreyder(username);
                String access_token = JWT.create()
                        .withSubject(treyder.getUsername())
                        .withExpiresAt(new Date(System.currentTimeMillis() + 10 * 60 * 1000))
                        .withIssuer(request.getRequestURI().toString())
                        .withClaim("roles", treyder.getRoles().stream().map(Role::getName).collect(Collectors.toList()))
                        .sign(algorithm);

                Map<String, String> tokens = new HashMap<>();
                tokens.put("access_token", access_token);
                tokens.put("refresh_token", refresh_token);
                response.setContentType(APPLICATION_JSON_VALUE);
                new ObjectMapper().writeValue(response.getOutputStream(), tokens);
            } catch (Exception exception) {
                log.error("Error logging in: {}", exception.getMessage());
                response.setHeader("error", exception.getMessage());
                response.setStatus(FORBIDDEN.value());
                // response.sendError(FORBIDDEN.value());
                Map<String, String> error = new HashMap<>();
                error.put("error_message", exception.getMessage());
                response.setContentType(APPLICATION_JSON_VALUE);
                new ObjectMapper().writeValue(response.getOutputStream(), error);
            }


        }
    }*/
}

@Data
class RoleToUserForm{
    private  String username;
    private String rolename;
}
