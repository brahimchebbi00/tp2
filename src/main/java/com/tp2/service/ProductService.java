package com.tp2.service;

import com.tp2.entity.Category;
import com.tp2.entity.Margin;
import com.tp2.entity.Produit;

import java.rmi.Remote;
import java.util.List;

public interface ProductService extends Remote {

    String getCategory(Produit produit, List<Category> categoryList);

    String getMargin(String category, List<Margin> margins);

    double calculPrice(Produit produit,List<Category> categoryList,List<Margin> margins);
}
