package com.jangs.web.controller;

import com.jangs.app.SimulateOutOfMemoryError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;

@Controller
public class WelcomeController {

    private final Logger logger = LoggerFactory.getLogger(WelcomeController.class);

    @GetMapping("/")
    public String index(Model model) {
        logger.debug("Welcome to jangs.com...");
        model.addAttribute("msg", getMessage());
        model.addAttribute("today", new Date());
        model.addAttribute("maxMemory", bytesToMeg(Runtime.getRuntime().maxMemory()));
        model.addAttribute("freeMemory", bytesToMeg(Runtime.getRuntime().freeMemory()));
        model.addAttribute("totalMemory", bytesToMeg(Runtime.getRuntime().totalMemory()));

        return "index";

    }

    private String getMessage() {
        return "Hello World";
    }

    @GetMapping("/oom")
    public String oom(Model model) {
        logger.debug("SimulateOutOfMemoryError.");

        SimulateOutOfMemoryError oom = new SimulateOutOfMemoryError();
        try {
          oom.doAction();
        } catch (Exception ex) {
          System.out.println("Catching out of memory error");

        }

        model.addAttribute("maxMemory", bytesToMeg(Runtime.getRuntime().maxMemory()));
        model.addAttribute("freeMemory", bytesToMeg(Runtime.getRuntime().freeMemory()));
        model.addAttribute("totalMemory", bytesToMeg(Runtime.getRuntime().totalMemory()));

        return "oom";

    }

    public static long bytesToMeg(long bytes) {
      long  MEGABYTE = 1024L * 1024L;

      return bytes / MEGABYTE ;
    }

}
