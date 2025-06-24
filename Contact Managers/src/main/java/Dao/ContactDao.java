package Dao;

import java.util.List;

import Entites.Contact;
import Entites.ContactDetail;

public interface ContactDao {
	public ContactDetail getContactById(int id);
	public List<Contact> getAllContacts();
	public boolean addContact(ContactDetail contact);
	public boolean deleteContactById(int id);
	 public boolean updateContact(ContactDetail contact);
	
}
