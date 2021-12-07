package com.ImposTekno.CafeApp.Controllers;

import com.ImposTekno.CafeApp.Model.CafeShop;
import com.ImposTekno.CafeApp.Service.CafeShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/shops")
public class CafeShopController {
    private final CafeShopService cafeService;

    @Autowired
    public CafeShopController (CafeShopService inServ)
    {
        this.cafeService = inServ;
    }

    @GetMapping("/all")
    public ResponseEntity<List<CafeShop>> getAllShops()
    {
        List<CafeShop> allShops = cafeService.getAllShops();
        return new ResponseEntity<>(allShops, HttpStatus.OK);
    }

    @GetMapping("/find/{name}")
    public ResponseEntity<CafeShop> getShopByName(@PathVariable("name") String inName)
    {
        CafeShop cShop = cafeService.getShopByName(inName);
        return new ResponseEntity<>(cShop,HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<CafeShop> addShop(@RequestBody CafeShop inShop)
    {
        CafeShop newCafe = cafeService.addCafeShop(inShop);
        return new ResponseEntity<>(newCafe, HttpStatus.CREATED);
    }
    @PostMapping("/multiple")
    public ResponseEntity<List<CafeShop>> addMultipleShops(@RequestBody List<CafeShop> shops)
    {
        List<CafeShop> newShops = cafeService.addMultipleShops(shops);
        return new ResponseEntity<>(newShops, HttpStatus.CREATED);
    }
    @PutMapping("/update")
    public ResponseEntity<CafeShop> updateShop(@RequestBody CafeShop inShop)
    {
        CafeShop updatedShop = cafeService.updateShop(inShop);
        return new ResponseEntity<>(updatedShop, HttpStatus.OK);
    }


    @DeleteMapping("/delete/{name}")
    public ResponseEntity<CafeShop> deleteByName(@PathVariable("name") String inName)
    {
         cafeService.deleteByName(inName);
         return new ResponseEntity<>(HttpStatus.OK);
    }

}
