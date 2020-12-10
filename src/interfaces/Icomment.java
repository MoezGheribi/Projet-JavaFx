/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entite.comment;
import java.util.List;

/**
 *
 * @author Moez
 */
public interface Icomment {
    
    public List<comment> ListCommentaire();
    public int ajouterCommentaireForum(comment cf);
    public List<String> afficherCommentaire(int IdForum);
    public void supprimer(int x);
    
}
