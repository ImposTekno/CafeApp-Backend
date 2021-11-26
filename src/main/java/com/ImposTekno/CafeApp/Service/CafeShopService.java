package com.ImposTekno.CafeApp.Service;

import com.ImposTekno.CafeApp.CustomExceptions.ModelNotFoundException;
import com.ImposTekno.CafeApp.Model.CafeShop;
import com.ImposTekno.CafeApp.Model.Product;
import com.ImposTekno.CafeApp.Repository.CafeShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CafeShopService {
    private final CafeShopRepository cafeShopRepo;

    @Autowired
    public CafeShopService(CafeShopRepository inRepo){
        this.cafeShopRepo = inRepo;
    }

    public List<CafeShop> getAllShops()
    {
        return cafeShopRepo.findAll();
    }

    public CafeShop getShopByName(String inName)
    {
        // Same custom exception as with the product search... will be changed to global not found custom exception
        return cafeShopRepo.getBycafeName(inName).orElseThrow(()->new ModelNotFoundException("Couldn't find" + inName + " in DB"));
    }
    public CafeShop addCafeShop(CafeShop inShop)
    {
        return cafeShopRepo.save(inShop);
    }
    public List<CafeShop> addMultipleShops(List<CafeShop> inShops)
    {
       return cafeShopRepo.saveAll(inShops);
    }
    public void deleteByName(String inName)
    {
        cafeShopRepo.deleteBycafeName(inName);
    }
    public CafeShop updateShop(CafeShop inShop)
    {
        return cafeShopRepo.save(inShop);
    }

}
