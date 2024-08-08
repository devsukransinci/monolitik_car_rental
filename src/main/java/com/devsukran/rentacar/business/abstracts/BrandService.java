package com.devsukran.rentacar.business.abstracts;
import com.devsukran.rentacar.business.request.create.brand.CreateBrandRequest;
import com.devsukran.rentacar.business.responses.create.brand.CreateBrandResponse;
import com.devsukran.rentacar.business.responses.get.brand.GetAllBrandResponse;
import com.devsukran.rentacar.business.responses.get.brand.GetBrandResponse;
import com.devsukran.rentacar.core.utilities.paging.PageDto;
import com.devsukran.rentacar.core.utilities.result.DataResult;
import com.devsukran.rentacar.core.utilities.result.Result;

import java.util.List;

public interface BrandService {

    DataResult <CreateBrandResponse> add(CreateBrandRequest request);
    DataResult <List<GetAllBrandResponse>> getAll();
    GetBrandResponse getById(int id);
    DataResult <List <GetAllBrandResponse>> getAllPage(PageDto pageDto);
   Result delete(int id);
}
