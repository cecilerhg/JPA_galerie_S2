package galerie.entity;
import java.time.LocalDate;
import java.time.Month;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.*;
import lombok.*;

// Un exemple d'entité
// On utilise Lombok pour auto-générer getter / setter / toString...
// cf. https://examples.javacodegeeks.com/spring-boot-with-lombok/
@Getter @Setter @NoArgsConstructor @RequiredArgsConstructor @ToString
@Entity // Une entité JPA 
public class Galerie {
    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer id;

    @Column(unique=true)
    @NonNull
    private String nom;
    
    @Column(unique=true)
    @NonNull
    private String adresse;
    
    //Constructeur 
    public Galerie(Integer id, String nom, String adresse) {
        this.id = id;
        this.nom = nom;
        this.adresse = adresse;
    }    
    
    //Méthode CAannuel 
    public float CAannuel(int annee){
        float ca = 0; 
        for (Exposition e : evenements) {
            LocalDate d = e.getDebut();
            if (d.isBefore(LocalDate.of(annee, 12, 31)) && d.isAfter(LocalDate.of(annee, 1, 1))) {
                ca += e.CA();
            }
        }
        return ca;
    }
    
    //Cardinalités 
    
    @OneToMany (mappedBy = "organisateur") //Relation galerie - exposition 
    private List<Exposition> evenements = new LinkedList<>();
    

}
