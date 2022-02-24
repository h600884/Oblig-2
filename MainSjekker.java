package no.hvl.dat102.tabell;

import no.hvl.dat102.adt.*;
public class MainSjekker implements Parentessjekker{
	
	public MainSjekker() {
		
	}

	@Override
	public boolean erVenstreParentes(char p) {
		if(p == '(' || p == '{' || p == '[') {
			return true;
		} else 
			return false;
	}

	@Override
	public boolean erHogreParentes(char p) {
		if(p == ')' || p == '}' || p == ']') {
			return true;
		} else 
			return false;
	}

	@Override
	public boolean erParentes(char p) {
		if(erVenstreParentes(p) || erHogreParentes(p)) {
			return true;
		} else 
			return false;
	}

	@Override
	public boolean erPar(char venstre, char hogre) {
		boolean par = false;
		if(venstre == '(' && hogre == ')') {
			par = true;
		} else if(venstre == '{' && hogre == '}') {
			par = true;
		} else if(venstre == '[' && hogre == ']') {
			par = true;
		} else {
			par = false;
		}
		return par;
	}

	@Override
	public boolean erBalansert(String s) {
		StabelADT<Character> stabel = new TabellStabel<>();
		
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
				if(erVenstreParentes(c)) {
					stabel.push(c);
				} else if(erHogreParentes(c)) {
					
					if(stabel.erTom() || !erPar(stabel.pop(), c)){
						return false;
					}
				}				
		}
		
		if(!stabel.erTom()) {
		return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
	MainSjekker sta = new MainSjekker();
	String i = "";
	String o = "({[ ]})";
	String p = "(()";
	String k = "(dsakjl[dsakldas]dsa)";
	String m = "{(dadsa) dadsa]";
	System.out.println(sta.erBalansert(i));
	System.out.println(sta.erBalansert(o));
	System.out.println(sta.erBalansert(p));
	System.out.println(sta.erBalansert(k));
	System.out.println(sta.erBalansert(m));
	}

}
