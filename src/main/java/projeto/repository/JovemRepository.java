package projeto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import projeto.model.entity.Jovem;

public interface JovemRepository extends JpaRepository<Jovem, Integer> {

    // Jovens que possuem uma determinada especialidade
    @Query("SELECT DISTINCT j FROM Jovem j " +
           "JOIN JovemEspecialidade je ON j.idJovem = je.idJovem.idJovem " +
           "WHERE je.idEspecialidade.idEspecialidade = :idEspecialidade")
    List<Jovem> findJovensByEspecialidade(@Param("idEspecialidade") Integer idEspecialidade);

    // Especialidades e insígnias de um determinado jovem
    @Query("SELECT 'Especialidade' as tipo, e.descricao as descricao, je.dataConquista as data " +
           "FROM JovemEspecialidade je " +
           "JOIN je.idEspecialidade e " +
           "WHERE je.idJovem.idJovem = :idJovem " +
           "UNION ALL " +
           "SELECT 'Insignia' as tipo, i.nome as descricao, ij.dataConquista as data " +
           "FROM InsigniaJovem ij " +
           "JOIN ij.idInsignia i " +
           "WHERE ij.idJovem.idJovem = :idJovem")
    List<Object[]> findEspecialidadesInsigniasByJovem(@Param("idJovem") Integer idJovem);

    // Requisitos já cumpridos por um jovem para uma determinada especialidade
    @Query("SELECT re.requisito, jre.dataCumprimento " +
           "FROM JovemRequisitoEspecialidade jre " +
           "JOIN jre.idRequisito re " +
           "JOIN ERequisitoEspecialidade ere ON ere.idRequisito.idRequisito = re.idRequisito " +
           "WHERE jre.idJovem.idJovem = :idJovem " +
           "AND ere.idEspecialidade.idEspecialidade = :idEspecialidade")
    List<Object[]> findRequisitosCumpridos(@Param("idJovem") Integer idJovem, 
                                          @Param("idEspecialidade") Integer idEspecialidade);

    // Jovens que possuem todos os requisitos para o Cruzeiro do Sul
    @Query("SELECT DISTINCT j FROM Jovem j " +
           "WHERE EXISTS (" +
           "  SELECT 1 FROM DistintivoJovem dj " +
           "  JOIN dj.idDistintivo d " +
           "  WHERE dj.idJovem.idJovem = j.idJovem " +
           "  AND d.desc = 'Lobo Caçador'" +
           ") " +
           "AND (" +
           "  SELECT COUNT(DISTINCT ij.idInsignia.idInsignia) " +
           "  FROM InsigniaJovem ij " +
           "  WHERE ij.idJovem.idJovem = j.idJovem" +
           ") >= 1 " +
           "AND (" +
           "  SELECT COUNT(DISTINCT je.idEspecialidade.idEspecialidade) " +
           "  FROM JovemEspecialidade je " +
           "  WHERE je.idJovem.idJovem = j.idJovem" +
           ") >= 5 " +
           "AND (" +
           "  SELECT COUNT(DISTINCT e.areaConhecimento.idAreaConhecimento) " +
           "  FROM JovemEspecialidade je " +
           "  JOIN je.idEspecialidade e " +
           "  WHERE je.idJovem.idJovem = j.idJovem" +
           ") >= 3")
    List<Jovem> findJovensAptosCruzeiroDoSul();
}