package com.springboot.web.controllers;

import com.springboot.web.models.dtos.ParamDto;
import com.springboot.web.models.dtos.ParamsDto;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/v1/params")
public class RequestParamController {

    @Value("${config.tittle}")
    private String tittle;

    @Value("#{ '${config.list}'.toUpperCase().split(',') }")
    private List<String> valueList;

    // Inyección de un mapa desde un properties
    @Value("#{ ${config.valesMap} }")
    private Map<String, Object> map;

    @Value("#{ ${config.valesMap}.key1 }")
    private String key1;

    @Value("#{ ${config.valesMap}.key2 }")
    private String key2;

    @Autowired
    private Environment env;

    @GetMapping("/foo")
    public ParamDto foo(
            @RequestParam(
                    required = false,
                    defaultValue = "Hello, World!",
                    name = "message"
            ) String message) {
        return new ParamDto(message);
    }

    @GetMapping("/bar")
    public ParamsDto bar(

            @RequestParam(
                    required = false,
                    defaultValue = "Hello, param1!",
                    name = "param1"
            ) String param1,

            @RequestParam(
                    required = false,
                    defaultValue = "Hello, param2!",
                    name = "param2"
            ) String param2

    ) {
        return new ParamsDto(param1, param2);
    }

    @GetMapping("/request")
    public ParamsDto request(HttpServletRequest request) {
        return new ParamsDto(
                request.getParameter("param1"),
                request.getParameter("param2")
        );
    }

    @GetMapping("/config")
    public Map<String, Object> config(@Value("${config.param1}") String param1, @Value("${config.param2}") String param2 ) {
        Map<String, Object> map = new HashMap<>();
        map.put("tittle", tittle);
        map.put("params", new ParamsDto(param1, param2));
        map.put("list", valueList);
        map.put("map", this.map);
        map.put("key1", key1);
        map.put("key2", key2);
        map.put("param1", this.env.getProperty("config.param1", String.class));
        return map;
    }

    @GetMapping("/configMap")
    public Map<String, Object> configMap() {
        return this.map;
    }
}
