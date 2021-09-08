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
	
	public TMyObjectList (/*List<TMyObject> AMyObjectList*/) {
		this.FMyObjectList = AMyObjectList;
	}
//
//	@Override
//	public int size() {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	@Override
//	public boolean isEmpty() {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public boolean contains(Object o) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public Iterator<TMyObject> iterator() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Object[] toArray() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public <T> T[] toArray(T[] a) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public boolean add(TMyObject e) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public boolean remove(Object o) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public boolean containsAll(Collection<?> c) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public boolean addAll(Collection<? extends TMyObject> c) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public boolean addAll(int index, Collection<? extends TMyObject> c) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public boolean removeAll(Collection<?> c) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public boolean retainAll(Collection<?> c) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public void clear() {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public TMyObject get(int index) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public TMyObject set(int index, TMyObject element) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public void add(int index, TMyObject element) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public TMyObject remove(int index) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public int indexOf(Object o) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	@Override
//	public int lastIndexOf(Object o) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	@Override
//	public ListIterator<TMyObject> listIterator() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public ListIterator<TMyObject> listIterator(int index) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public List<TMyObject> subList(int fromIndex, int toIndex) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//	
	
	
	
}
