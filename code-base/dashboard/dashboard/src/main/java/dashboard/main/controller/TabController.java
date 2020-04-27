package dashboard.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import dashboard.main.Model.TabEntity;
import dashboard.main.service.*;

@Controller
public class TabController {

	@Autowired
	TabService tabService;

	@GetMapping(value = { "/tab", "/tab/{terminal_id}" })
	public String tabEditForm(Model model, @PathVariable(required = false, name = "terminal_id") String terminalId) {
		if (terminalId != null) {
			model.addAttribute("tab", tabService.findOne(terminalId));
		} else {
			model.addAttribute("tab", new TabEntity());
		}
        return "tabedit";	
    }
	
	@PostMapping(value = {"/tab"})
	public String tabEdit(Model model, TabEntity tab) {
		tabService.saveTab(tab);
		return "null";
	}
}