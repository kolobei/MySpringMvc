/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emergon.service;

import java.time.LocalDateTime;
import org.springframework.stereotype.Service;

/**
 *
 * @author gkolo
 */
@Service
public class HomeService {
    
    public String getWelcomeMessage(){
        LocalDateTime time = LocalDateTime.now();
        String message = "Welcome to our application. The time is " + time;
        return message;
    }
    
    public String getApplicationName(){
        return "Application Name : MySpringMVCApp";
    }
    
}
