package DaoImple;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Dao.ContactDao;
import Dao.UserDao;
import Entites.Contact;
import Entites.ContactDetail;
import Entites.User;

public class ContactDAO implements ContactDao {

    private Connection conn;

    public ContactDAO(Connection conn) {
        this.conn = conn;
    }
    


    public List<Contact> getAllContacts() {
        List<Contact> contacts = new ArrayList<>();
        try {
        	String sql = "SELECT id, name, email, phone FROM contacts";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                contacts.add(new Contact(
                	rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("email"),
                    rs.getString("phone")
                ));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return contacts;
    }
    public ContactDetail getContactById(int id) {
        ContactDetail contact = null;
        try {
            String sql = "SELECT * FROM contacts WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                contact = new ContactDetail(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("email"),
                    rs.getString("phone"),
                    rs.getString("address"),
                    rs.getDate("birthday"),
                    rs.getString("contact_group")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return contact;
    }
    public boolean updateContact(ContactDetail contact) {
        boolean updated = false;
        String sql = "UPDATE contacts SET name=?, email=?, phone=?, address=?, birthday=?, contact_group=? WHERE id=?";


        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, contact.getName());
            stmt.setString(2, contact.getEmail());
            stmt.setString(3, contact.getPhone());
            stmt.setString(4, contact.getAddress());
            stmt.setDate(5, contact.getBirthday());
            stmt.setString(6, contact.getGroup());
            stmt.setInt(7, contact.getId());

            updated = stmt.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return updated;
    }
    public boolean addContact(ContactDetail contact) {
        boolean success = false;
        try {
            String sql = "INSERT INTO contacts (name, email, phone, address, birthday, contact_group) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, contact.getName());
            stmt.setString(2, contact.getEmail());
            stmt.setString(3, contact.getPhone());
            stmt.setString(4, contact.getAddress());
            stmt.setDate(5, contact.getBirthday());
            stmt.setString(6, contact.getGroup());

            int rows = stmt.executeUpdate();
            success = (rows > 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return success;
    }
    public boolean deleteContactById(int id) {
        boolean success = false;
        try {
            String sql = "DELETE FROM contacts WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            int rows = stmt.executeUpdate();
            success = (rows > 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return success;
    }

	
	

}
