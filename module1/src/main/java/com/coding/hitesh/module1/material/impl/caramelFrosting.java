package com.coding.hitesh.module1.material.impl;
import com.coding.hitesh.module1.material.Frosting;
import org.springframework.stereotype.Component;

@Component("caramelFrosting")
public class caramelFrosting implements Frosting
{
    public String getFrostingType(String frostingType)
    {
        return "Carmel Frosting";
    }
}
