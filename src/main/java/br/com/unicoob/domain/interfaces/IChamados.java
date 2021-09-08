package br.com.unicoob.domain.interfaces;

import br.com.unicoob.domain.dto.OperatorGroupDTO;
import br.com.unicoob.domain.type.OperationType;

import java.util.List;

public interface IChamados  {

    OperationType getOperation();
    String getBriefDescription();
    String getRequest();
    List<OperatorGroupDTO> getOperatorGroups();
}
