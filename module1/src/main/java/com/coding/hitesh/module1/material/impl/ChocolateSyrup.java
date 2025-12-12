package com.coding.hitesh.module1.material.impl;

import com.coding.hitesh.module1.material.Syrup;
import org.springframework.stereotype.Component;

@Component("ChocolateSyrup")
public class ChocolateSyrup implements Syrup {

    public String getSyrupType(String syrupType)
    {
        return "Chocolate Syrup";
    }
}
