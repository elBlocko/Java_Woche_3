package mittwoch;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

/*
 procedure TBearbeitenFrm.addOrte(EingabeText: string);
var
  oOrte: TOrt;
  regEx: TRegEx;
begin
  if Trim(EingabeText) = EmptyStr then
  begin
    Form1.warnTextMissing;
    Exit
  end;
  regEx := regExText(EingabeText);
  for oOrte IN OrteListe1.Values do
    if regEx.IsMatch(oOrte.Name) then
    begin
      Form1.warnAlreadyExists;
      Exit;
    end;
    
    
    
  oOrte := TOrt.Create(-1, EingabeText);
  oOrte.Save;
  OrteListe1.Add(oOrte.ID, oOrte);
end;

*/
public class TMyObjectList extends ArrayList<TMyObject> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1157834679233299873L;
	List<TMyObject> FMyObjectList;

	public TMyObjectList(List<TMyObject> AMyObjectList) {
		this.FMyObjectList = AMyObjectList;
	}

	public void setMyObjects(String filename) {
		TMyObject tempMyObject;
		int tempId;
		String tempName;
		String daten; 
		String[] werte;		
		
		Scanner scan = null;
		try {
		    scan = new Scanner(new File(filename));
		} catch (FileNotFoundException e) {
		    e.printStackTrace();
		}
		while (scan.hasNext()) {		   		   
		   daten = scan.next();		   
		   werte = daten.split(";");
		   String a = werte[0];
		   tempId =  Integer.parseInt(a); 
		   tempName = werte[1];
		   tempMyObject = new TMyObject(tempId,tempName); // Objekt erzeugen
		   this.add(tempMyObject); // Objekt zur Liste hinzufügen
		}
		scan.close();

	}

}
