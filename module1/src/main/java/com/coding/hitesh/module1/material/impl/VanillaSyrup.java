package com.coding.hitesh.module1.material.impl;

import com.coding.hitesh.module1.material.Syrup;
import org.springframework.stereotype.Component;

@Component("VanillaSyrup")
public class VanillaSyrup implements Syrup {

    public String getSyrupType(String syrupType)
    {
        return "Vanilla Syrup";
    }
}
