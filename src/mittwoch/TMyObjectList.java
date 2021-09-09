package mittwoch;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

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
public class TMyObjectList extends ArrayList<TMyObject>{
		
	List<TMyObject> FMyObjectList;
	
	public TMyObjectList (List<TMyObject> AMyObjectList) {
		this.FMyObjectList = AMyObjectList;
	}

	
	
	
}
