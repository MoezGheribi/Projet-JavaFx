/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;


import entite.forum;
import java.util.List;

/**
 *
 * @author Moez
 */
public interface Iforum {
    public boolean insert(forum f);
    public List<forum> selectAll(int idCategorie);
    public void supprimer(int x);
    public List<forum> ListQuestion();
    
}
