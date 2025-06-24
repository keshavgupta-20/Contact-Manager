package ServiceImpl;

import java.sql.Connection;
import java.util.List;

import DaoImple.ContactDAO;
import Entites.Contact;
import Entites.ContactDetail;
import Service.ContactService;

public class ContactServiceImpl implements ContactService {

    private final ContactDAO contactDAO;

    public ContactServiceImpl(Connection connection) {
        this.contactDAO = new ContactDAO(connection);
    }

    public List<Contact> getAllContacts() {
        return contactDAO.getAllContacts();
    }
    
    public ContactDetail getContactById(int id) {
        return contactDAO.getContactById(id);
    }
    public boolean updateContact(ContactDetail contact) {
        return contactDAO.updateContact(contact);
    }
    public boolean addContact(ContactDetail contact) {
    return contactDAO.addContact(contact);
    }
    public boolean deleteContactById(int id) {
        return contactDAO.deleteContactById(id);
    }

    

    // You can later add addContact(), updateContact(), deleteContact(), etc.
}

