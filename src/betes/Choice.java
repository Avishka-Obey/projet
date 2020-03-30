package betes;

public class Choice {
	private Beast a  ;
	private Position pos;
	public Choice(Beast a,Position pos ) {
		this.a = a ;
		this.pos = pos;
	}
	public Position choice(Position pos,Beast a) {
		if(smell>6) {
		return pos;
		
	}

}
	// cette classe doit reperer un partenaire ideal et se deplacer vers ce partenaire dans ma grille
	//car sa caractéristique getVision 
	// est superieur a smell et a love
	//mais elle doit verifier d'autres conditions (les conditions pour se battre (fighting)
