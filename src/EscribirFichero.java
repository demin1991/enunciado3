package clasesCompartidas;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

//Aquesta classe simplement li passes un HashMap<Integer,<ArrayList<Integer>>> i et reescriu el document

public class EscribirFichero {
	
	//a == 1 és un fitxer on la primera en ordre és la clau i la segona les relacionades amb ella
	//i si a == 0 és la inversa
	public static void ReescribirFicheroRelaciones(HashMap<Integer,ArrayList<Integer>> n, int Tipus){
		try{
			FileWriter fw;
			if (Tipus == 0) fw = new FileWriter("/home2/users/alumnes/1193773/dades/DBLP_four_area/paper_author.txt",false);
			else if (Tipus == 1) fw = new FileWriter("/home2/users/alumnes/1193773/dades/DBLP_four_area/paper_conf.txt",false);
			else  fw = new FileWriter("/home2/users/alumnes/1193773/dades/DBLP_four_area/paper_term.txt",false);
		    Iterator<Entry<Integer, ArrayList<Integer>>> it = n.entrySet().iterator();
		    while (it.hasNext()) {
				Map.Entry<Integer, ArrayList<Integer>> e = it.next();
				ArrayList<Integer> b = new ArrayList<Integer>();
				int a = e.getKey();
				b = e.getValue();
				for (int j = 0; j < b.size(); j++){
					fw.write(a + "\t"+ b.get(j) + "\r\n");
				}
			}
			fw.close();
		}catch(IOException e){
			System.out.println("Error de:"+e);
		}
	}
	
	public static void ReescribirFicheroNodos(HashMap<Integer,Nodo> n, int Tipus){
		try{
			FileWriter fw;
			if (Tipus == 0) fw = new FileWriter("/home2/users/alumnes/1193773/dades/DBLP_four_area/paper.txt",false);
			else if (Tipus == 1) fw = new FileWriter("/home2/users/alumnes/1193773/dades/DBLP_four_area/author.txt",false);
			else if (Tipus == 2)  fw = new FileWriter("/home2/users/alumnes/1193773/dades/DBLP_four_area/conf.txt",false);
			else fw = new FileWriter("/home2/users/alumnes/1193773/dades/DBLP_four_area/term.txt",false);
		    Iterator<Entry<Integer,Nodo>> it = n.entrySet().iterator();
		    while (it.hasNext()) {
				Map.Entry<Integer, Nodo> e = it.next();
				Nodo b = new Nodo();
				int a = e.getKey();
				b = e.getValue();
				fw.write(a + "\t"+ b.consultar_nombre() + "\r\n");
			}
			fw.close();
		}catch(IOException e){
			System.out.println("Error de:"+e);
		}
	}
	
	
	
	public static void main(String[] args){
		HashMap<Integer,ArrayList<Integer>> r = new HashMap<Integer,ArrayList<Integer>>();
		ReescribirFicheroRelaciones(r,2);
	}
}

