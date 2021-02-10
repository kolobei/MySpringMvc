/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emergon.repository;

import emergon.entity.Family;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author gkolo
 */
@Repository
public class FamilyRepo extends HibernateUtil<Family> implements CrudRepo<Family> {


    
    @Override
    public Family save(Family f) {
        return null;
    }

    @Override
    public void delete(int id) {
        
    }

    @Override
    public Family findById(int id) {
        return null;
    }

    @Override
    public List<Family> findAll() {
        return null;
    }

    public List<Family> findByFk(int fid) {
        return super.findByFk("Family.findBySalesman", fid); 
    }
    

}
