/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package galerie.entity;
import java.time.LocalDate;
import java.util.Date;
import javax.persistence.*;
import lombok.*;
/**
 *
 * @author cecil
 */
@Getter @Setter @NoArgsConstructor @RequiredArgsConstructor @ToString
@Entity // Une entité JPA
public class Transaction {
    
    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer id;

    @Column(unique=true)
    @NonNull
    private LocalDate venduLe;
    
    @Column(unique=true)
    @NonNull
    private Float prixVente;
    
    //Constructeur 

    public Transaction(Integer id, LocalDate venduLe, Float prixVente) {
        this.id = id;
        this.venduLe = venduLe;
        this.prixVente = prixVente;
    }
    
    //Cardinalités
    
    @OneToOne //Relation transaction-tableau
    private Tableau oeuvre;
    
    @ManyToOne //Relation transaction - personne 
    private Personne client;
    
    @ManyToOne //Relation transaction - exposition 
    private Exposition lieuDeVente;
        
}
