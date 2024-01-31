package com.demoaop.controller;


import ch.qos.logback.core.net.SyslogOutputStream;
import com.demoaop.model.AopModel;
import com.demoaop.service.AopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/aop")
public class AopController {

    @Autowired
    private AopService aopService;

    @GetMapping("/get")
    public ResponseEntity<List<AopModel>> fetchAllDetails(){
        return aopService.getAllDetails();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?>  getDetailsById(@PathVariable Integer id){

        Optional<AopModel> model = aopService.findById(id);

        if(model.isPresent()){
            return new ResponseEntity<>(model.get(), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("No more details in this id",HttpStatus.NOT_FOUND);
        }
    }

    // method to get values in upper case

//    @GetMapping("/{id}")
//    public ResponseEntity<?>  getDetailsById(@PathVariable Integer id){
//
//        Optional<AopModel> model = aopService.findById(id);
//        if(!model.isEmpty()){
//
//            Optional<String> name = Optional.of(model.get().getName());
//            if(name.isPresent()){
//                return new ResponseEntity<>(name.get().toUpperCase(),HttpStatus.OK);
//            }
//            else {
//                return  new ResponseEntity<>("name is null",HttpStatus.NOT_FOUND);
//            }
//
//        }
//        else {
//            return new ResponseEntity<>("No more details in this id",HttpStatus.NOT_FOUND);
//        }
//    }


    @PostMapping("/save")
    public ResponseEntity<String> saveAllDetailsInApoDB(@RequestBody AopModel aopModel) throws Exception {

        return aopService.saveAllDetails(aopModel);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateAllDetails(@PathVariable int id,@RequestBody AopModel aopModel){
        return aopService.updateAllDetails(id,aopModel);
    }
}
