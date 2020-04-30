package dashboard.main.service;

import dashboard.main.model.InventoryEntity;
import dashboard.main.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InventoryServiceImpl implements InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

    @Override
    public List<InventoryEntity> findAll() {
        return inventoryRepository.findAll();
    }

    @Override
    public Optional<InventoryEntity> findOne(String terminalId) {
        return inventoryRepository.findById(terminalId);
    }

    @Override
    public InventoryEntity save(InventoryEntity entity) {
        inventoryRepository.save(entity);
        return entity;
    }


	
}
