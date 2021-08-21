package in.AdityaIT.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import in.AdityaIT.Entity.Contact;
import in.AdityaIT.repository.ContactRepository;

public class ContactServiceImpl implements ContactService {

	@Autowired
	ContactRepository repo;

	@Override
	public boolean saveContact(Contact contact) {

		Contact con = new Contact();
		try {
			con = repo.save(contact);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public List<Contact> getAllContacts() {
		List<Contact> contactList = new ArrayList<Contact>();
		contactList = repo.findAll();
		return contactList;
	}

	@Override
	public Contact getContactById(Integer contactId) {
		Contact con = new Contact();
		Optional<Contact> optionalCon = repo.findById(contactId);
		if (optionalCon.isPresent())
			return optionalCon.get();
		return null;
	}

	@Override
	public boolean deleteContactById(Integer contactId) {

		repo.deleteById(contactId);

		return false;
	}

}
