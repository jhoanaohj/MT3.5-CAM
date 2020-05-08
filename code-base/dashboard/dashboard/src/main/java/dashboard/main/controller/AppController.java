package dashboard.main.controller;

import dashboard.main.model.InventoryEntity;
import dashboard.main.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class AppController {

    @Autowired
    InventoryService inventoryService;

    @GetMapping("/inventory")
    public String showInventory() {
        return "inventory";
    }

    @GetMapping(value = {"/tabEdit", "/tabEdit/{terminal_id}"})
    public String tabEditForm(Model model, @PathVariable(required = false, name = "terminal_id") String terminalId) {
        if (terminalId != null) {
            model.addAttribute("inventory", inventoryService.findOne(terminalId));
        } else {
            model.addAttribute("inventory", new InventoryEntity());
        }
        return "tabEdit";
    }

    @GetMapping(value = {"/tabAdd"})
    public String tabAddForm(Model model) {
        model.addAttribute("inventory", new InventoryEntity());
        return "tabAdd";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);

        // true passed to CustomDateEditor constructor means convert empty String to null
        binder.registerCustomEditor(Date.class, "datePulledOut", new CustomDateEditor(dateFormat, true));
    }

    @PostMapping(value = {"/tabEdit"})
    @ResponseBody
    public ResponseEntity<?> tabEdit(InventoryEntity entity) {
        inventoryService.save(entity);
        return new ResponseEntity<>("Changes saved.", HttpStatus.OK);
    }

    @PostMapping(value = {"/decommission"})
    @ResponseBody
    public ResponseEntity<?> decommission(@RequestParam(value = "terminalId") String terminalId) {
        if (inventoryService.decommission(terminalId))
            return new ResponseEntity<>("Machine Decommissioned.", HttpStatus.OK);
        return new ResponseEntity<>("Operation Failed.", HttpStatus.NOT_FOUND);
    }

    @PostMapping(value = {"/tabAdd"})
    public ResponseEntity<?> tabAddForm(InventoryEntity entity) {
        inventoryService.save(entity);
        return new ResponseEntity<>("Changes saved.", HttpStatus.OK);
    }

    @GetMapping("/inventoryList")
    @ResponseBody
    public List<InventoryEntity> listInventory() {
        return inventoryService.findAll();
    }

    @GetMapping(value = "/queries")
    @ResponseBody
    public List<InventoryEntity> getResult() {
        return inventoryService.findAll();
    }
}

