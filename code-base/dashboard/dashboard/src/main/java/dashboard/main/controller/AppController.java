package dashboard.main.controller;

import dashboard.main.model.InventoryEntity;
import dashboard.main.repository.InventoryRepository;
import dashboard.main.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class AppController {

    @Autowired
    private InventoryRepository inventoryRepository;

    @GetMapping("/inventory")
    public List<InventoryEntity> listInventory() {
        return inventoryRepository.findAll();
    }

    @GetMapping(value = "/queries")
    @ResponseBody
    public List<InventoryEntity> getResult() {
        return inventoryRepository.findAll();
    }

    @Autowired
    InventoryService inventoryService;

    @GetMapping(value = {"/tabEdit", "/tabEdit/{terminal_id}"})
    public String tabEditForm(Model model, @PathVariable(required = false, name = "terminal_id") String terminalId) {
        if (terminalId != null) {
            model.addAttribute("inventory", inventoryService.findOne(terminalId));
        } else {
            model.addAttribute("inventory", new InventoryEntity());
        }
        return "tabEdit";
    }

    @PostMapping(value = {"/tabEdit"})
    public String tabEdit(Model model, InventoryEntity entity) {
        inventoryService.save(entity);
        model.addAttribute("inventory", entity);
        return "inventory";
    }

    
}
