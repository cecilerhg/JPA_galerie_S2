/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package galerie.entity;

import java.time.LocalDate;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.*;
import lombok.*;

/**
 *
 * @author cecil
 */
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
@Entity // Une entité JPA
public class Exposition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    @NonNull
    private LocalDate debut;

    @Column(unique = true)
    @NonNull
    private String intitule;

    @Column(unique = true)
    @NonNull
    private int duree;

    //Constructeur 
    public Exposition(Integer id, LocalDate debut, String intitule, int duree) {
        this.id = id;
        this.debut = debut;
        this.intitule = intitule;
        this.duree = duree;
    }

    //Méthode CA()
    public float CA() {
        float ca = 0f;
        for (Transaction t : ventes) {
            ca += t.getPrixVente();
        }
        return ca;
    }
    
    //Cardinalités 
    
    @ManyToMany (mappedBy = "accrochage") //relation exposition - tableau
    private List<Tableau> oeuvres = new LinkedList<>();
    
    @OneToMany (mappedBy = "lieuDeVente")//relation exposition - transaction 
    private List<Transaction> ventes = new LinkedList<>();
    
    @ManyToOne //relation exposition - galerie 
    private Galerie organisateur;

}
