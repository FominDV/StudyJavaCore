package ru.fomin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

    @GetMapping("/hello_world")
    public String sayHello() {
        return "hello_world";
    }

    @GetMapping("/calc")
    public String getResult(@RequestParam("a") int a, @RequestParam("b") int b,@RequestParam("operation") String operation, Model model){
        int result=0;
        switch(operation){
            case "MULTIPLICATION" :result= a*b;
            break;
            case "ADDITION":result=a+b;
            break;
            case "DIVISION" :result= a/b;
            break;
            case "SUBTRACTION" :result= a-b;
        }
        model.addAttribute("result",result);
        return "calc";
    }

   private enum Operation{
        MULTIPLICATION, ADDITION, DIVISION, SUBTRACTION
   }
}
