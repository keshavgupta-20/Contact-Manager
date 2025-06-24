package Service;

import java.util.List;

import Entites.Contact;
import Entites.ContactDetail;

public interface ContactService {
	public List<Contact> getAllContacts();
	public ContactDetail getContactById(int id);
	 public boolean updateContact(ContactDetail contact);
	 public boolean addContact(ContactDetail contact);
	 
	 public boolean deleteContactById(int id);
}
