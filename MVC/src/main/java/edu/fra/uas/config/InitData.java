package edu.fra.uas.config;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.fra.uas.model.User;
import edu.fra.uas.service.UserService;
import jakarta.annotation.PostConstruct;

@Component
public class InitData {

    private final Logger log = org.slf4j.LoggerFactory.getLogger(InitData.class);
    
// Obj von Service Klasse Erstellt
    @Autowired
    UserService userService;
//Die Methode mit der @PostConstruct-Annotation wird nach der Konstruktion des Beans aufgerufen
    @PostConstruct
    public void init() {
        log.debug("### Initialize Data ###");
// In der init-Methode werden einige Beispielbenutzer erstellt und dem UserService hinzugefüg.
// also User user creat user wird ein USer Obj erstellt mit über userService.creatUser(User) in Userservice hinzugefügt.
        log.debug("create user admin");
        User user = new User();
        user.setRole("ADMIN");
        user.setFirstName("Administrator");
        user.setLastName("Administrator");
        user.setEmail("admin@example.com");
        user.setPassword("extremeSecurePassword1234");
        userService.createUser(user);
// same as oben
        log.debug("create user alice");
        user = new User();
        user.setRole("USER");
        user.setFirstName("Alice");
        user.setLastName("Adams");
        user.setEmail("alice@example.com");
        user.setPassword("alice1234");
        userService.createUser(user);
// same as oben
        log.debug("create user bob");
        user = new User();
        user.setRole("USER");
        user.setFirstName("Bob");
        user.setLastName("Builder");
        user.setEmail("bob@example.com");
        user.setPassword("bob1234");
        userService.createUser(user);

        log.debug("### Data initialized ###");
    }

}
