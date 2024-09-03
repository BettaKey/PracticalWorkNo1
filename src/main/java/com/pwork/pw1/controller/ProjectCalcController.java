package com.pwork.pw1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/PW1")
public class ProjectCalcController {

    @RequestMapping("/calc")
    public String getCalc() {
        return "calculator";
    }

    @PostMapping("/calc_result")
    public String postCalc(Model model, @RequestParam(name="num1") int num1, @RequestParam(name="num2") int num2, @RequestParam(name="operation") String operation) {
        String res = calcAndFormat(num1, num2, operation);
        model.addAttribute("Result", res);
        return "calc_result";
    }

    private String calcAndFormat(double num1, double num2, String operation) {
        String operName;
        double answer = switch (operation) {
            case "add" -> {
                operName = " + ";
                yield num1 + num2;
            }
            case "sub" -> {
                operName = " - ";
                yield num1 - num2;
            }
            case "multi" -> {
                operName = " * ";
                yield num1 * num2;
            }
            case "div" -> {
                operName = " / ";
                yield num1 / num2;
            }
            default -> {
                operName = "";
                yield 0;
            }
        };
        return String.format("%.1f", num1) + operName + String.format("%.1f", num2) + " = " + String.format("%.1f", answer);
    }
}
