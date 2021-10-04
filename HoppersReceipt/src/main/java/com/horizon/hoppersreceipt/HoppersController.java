package com.horizon.hoppersreceipt;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HoppersController {
	
	// class definition and imports here...
    @RequestMapping("/")
    public String index(Model model) {
        
        String name = "Elon Musk";
        String itemName = "Falcon 9";
        double price = 2.5;
        String description = "Reusable rocket.";
        String vendor = "Spacex";
    
    	// Your code here! Add values to the view model to be rendered
        model.addAttribute("name", name);
        model.addAttribute("item", itemName);
        model.addAttribute("price", price);
        model.addAttribute("desc", description);
        model.addAttribute("vendor", vendor);
    
        return "index.jsp";
    }

}
