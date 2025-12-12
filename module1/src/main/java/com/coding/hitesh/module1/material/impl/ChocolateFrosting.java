package com.coding.hitesh.module1.material.impl;
import com.coding.hitesh.module1.material.Frosting;
import org.springframework.stereotype.Component;

@Component("ChocolateFrosting")
public class ChocolateFrosting implements Frosting
{
    public String getFrostingType(String frostingType)
    {
        return "Chocolate Frosting";
    }
}
