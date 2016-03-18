package ru.kpfu.itis.group408.marushkai.dao;

import ru.kpfu.itis.group408.marushkai.domain.Contact;

import java.util.List;

/**
 * Created by unlim_000 on 14.03.2016.
 */
public interface ContactDAO {

    void addContact(Contact contact);

    List<Contact> listContact();

    void removeContact(Integer id);
}
