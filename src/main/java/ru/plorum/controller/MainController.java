package ru.plorum.controller;

import ru.plorum.service.EventService;
import ru.plorum.service.PatientService;
import ru.plorum.service.PropertiesService;
import ru.plorum.util.ObjectMapper;
import ru.plorum.util.WebClient;
import spark.ModelAndView;
import spark.template.thymeleaf.ThymeleafTemplateEngine;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;


public class MainController {

    private final ThymeleafTemplateEngine engine = new ThymeleafTemplateEngine();

    public void init() {
        port(PropertiesService.INSTANCE.getInt("application.port"));
        staticFiles.location("/");
        index();
        timer();
        drawAlerts();
        closeAlert();
    }

    private void index() {
        get("/", (req, res) -> {
            final Map<String, Object> model = new HashMap<>();
            model.put("patients", PatientService.INSTANCE.getAll());
            return engine.render(new ModelAndView(model, "index"));
        });
    }

    private void drawAlerts() {
        get("/draw-alerts", (req, res) -> EventService.INSTANCE.getAll(), o -> new ObjectMapper().writeValueAsString(o));
    }

    private void closeAlert() {
        get("/close-alert", (req, res) -> {
            WebClient.INSTANCE.delete("/alert/" + req.queryParams("id"));
            return res.status();
        });
    }

    private void timer() {
        get("/time", (req, res) -> DateTimeFormatter.ofPattern("HH:mm").format(LocalDateTime.now()));
    }

}
