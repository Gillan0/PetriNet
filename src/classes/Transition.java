package classes;

import java.util.ArrayList;

import arcs.ArcPT;
import arcs.ArcTP;

public class Transition {
	private ArrayList<ArcTP> arcsTP;
	private ArrayList<ArcPT> arcsPT;
	
	public Transition() {
		// TODO Auto-generated constructor stub
	}
	
	public void addArcTP(ArcTP a) {
		if (a != null) {
			this.arcsTP.add(a);
		}
	}
	
	public void addArcPT(ArcPT a) {
		if (a != null) {
			this.arcsPT.add(a);
		}
	}
	
	public ArrayList<ArcTP> getArcsTP() {
		return this.arcsTP;
	}
	
	public ArrayList<ArcPT> getArcsPT() {
		return this.arcsPT;
	}
	
	public void removeArcTP(ArcTP a) {
		if (a != null) {
			this.arcsTP.remove(a);
		}
	}
	
	public void removeArcPT(ArcPT a) {
		if (a != null) {
			this.arcsPT.remove(a);
		}
	}
	

}
