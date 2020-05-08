package dashboard.main.service;

import dashboard.main.model.InventoryEntity;

import java.util.List;
import java.util.Optional;


public interface InventoryService {
    List<InventoryEntity> findAll();

    Optional<InventoryEntity> findOne(String terminalId);

    InventoryEntity save(InventoryEntity entity);

    boolean decommission(String terminalId);

    boolean update(String terminalId);

}