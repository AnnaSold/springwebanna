package com.example.springwebanna;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

@Controller
public class MyController {
    @GetMapping("/index")
    public String index(){
     return "index";
    }

    @GetMapping("/calculate")
    public String calculate(@RequestParam (name = "a", defaultValue = "0") String a,
                            @RequestParam (name = "b", defaultValue = "0") String b,
                            Model model){

        try {
            int x = Integer.parseInt(a);
            int y = Integer.parseInt(b);
            model.addAttribute("result", x * y);
            model.addAttribute("result2", ((x + y)*2));
        }
        catch (NumberFormatException e){
            model.addAttribute("errorMsg", "это было не число");
        }

        return "calculate";
    }

}
