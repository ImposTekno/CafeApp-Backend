package com.ImposTekno.CafeApp.Repository;

import com.ImposTekno.CafeApp.Model.CafeShop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface CafeShopRepository extends JpaRepository<CafeShop,Long> {

    Optional<CafeShop> getBycafeName(String inName);

    @Transactional
    public void deleteBycafeName(String inName);

}
