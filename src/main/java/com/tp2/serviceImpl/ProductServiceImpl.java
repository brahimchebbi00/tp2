package com.tp2.serviceImpl;

import com.tp2.entity.Category;
import com.tp2.entity.Margin;
import com.tp2.entity.Produit;
import com.tp2.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

//correction de l'exercice du pricing
@Service
public class ProductServiceImpl implements ProductService {

    /**
     * Cette fonction permet de déterminer la catégorie d'un produit
     */
    @Override
    public String getCategory(Produit produit, List<Category> categoryList) {

        for (Category c : categoryList) {
            if (produit.getCost() < c.getSup() && produit.getCost() > c.getInf())
                return c.getCat();
        }
        return null;
    }
    /**
     * Cette fonction permet de déterminer la marge d'une catégorie.
     */
    @Override
    public String getMargin(String category, List<Margin> margins) {
        for (Margin m : margins) {
            if (m.getCategory().equals(category))
                return m.getMargin();
        }
        return null;
    }
    /**
     * Cette fonction permet de déterminerle prix d'un produit.
     */
    @Override
    public double calculPrice(Produit produit, List<Category> categoryList, List<Margin> margins) {
        String cat = getCategory(produit, categoryList);
        String marginStr = getMargin(cat, margins);
        double margin = 0;
        if (marginStr.contains("%")) {
            margin = Double.parseDouble(marginStr.replace("%", ""));
            margin = margin / 100;
        } else {
            margin = Double.parseDouble(marginStr);
        }
        return produit.getCost() * (1 + margin);
    }
}
