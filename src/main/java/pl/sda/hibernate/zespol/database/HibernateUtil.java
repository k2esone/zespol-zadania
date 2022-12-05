package pl.sda.hibernate.zespol.database;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {

    public static final HibernateUtil INSTANCE = new HibernateUtil();
    private final SessionFactory sessionFactory;

    public HibernateUtil() {
        this.sessionFactory = loadConfigFile();
    }

    private SessionFactory loadConfigFile() {

        StandardServiceRegistry standardServiceRegistry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml") // <-- jesli nie podamy nazwy - ustawi sie domyslna
                .build();

        Metadata metadata = new MetadataSources(standardServiceRegistry).getMetadataBuilder().build();

        return metadata.getSessionFactoryBuilder().build();
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
