package com.devsukran.rentacar.webApi.controllers;
import com.devsukran.rentacar.business.abstracts.BrandService;
import com.devsukran.rentacar.business.request.create.brand.CreateBrandRequest;
import com.devsukran.rentacar.business.responses.create.brand.CreateBrandResponse;
import com.devsukran.rentacar.business.responses.get.brand.GetAllBrandResponse;
import com.devsukran.rentacar.business.responses.get.brand.GetBrandResponse;
import com.devsukran.rentacar.core.utilities.paging.PageDto;
import com.devsukran.rentacar.core.utilities.result.DataResult;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/brands")
@AllArgsConstructor
public class BrandsController extends BaseController {

    private BrandService brandService;

    @PostMapping
    public ResponseEntity<?> add(@RequestBody CreateBrandRequest request){
        return  handleDataResult(brandService.add(request));
    }

    @GetMapping("getall")
    public ResponseEntity<?> getAll(){
     return handleDataResult(brandService.getAll());
    }

    @GetMapping( "getById/{id}")
    public GetBrandResponse getById(int id){
        return brandService.getById(id);
    }

    @GetMapping("sort")
    public ResponseEntity <?> getAllPage (@RequestBody PageDto pageDto){
        return handleDataResult(brandService.getAllPage(pageDto));

    }

    @DeleteMapping("{id}")
    public ResponseEntity <?> delete (@PathVariable int id){
     return handleResult(brandService.delete(id));
    }


}
