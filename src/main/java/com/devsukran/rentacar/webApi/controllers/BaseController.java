package com.devsukran.rentacar.webApi.controllers;

import com.devsukran.rentacar.core.utilities.result.DataResult;
import com.devsukran.rentacar.core.utilities.result.Result;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseController {

    public ResponseEntity<?> handleDataResult (DataResult <?> dataResult){
        if (dataResult.isSuccess()){
            return ResponseEntity.ok(dataResult);
        }
        return ResponseEntity.badRequest().body(dataResult);

    }
    public ResponseEntity<?> handleResult (Result result ){
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);

    }

}
