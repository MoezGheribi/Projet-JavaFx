/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entite.categorie;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Moez
 */
public interface Icategorie {
   public void insert(categorie c);
   public List<categorie> selectAll2();
   public HashMap<String,Integer> selectAll();
   public void supprimer(int x);
   
}
