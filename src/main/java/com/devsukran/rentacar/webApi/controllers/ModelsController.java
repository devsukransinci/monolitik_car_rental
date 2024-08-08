package com.devsukran.rentacar.webApi.controllers;

import com.devsukran.rentacar.business.abstracts.ModelService;
import com.devsukran.rentacar.business.request.create.model.CreateModelRequest;
import com.devsukran.rentacar.business.responses.create.model.CreateModelResponse;
import com.devsukran.rentacar.business.responses.get.model.GetAllModelResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/models")
@AllArgsConstructor

public class ModelsController {

    private ModelService modelService;

    @PostMapping
    public CreateModelResponse add(@RequestBody CreateModelRequest request){
        return modelService.add(request);

    }

    @GetMapping
    public List<GetAllModelResponse> getAll(){
        return modelService.getAll();
    }

    @GetMapping( "/getByName/{name}")
    public GetAllModelResponse getByName(@PathVariable String name){
        return modelService.getByName(name);

    }
}
