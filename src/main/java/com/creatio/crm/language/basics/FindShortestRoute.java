package com.creatio.crm.language.basics;

public class FindShortestRoute {

	public static void main(String[] args) {
		
	   String path = "WWWEEE";
	   
	   System.out.println(shortestRout(path));

	}
	
	public static float shortestRout(String path) {
		float path1 = 0.0f;
		
		float x = 0 ; 
		float y = 0;
		
		for(int i = 0 ; i < path.length(); i++) {
			
			char nowGo = path.charAt(i);
			
			if(nowGo == 'N') {
				
				y++;
				
			}
			else if(nowGo == 'S') {
				
				y--;
				
			}
			else if(nowGo == 'E') {
				
				x--;
				
			}
			else {
				
				x++;
				
			}
		}
		
		double sq = Math.pow(x,2)+Math.pow(y,2);
		path1 = (float) Math.sqrt(sq);
		
		return path1;
	}

}
