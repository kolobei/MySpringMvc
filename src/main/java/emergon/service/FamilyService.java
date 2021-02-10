/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emergon.service;

import emergon.entity.Family;
import emergon.repository.FamilyRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author gkolo
 */
@Transactional
@Service
public class FamilyService {
    
    @Autowired
    FamilyRepo familyRepo;
    
    
}
