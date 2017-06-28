package eu.programisci.gra.gra.model;

import eu.programisci.gra.gra.enums.EGatunek;
import eu.programisci.gra.wydanie.model.WydanieOB;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "gra")
@SequenceGenerator(allocationSize = 1, name = "SEKWENCJA", sequenceName = "gen_gra_id")
public class GraOB {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "creation_date", columnDefinition = "TIMESTAMP")
    private Date dataUtworzenia;

    @Column(name = "tytul")
    private String tytul;

    @ElementCollection(targetClass = EGatunek.class, fetch = FetchType.LAZY)
    @Enumerated(EnumType.STRING)
    @Column(name = "gatunki")
//    @CollectionTable(name = "gra_gatunek", joinColumns = @JoinColumn(name = "id"))
    private Set<EGatunek> gatunki = new HashSet<>();

    @Column(name = "developer")
    private String developer;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "wydania")
    private Set<WydanieOB> wydania;

    public GraOB() {
    }

    public GraOB(Long id, String tytul, Set<EGatunek> gatunki, String developer, Set<WydanieOB> wydania) {
        this.id = id;
        this.tytul = tytul;
        this.gatunki = gatunki;
        this.developer = developer;
        this.wydania = wydania;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataUtworzenia() {
        return dataUtworzenia;
    }

    public void setDataUtworzenia(Date dataUtworzenia) {
        this.dataUtworzenia = dataUtworzenia;
    }

    public String getTytul() {
        return tytul;
    }

    public void setTytul(String tytul) {
        this.tytul = tytul;
    }

    public Set<EGatunek> getGatunki() {
        return gatunki;
    }

    public void setGatunki(Set<EGatunek> gatunki) {
        this.gatunki = gatunki;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public Set<WydanieOB> getWydania() {
        return wydania;
    }

    public void setWydania(Set<WydanieOB> wydania) {
        this.wydania = wydania;
    }
}



