package data;

/**
 * Cette interface permet de définir ce qu'est un objet (une image, une position et un type)
 * @author cerini.enzo@gmail.com avishka2007@gmail.com rayane.dendoune@gmail.com 
 */

import java.awt.Image;

public interface Item {

	
	public Image getImage();
	public Position getPosition();
	public String getStringType();
}
