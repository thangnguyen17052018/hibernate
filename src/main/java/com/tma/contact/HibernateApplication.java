package com.tma.contact;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

public class HibernateApplication {

    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        // Configures settings from hibernate.cfg.xml
        final ServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        return new MetadataSources(registry).buildMetadata().buildSessionFactory();

    }

    public static void main(String[] args) {
        Contact contactThang = Contact.builder()
                .firstName("Thang")
                .lastName("Nguyen")
                .email("nminhthang@tma.com.vn")
                .phone(9296387898L)
                .build();
        Contact contactHoang = Contact.builder()
                .firstName("Hoang")
                .lastName("Pham")
                .email("phoang@tma.com.vn")
                .phone(9221241498L)
                .build();

//        saveByPersist(contactThang);
//        saveByPersist(contactThang);
//        saveByPersist(contactHoang);

//        int idThang = saveBySave(contactThang);
//        int idThang1 = saveBySave(contactThang);
//        int idHoang = saveBySave(contactHoang);

//        System.out.println(idThang + " - " + idHoang);

    }

    private static void saveByPersist(Contact contact){
        //Open a session
        Session session = sessionFactory.openSession();
        //Begin a transaction
        session.beginTransaction();
        //Use the session to save the contact
        session.persist(contact);
        //Commit the transaction
        session.getTransaction().commit();
        //Close the session
        session.close();
    }

    private static int saveBySave(Contact contact){
        //Open a session
        Session session = sessionFactory.openSession();
        //Begin a transaction
        session.beginTransaction();
        //Use the session to save the contact
        int id = (int) session.save(contact);
        //Commit the transaction
        session.getTransaction().commit();
        //Close the session
        session.close();

        return id;
    }

}
