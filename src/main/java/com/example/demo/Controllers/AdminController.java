package com.example.demo.Controllers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Services.AdminService;
import com.example.demo.classess.Admin;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
@Slf4j
public class AdminController {

    @Autowired
    private AdminService adminService;
    private static final Logger log = LoggerFactory.getLogger(AdminController.class);

    @PostMapping(path = "/register/admin")
    public Admin registerAdmin(@RequestBody Admin admin) throws Exception {
        // Supprimez la vérification d'existence pour permettre à l'admin de se connecter sans enregistrement
          String tempEmailId = admin.getEmailId();
         if (tempEmailId != null && !"".equals(tempEmailId)) {
           Admin adminObj = adminService.fetchByEmail(tempEmailId);
           if (adminObj != null) {
                throw new Exception("This admin with email " + tempEmailId + " already exists");
            }
         }

        // Vous pouvez définir un rôle spécifique pour l'administrateur, par exemple "admin"
        admin.setRole("admin");

        // Exécutez le service d'inscription avec l'admin mis à jour
        Admin adminObj = adminService.register(admin);

        // Retournez l'admin enregistré
        return adminObj;
    }
    @PostMapping(path = "/login")
    public ResponseEntity<Admin> login(@RequestBody Admin admin) {
        log.info("request body {}", admin.getEmailId());
        String tempEmail = admin.getEmailId();
        String tempPass = admin.getPassword();
        Admin visiteurObj = null;

        if (tempEmail != null && tempPass != null) {
            // Autorisez l'administrateur à se connecter sans vérifier l'existence du compte
            if (!"admin13@gmail.com".equals(tempEmail) || !"123456".equals(tempPass)) {
                visiteurObj = adminService.fetchByEmailAndPassword(tempEmail, tempPass);
            }
        }

        if (visiteurObj != null) {
            return new ResponseEntity<>(visiteurObj, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

}

