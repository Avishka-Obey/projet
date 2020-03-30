package betes;

public class ChoiceLove implements InterfaceChoice {
	private Beast b ;
	private Map m ; 
	private Beast b2;
	private Wedding w;
	
	
	public void move(Beast b , Map m) {
		if((b.getAnt().getLove()>b.getAnt().getSmell())&&(b.getAnt().getLove()>b.getAnt().getVision())) {
			for (int i=0;i<=m.size();i++) {
				if(b.getGender()!= b2.getGender()) {
					if(!(w.alreadymaried(b,b2))&& b.getEnergy().getEnergy()>10){
						b.getPositon().getX().getY()= b2.position();
						
					}
						
					}
					
				}
		}
		
	}
	}
// cette classe doit reperer un partenaire ideal et se deplacer vers ce partenaire 
//car sa caractéristique getLove 
// est superieur a smell et a vision 
//mais elle doit verifier d'autres conditions (les conditions du mariage)

