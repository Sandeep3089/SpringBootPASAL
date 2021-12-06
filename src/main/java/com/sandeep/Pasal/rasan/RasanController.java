package com.sandeep.Pasal.rasan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@RestController

@RequestMapping ( path = "api/v1/rasan")

public class RasanController {

    private final RasanService rasanService;

    @Autowired
    public RasanController(RasanService rasanService){
        this.rasanService = rasanService;
    }

    @GetMapping
    public List<Rasan> getRasans(){
        return rasanService.getRasans();
    }

    @PostMapping
    public void addNewItem(@RequestBody Rasan rasan){
        rasanService.addNewRasan(rasan);
    }

    @DeleteMapping("/deleteRasan")
    public void deleteItem(@RequestParam Integer id){
        rasanService.deleteRasan(id);
    }

    @PutMapping(path = "{number}")
    public void updateItem(@PathVariable("number") Integer number,
                           @RequestParam(required = false) String name,
                           @RequestParam(required = false) Integer price,
                           @RequestParam(required = false) Integer quantity
                           ){
        rasanService.updateRasan(number, name, price, quantity);

    }




}
