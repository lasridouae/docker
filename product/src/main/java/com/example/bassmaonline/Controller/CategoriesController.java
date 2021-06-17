package com.example.bassmaonline.Controller;


import com.example.bassmaonline.entity.CategoriesEntity;
import com.example.bassmaonline.service.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping(value = "/categories")
@CrossOrigin(origins = "*")
public class CategoriesController {

    @Autowired
    CategoriesService categoriesService;
    @PostMapping
    public ResponseEntity<CategoriesEntity> createCategories(@RequestBody CategoriesEntity categoriesEntity) {
        CategoriesEntity Categories = categoriesService.createCategories(categoriesEntity);
        return new ResponseEntity<>(Categories, HttpStatus.CREATED);
    }

    @PutMapping(path = "/{cateId}")
    public ResponseEntity<CategoriesEntity>  UpdateCategories(@RequestBody CategoriesEntity categoriesEntity, @PathVariable Long cateId){
        CategoriesEntity Categories = categoriesService.updateCategories(cateId, categoriesEntity);
        return new ResponseEntity<>(Categories, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/Removecat/{idCat}")
    public ResponseEntity<CategoriesEntity> removeCategories(@PathVariable Long idCat) {
        categoriesService.deleCategories(idCat);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @GetMapping("/getCategories")
    public List<CategoriesEntity> findAlCategories() {
        return categoriesService.getCategories();
    }

    @GetMapping("/getCategoriesById/{idCat}")
    public ResponseEntity<CategoriesEntity> findCategoriesById(@PathVariable Long idCat) {
        CategoriesEntity Categories = categoriesService.getCategoriesById(idCat);
        return new ResponseEntity<>(Categories, HttpStatus.OK);
    }


}
