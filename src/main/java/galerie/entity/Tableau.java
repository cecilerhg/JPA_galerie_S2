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
public class Tableau {
    
    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer id;

    @Column(unique=true)
    @NonNull
    private String titre;
    
    @Column(unique=true)
    @NonNull
    private String support;
    
    @Column(unique=true)
    @NonNull
    private int largeur;
    
    @Column(unique=true)
    @NonNull
    private int hauteur;
    
    //Constructeur

    public Tableau(Integer id, String titre, String support, int largeur, int hauteur) {
        this.id = id;
        this.titre = titre;
        this.support = support;
        this.largeur = largeur;
        this.hauteur = hauteur;
    }
    
    //Cardinalités 
    
    @ManyToMany // relation exposition - tableau
    private List<Exposition> accrochage = new LinkedList<>();
     
    @OneToOne (mappedBy = "oeuvre") //relation transaction - tableau 
    private Transaction vendu;
    
    @ManyToOne //relation tableau - artiste 
    private Artiste auteur;
    
}
