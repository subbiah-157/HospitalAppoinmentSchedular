package com.example.HospitalAppointmentSchedular;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


@Controller
public class Appointmentcontroller {
    @GetMapping("/index")
    public String Home() {
        return "index";
    }

    @GetMapping("/userlogin")
    public String userloginpage() {
        return "userlogin";
    }

    @GetMapping("/service")
    public String servicepage() {
        return "service";
    }

    @GetMapping("/contact")
    public String contactpage() {
        return "contact";
    }

    @GetMapping("/about")
    public String aboutpage() {
        return "about";
    }

    @GetMapping("/SignUp")
    public String signup() {
        return "usersignup";
    }
     @GetMapping("usersignup")
     public String UserUp(){
        return "usersignup";
     }
    @GetMapping("/doctorlogin")
    public String doctorLogin() {
        return "doctorlogin";
    }

    @GetMapping("/doctorsignup")
    public String DoctorSignup() {
        return "doctorsignup";
    }

    @PostMapping("SignInfo")
    public String DoctorLogin(@RequestParam("username") String username, @RequestParam("mail") String mail, @RequestParam("password") String pass) {
        String jdbcurl = "jdbc:mysql://localhost:3306/dbBase";
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(jdbcurl, "root", "Pass26");
            String sql = "insert into Sign values(?,?,?)";

            PreparedStatement pstatement = connection.prepareStatement(sql);
            pstatement.setString(1, username);
            pstatement.setString(2, mail);
            pstatement.setString(3, pass);
            pstatement.execute();
            System.out.println("Database updated successfully");
            connection.close();
        } catch (Exception e) {
            System.out.println("The exception occured is " + e);
        }
        return "index";

    }
}
