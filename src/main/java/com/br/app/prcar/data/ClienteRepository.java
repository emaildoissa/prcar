package com.br.app.prcar.data;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteEntity, Integer> {
    List<ClienteEntity> findFirst10ByOrderByDataDesc();
    
}
