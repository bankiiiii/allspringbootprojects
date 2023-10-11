package com.rkProductManager.productManager.util;

import com.rkProductManager.productManager.model.Product;

public interface CalculationUtil
{
    public static void blogic(Product p)
    {
        Double cost = p.getProdCost();
        p.setProdDis(cost * 12/100);
        p.setProdGst(cost * 18/100);

    }
}
