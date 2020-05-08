package dashboard.main.service;

import dashboard.main.model.InventoryEntity;
import dashboard.main.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Calendar;
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
        Timestamp timestamp = getCurrentTimestamp();
        entity.setUpdateDate(timestamp);
        inventoryRepository.save(entity);
        return entity;
    }

    @Override
    public boolean decommission(String terminalId) {
        Date sqlDate = getCurrentDate();
        Optional<InventoryEntity> entity = findOne(terminalId);
        entity.ifPresent(ent -> {
            ent.setDatePulledOut(sqlDate);
            ent.setStatus("Inactive");
            inventoryRepository.save(ent);
        });
        return entity.isPresent();
    }

    private Date getCurrentDate() {
        return new Date(Calendar.getInstance().getTime().getTime());
    }

    @Override
    public boolean update(String terminalId) {
        Timestamp sqlTimestamp = getCurrentTimestamp();
        Optional<InventoryEntity> entity = findOne(terminalId);
        entity.ifPresent(upd -> {
            upd.setUpdateDate(sqlTimestamp);
            inventoryRepository.save(upd);
        });
        return entity.isPresent();
    }

    private Timestamp getCurrentTimestamp() {
        return new Timestamp(Calendar.getInstance().getTime().getTime());
    }
}
