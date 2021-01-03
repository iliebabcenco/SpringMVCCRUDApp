package md.babcenco.springcourse.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/first")
public class FirstController {

    @GetMapping("/hello")
    public String helloPage(HttpServletRequest request){

        String name = request.getParameter("name");
        String surname = request.getParameter("surname");

        System.out.println("Hello "+name+" "+surname+"!");

        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodByePage(@RequestParam(value = "name", required = false) String name,
                              @RequestParam(value = "surname", required = false) String surname,
                                Model model
                              ){

        //System.out.println("Goodbye "+name+" "+surname+"!");
        model.addAttribute("message","Goodbye "+name+" "+surname+"!");

        return "first/goodbye";
    }
    @GetMapping("/calculator")
    public String calculate(@RequestParam(value = "a") int a,
                            @RequestParam(value = "b") int b,
                            @RequestParam(value = "action") String action,
                            Model model
                            ){

        switch (action){
            case "multiplication":
                model.addAttribute("result", a*b);
                break;
            case "addition":
                model.addAttribute("result", a+b);
                break;

            case "substraction":
                model.addAttribute("result", a-b);
                break;
            case "division":
                model.addAttribute("result", a/(float)b);
                break;
            default:
                model.addAttribute("result", 0);
                break;
        }

        return "first/calculator";
    }
}
