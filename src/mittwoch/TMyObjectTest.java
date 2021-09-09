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
		ObjectList2.add(new TMyObject()); // leeres Objekt mit
		
		// TODO: ObjectList2.Max.Id 
	}

}
