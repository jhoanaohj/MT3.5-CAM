package dashboard.main.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import dashboard.main.model.TabEntity;
import dashboard.main.service.*;

@Controller
public class TabController {

	@Autowired
	TabService tabService;
	

	@GetMapping(value = { "/tab", "/tab/{terminal_id}" })
	public String tabForm(Model model, @PathVariable(required = false, name = "terminal_id") String terminalId) {
		if (terminalId != null) {
			model.addAttribute("tab", tabService.findOne(terminalId));
		} else {
			model.addAttribute("tab", new TabEntity());
		}
		return "tabedit";
	}
	
	
	
}
