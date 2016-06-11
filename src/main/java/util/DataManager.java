package util;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.ScrollMode;
import org.hibernate.ScrollableResults;
import org.hibernate.Session;


/**
 * Created by gram on 24/03/16.
 */
public class DataManager {
    private static final Logger logger = LogManager.getLogger(DataManager.class);
    private Criteria criteria;
    private Session session;
    private Class data;

    //TODO: make this typed, like DataManager<class> foobar
    DataManager(Class data) {
        this.data = data;
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        criteria = session.createCriteria(data);
    }

    private void commit() {
        session.getTransaction().commit();
        HibernateUtil.getSessionFactory().close();
    }

    ObservableList observableList(Class cls) {

        criteria.setFirstResult(0);
        criteria.setMaxResults(1000);

        //String hql = "from " + obj.getClass().getName();
        //Query query = session.createQuery(hql);
        //query.setMaxResults(10);
        ObservableList result = FXCollections.observableArrayList(criteria.list());

        session.getTransaction().commit();
        HibernateUtil.getSessionFactory().close();
        return result;
    }

    //implement closure around callback function
    void scrollOverResults(CallBack callback) {
        criteria.setReadOnly(true);
        criteria.setFetchSize(100);
        ScrollableResults scrollable = criteria.scroll(ScrollMode.FORWARD_ONLY);
        callback.Scrollable(scrollable);
        scrollable.close();
        commit();
    }

}
