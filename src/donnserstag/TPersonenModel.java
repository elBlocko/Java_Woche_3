package donnserstag;

import javax.swing.DefaultListModel;

public class TPersonenModel extends DefaultListModel<Object> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public Object getElementAt(int index) {
		TPerson person = (TPerson) super.getElementAt(index);
		return person.getPersonValues();
	}

	
	public void addElement(Object obj) {
		if (!this.contains(obj)) {
			int i = 0;

			while (i < this.size() && ((TPerson) this.get(i)).getID() <= ((TPerson) obj).getID()) {
				i++;
			}

			this.add(i, obj);
		}
	}

}
