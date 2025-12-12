package com.coding.hitesh.module1.material.impl;
import com.coding.hitesh.module1.material.Frosting;
import org.springframework.stereotype.Component;

@Component("VanillaFrosting")
public class VanillaFrosting implements Frosting
{
    public String getFrostingType(String frostingType)
    {
        return "Vanilla Frosting";
    }
}
