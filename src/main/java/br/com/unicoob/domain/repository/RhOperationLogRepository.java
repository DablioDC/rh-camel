package br.com.unicoob.domain.repository;

import br.com.unicoob.domain.model.RhOperationLog;
import br.com.unicoob.domain.type.OperationType;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RhOperationLogRepository extends PagingAndSortingRepository<RhOperationLog, Long> {

    List<RhOperationLog> findAllByOperationAndNumcadAndNumempAndNumcpfAndOperatorGroup(OperationType operationType, Integer numcad, Integer numemp, Long numcpf, String operatorGroup);
}
