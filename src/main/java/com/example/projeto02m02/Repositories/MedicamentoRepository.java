package com.example.projeto02m02.Repositories;

import com.example.projeto02m02.Entities.MedicamentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicamentoRepository extends JpaRepository<MedicamentoEntity, Long> {
}
