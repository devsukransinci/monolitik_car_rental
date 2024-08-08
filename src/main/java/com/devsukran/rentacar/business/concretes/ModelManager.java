package com.devsukran.rentacar.business.concretes;
import com.devsukran.rentacar.business.abstracts.ModelService;
import com.devsukran.rentacar.business.request.create.model.CreateModelRequest;
import com.devsukran.rentacar.business.responses.create.model.CreateModelResponse;
import com.devsukran.rentacar.business.responses.get.model.GetAllModelResponse;
import com.devsukran.rentacar.core.utilities.mapping.ModelMapperService;
import com.devsukran.rentacar.dataAccess.abstracts.ModelRepository;
import com.devsukran.rentacar.entities.concretes.Model;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
@Service
@AllArgsConstructor
public class ModelManager implements ModelService {

    private ModelRepository modelRepository;
    private ModelMapperService mapperService;

    @Override
    public CreateModelResponse add(CreateModelRequest request) {
        Model model =  mapperService.forRequest().map(request,Model.class);
        model.setCreatedDate(LocalDateTime.now());
        Model createdModel =modelRepository.save(model);
       CreateModelResponse response =mapperService.forResponse()
               .map(createdModel,CreateModelResponse.class);
       return  response;
    }


    @Override
    public List<GetAllModelResponse> getAll() {
        List<Model> models =modelRepository.findAll();
        List<GetAllModelResponse>responses =models.stream()
                .map(model -> mapperService.forResponse()
                        .map(model, GetAllModelResponse.class)).
                toList();
        return responses;
    }


    @Override
    public GetAllModelResponse getByName(String name) {
        Model model =modelRepository.findByName(name);
        GetAllModelResponse response = mapperService.forResponse()
                .map(model ,GetAllModelResponse.class);
        return response;
    }

}
