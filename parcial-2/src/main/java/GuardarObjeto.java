import org.hibernate.HibernateException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

public class GuardarObjeto<T> {
    /**
     * Funcion que se le pasa un objeto y la salva a la base de datos
     * @param entity
     */
    public void save(Object entity) {
        Session session = HibernateUtil.getSessionFactory().openSession();


        try {
            session.beginTransaction();
            session.save(entity);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            if (session.getTransaction() == null)
                session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            session.clear();

        }
    }

    /**
     * Funcion que se le pasa un objeto y lo actualiza a la base de datos
     * @param entity
     */
    public void update(Object entity) {
        Session session = HibernateUtil.getSessionFactory().openSession();



        try {

            session.beginTransaction();
            session.update(entity);
            session.flush();
            session.getTransaction().commit();

        } catch (HibernateException e) {

            if (session.getTransaction() == null)
                session.getTransaction().rollback();
            e.printStackTrace();

        } finally {
            session.close();

        }
    }

    /**
     * Funcion que se le pasa un objeto y lo borra de la base de datos
     * @param entity
     */
    public void delete(Object entity) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            session.beginTransaction();
            session.delete(entity);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            if (session.getTransaction() == null)
                session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    /**
     * Funcion que hace un merge al objeto existente en la base de datos
     * @param entity
     */
    public void merge(Object entity) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            session.beginTransaction();
            session.merge(entity);
            session.flush();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            if (session.getTransaction() == null)
                session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    /**
     * Funcion que retorna una lista de objetos especificada
     * @param q
     * @return
     */
    public List<T> findMany(String q) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            List<T> t;
            Query query = session.createQuery(q);
            t = (List<T>) query.list();
            return t;
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return null;
    }

    /**
     * Funcion que retorna una lista de todos los objetos en la base de datos de la entidad especificada
     * @param clazz
     * @return
     */
    public List<T> findAll(Class clazz) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            List objectList = null;
            Query query = session.createQuery("from " + clazz.getName());
            objectList = query.list();
            return objectList;
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return null;
    }

    /**
     * Funcion que retorna un objeto buscado por su id
     * @param clazz
     * @param id
     * @return
     */
    public T findByID(Class clazz, Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            T t = null;
            t = (T) session.get(clazz, id);
            return t;
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return null;
    }

    /**
     * Funcion que retorna un solo objeto especificado via query
     * @param q
     * @return
     */
    public T findOne(String q) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Query query = session.createQuery(q);
            T t;
            t = (T) query.uniqueResult();
            return t;
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return null;
    }
}