package com.viewnext.masterjava.app.repository;

import com.viewnext.masterjava.app.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Integer> {
    @Query("SELECT c FROM Curso c WHERE c.precio >= :minPrecio AND c.precio <= :maxPrecio")
    List<Curso> findByPrecioRange(@Param("minPrecio") int minPrecio, @Param("maxPrecio") int maxPrecio);
}
