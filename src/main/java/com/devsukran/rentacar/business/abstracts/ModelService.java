package com.devsukran.rentacar.business.abstracts;

import com.devsukran.rentacar.business.request.create.model.CreateModelRequest;
import com.devsukran.rentacar.business.responses.create.brand.CreateBrandResponse;
import com.devsukran.rentacar.business.responses.create.model.CreateModelResponse;
import com.devsukran.rentacar.business.responses.get.model.GetAllModelResponse;

import java.util.List;

public interface ModelService {
    CreateModelResponse add(CreateModelRequest request);
    List<GetAllModelResponse> getAll();
    GetAllModelResponse getByName(String name);
}
