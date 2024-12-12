package com.springboot.web.controllers;

import com.springboot.web.models.dtos.ParamDto;
import com.springboot.web.models.dtos.ParamsDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/path")
public class PathVariableController {

    @GetMapping("/variable/{message}")
    public ParamDto pathVariable(@PathVariable String message) {
        return new ParamDto(message);
    }

    @GetMapping("/param1/{param1}/param2/{param2}")
    public ParamsDto pathVariable2(
            @PathVariable String param1,
            @PathVariable String param2
    ) {
        return new ParamsDto(param1, param2);
    }

    @PostMapping("/create")
    public ParamsDto pathVariable3(@RequestBody ParamsDto paramsDto) {
        return new ParamsDto(paramsDto.getParam1(), paramsDto.getParam2());
    }
}
