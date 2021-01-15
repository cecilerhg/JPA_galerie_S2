/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package galerie.entity;
import java.time.LocalDate;
import java.time.Month;
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
public class Personne {
    
    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer id;

    @Column(unique=true)
    @NonNull
    private String nom;
    
    @Column(unique=true)
    @NonNull
    private String adresse;
    
    //Constructeur 
    public Personne(Integer id, String nom, String adresse) {
        this.id = id;
        this.nom = nom;
        this.adresse = adresse;
    }
    
    //Méthode budgetArt
    public float budgetArt(int annee){
        float budget = 0f;
        for (Transaction t : achats) {
            LocalDate d = t.getVenduLe();
            if (d.isBefore(LocalDate.of(annee, 12, 31)) && d.isAfter(LocalDate.of(annee, 1, 1))) {
                budget += t.getPrixVente();
            }
        }
        return budget;
    }
 
    //Cardinalités 
    
    @OneToMany  (mappedBy = "client") //Relation personne - transaction
    private List<Transaction> achats = new LinkedList<>();
    
    
}
