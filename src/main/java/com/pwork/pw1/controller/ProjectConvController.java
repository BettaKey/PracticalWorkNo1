package com.pwork.pw1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/PW1")
public class ProjectConvController {

    @RequestMapping("/conv")
    public String getConv() {
        return "currency_converter";
    }

    @PostMapping("/conv_result")
    public String postConv(Model model, @RequestParam(name="amount") double amount, @RequestParam(name="fromCur") String fromCur, @RequestParam(name="toCur") String toCur) {
        double convRate = getConvRate(fromCur, toCur);
        double convAmount = amount * convRate;
        model.addAttribute("ConvertedAmount", fromCur + " " + String.format("%.1f", amount) + " = " + " " + toCur + " " + String.format("%.1f", convAmount));
        return "conv_result";
    }

    public double getConvRate(String fromCurrency, String toCurrency) {
        if (fromCurrency.equals("USD") && toCurrency.equals("RUB")) {
            return 89.90;
        } else if (fromCurrency.equals("RUB") && toCurrency.equals("USD")) {
            return 0.011;
        }
        return 1.0;
    }
}
