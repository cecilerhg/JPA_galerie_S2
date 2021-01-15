/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package galerie.entity;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.*;
import lombok.*;
/**
 *
 * @author cecil
 */
@Getter @Setter @NoArgsConstructor @RequiredArgsConstructor @ToString
@Entity // Une entité JPA
public class Artiste extends Personne {
    
    @Column(unique=true)
    @NonNull
    private String biographie;
    
    //Constructeur
    public Artiste(String nom, String adresse) {
        super(nom, adresse);
    }
    
    //Cardinalités 
    
    @OneToMany (mappedBy = "auteur") //Relation artiste - tableau 
    private List<Tableau> oeuvres = new LinkedList<>();
}

