package eu.programisci.gra.wydanie.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "wydanie")
@SequenceGenerator(allocationSize = 1, name = "SEKWENCJA", sequenceName = "gen_wydanie_id")
public class WydanieOB {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEKWENCJA")
    private Long id;

    @Column(name = "creation_date", columnDefinition = "TIMESTAMP")
    private Date dataUtworzenia;

    @Column(name = "wydawca")
    private String wydawca;

    @Column(name = "platforma")
    private String platforma;

    @Column(name = "rokWydania")
    private Integer rokWydania;

    public WydanieOB() {
    }

    public WydanieOB(Date dataUtworzenia, String wydawca, String platforma, Integer rokWydania) {
        this.dataUtworzenia = dataUtworzenia;
        this.wydawca = wydawca;
        this.platforma = platforma;
        this.rokWydania = rokWydania;
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

    public String getWydawca() {
        return wydawca;
    }

    public void setWydawca(String wydawca) {
        this.wydawca = wydawca;
    }

    public String getPlatforma() {
        return platforma;
    }

    public void setPlatforma(String platforma) {
        this.platforma = platforma;
    }

    public Integer getRokWydania() {
        return rokWydania;
    }

    public void setRokWydania(Integer rokWydania) {
        this.rokWydania = rokWydania;
    }
}