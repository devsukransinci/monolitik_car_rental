package com.devsukran.rentacar.business.concretes;

import com.devsukran.rentacar.business.abstracts.BrandService;
import com.devsukran.rentacar.business.constants.BrandMessages;
import com.devsukran.rentacar.business.request.create.brand.CreateBrandRequest;
import com.devsukran.rentacar.business.responses.create.brand.CreateBrandResponse;
import com.devsukran.rentacar.business.responses.get.brand.GetAllBrandResponse;
import com.devsukran.rentacar.business.responses.get.brand.GetBrandResponse;
import com.devsukran.rentacar.core.utilities.mapping.ModelMapperService;
import com.devsukran.rentacar.core.utilities.paging.PageDto;
import com.devsukran.rentacar.core.utilities.result.DataResult;
import com.devsukran.rentacar.core.utilities.result.ErrorResult;
import com.devsukran.rentacar.core.utilities.result.Result;
import com.devsukran.rentacar.core.utilities.result.SuccessDataResult;
import com.devsukran.rentacar.dataAccess.abstracts.BrandRepository;
import com.devsukran.rentacar.entities.concretes.Brand;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BrandManager implements BrandService {

    private BrandRepository brandRepository;
    private ModelMapperService mapperService;

    @Override
    public DataResult<CreateBrandResponse> add (CreateBrandRequest request) {
        Brand brand =mapperService.forRequest().map(request, Brand.class);
        brand.setCreatedDate(LocalDateTime.now());
        brandRepository.save(brand);
        CreateBrandResponse response=mapperService.forResponse()
                .map(brand,CreateBrandResponse.class);
        return new SuccessDataResult<CreateBrandResponse>
                (response, BrandMessages.BrandAdded);

    }

    @Override
    public DataResult<List<GetAllBrandResponse>> getAll() {
        List<Brand> brands =brandRepository.findAll();
        List<GetAllBrandResponse> brandResponses= brands.stream().map(brand ->
                mapperService.forResponse().map(brand,GetAllBrandResponse.class))
                .collect(Collectors.toList());
        return new SuccessDataResult<List<GetAllBrandResponse>>
                (brandResponses,BrandMessages.BrandListed);
    }
    @Override
    public GetBrandResponse getById(int id) {
        Brand brand =brandRepository.findById(id);
        GetBrandResponse  response =mapperService.forResponse().
                map(brand,GetBrandResponse.class);
                return response;
    }

    @Override
    public DataResult<List<GetAllBrandResponse>> getAllPage(PageDto pageDto) {
        Sort sort = Sort.by(Sort.Direction.fromString(pageDto.getSortDirection())
                ,pageDto.getSortBy());
        Pageable pageable = PageRequest.of(pageDto.getPageNumber()
                ,pageDto.getPageSize(),sort);

        Page<Brand>brands =brandRepository.findAll(pageable);
        List<GetAllBrandResponse> responses=brands.stream()
                .map(brand -> mapperService.forResponse().map(brand,
                        GetAllBrandResponse.class)).toList();
        return new SuccessDataResult<List<GetAllBrandResponse>>(responses);

    }

    @Override
    public Result delete(int id) {
       Brand  brand = brandRepository.getById(id);
       brandRepository.delete(brand);
       return new SuccessDataResult("Deleted success");
    }
}
