/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package galerie.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import galerie.entity.Exposition;

/**
 *
 * @author cecil
 */
public interface ExpositionRepository extends JpaRepository<Exposition, Integer> {
    
}
