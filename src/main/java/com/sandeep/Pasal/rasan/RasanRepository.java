package com.sandeep.Pasal.rasan;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RasanRepository  extends JpaRepository<Rasan, Integer> {

    @Query( "SELECT s FROM Rasan s WHERE s.name = ?1")
    Optional<Rasan> findRasanBYName(String name);
}
