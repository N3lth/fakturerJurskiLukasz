package eu.programisci.gra.gra.repository;

import eu.programisci.gra.gra.dto.GraDTO;
import eu.programisci.gra.gra.enums.EGatunek;
import eu.programisci.gra.gra.model.GraOB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IGraRepository extends JpaRepository<GraOB, Long> {

    @Query("SELECT DISTINCT g " +
            " FROM GraOB g " +
            " LEFT JOIN FETCH g.wydania w " +
            " WHERE w.rokWydania > :rokWydania ")
    List<GraOB> znajdzStarszeNiz(@Param("rokWydania") Integer rokWydania);

    @Query("SELECT g " +
            " FROM GraOB g " +
            " WHERE :gatunek MEMBER OF g.gatunki")
    List<GraOB> znajdzWgGatunku(@Param("gatunek") EGatunek gatunek);

    @Query("SELECT g.tytul " +
            " FROM GraOB g " +
            " WHERE upper(g.tytul) LIKE upper(concat('%',:partial,'%')) ")
    List<String> znajdzTytulyZawierajace(@Param("partial") String partial);

    @Query("SELECT g " +
            " FROM GraOB g " +
            " LEFT JOIN FETCH g.wydania w " +
            " WHERE :gatunek MEMBER OF g.gatunki " +
            " AND w.rokWydania = :rokWydania")
    List<GraOB> znajdzTytulyZawierajace(@Param("gatunek") EGatunek gatunek, @Param("rokWydania") Integer rokWydania);

}
