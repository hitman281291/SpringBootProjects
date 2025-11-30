package com.coding.hitesh.module1.bakery;

import com.coding.hitesh.module1.enums.Frost;
import org.springframework.beans.factory.annotation.Autowired;
import com.coding.hitesh.module1.material.Syrup;
import com.coding.hitesh.module1.material.Frosting;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class CakeBaker
{
//    @Autowired
//    @Qualifier("chocolateSyrup")
    private final Map<String, Syrup> syrup;

//    @Autowired
//    @Qualifier("chocolateFrosting")
    private final Map<String, Frosting> frosting;

    public CakeBaker(Map<String, Syrup> syrup, Map<String, Frosting> frosting){
        this.syrup = syrup;
        this.frosting = frosting;
    }

    public void bakeCake(String frostType, String syrupType)
    {
//        System.out.println("Your request: "+frostType+","+syrupType);
        Syrup syrupImpl = syrup.get(syrupType);
        Frosting frostingImpl = frosting.get(frostType);

        System.out.println("Cake is baked using "+frostingImpl.getFrostingType(frostType)+" and "+syrupImpl.getSyrupType(syrupType));

    }


}
