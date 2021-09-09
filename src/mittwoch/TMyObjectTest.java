package mittwoch;

import java.util.ArrayList;
import java.util.List;

public class TMyObjectTest {


	public static void main(String[] args) {
		
		// VARIANTE 1: ObjektListe vom Typ MyObject erzeugen, auf die Methoden von List zugreifen 
		List<TMyObject> ObjectList1 = new ArrayList<TMyObject>();
		ObjectList1.add(new TMyObject());
		
		
		// VARIANTE 2: Eigene Klasse TMyObjectList erstellen und List implementieren
		// Möglichkeit eigene Methoden hinzuzufügen
		TMyObjectList ObjectList2; // neue Liste deklariert
		
		ObjectList2 = new TMyObjectList(new ArrayList<TMyObject>());
//		ObjectList2.add(new TMyObject()); // leeres Objekt mit
		ObjectList2.setMyObjects("C:\\Users\\Platz 1100\\Desktop\\Meine\\eclipse\\Database\\myObjectList.txt");
		
		
		// Auf einen Wert an Stelle i zugreifen
		for (int i = 0; i < ObjectList2.size(); i++) {
			ObjectList2.get(i).getID();
			ObjectList2.get(i).getName();			
		}
		
		// gesamte Liste durchgehen
		for (TMyObject tempObject : ObjectList2) {
				tempObject.getID();
				tempObject.getName();
		}
		
		
	}

}
