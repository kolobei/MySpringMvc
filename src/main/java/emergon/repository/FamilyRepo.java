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
    public void delete(int id) {
<<<<<<< HEAD
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
=======
        
>>>>>>> master
    }

    @Override
    public Family findById(int id) {
<<<<<<< HEAD
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
=======
        return null;
>>>>>>> master
    }

    @Override
    public List<Family> findAll() {
<<<<<<< HEAD
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
=======
        return null;
>>>>>>> master
    }
    
    @Override
    public Family save(Family f) {
        return null;
    }

     
    
}
