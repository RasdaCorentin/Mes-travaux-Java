
package com.doranco.dao.imp;

import com.doranco.dao.DaoFactory;
import com.doranco.dao.interfaces.CarteDaoInterface;
import com.doranco.entities.Carte;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

/**
 *
 * @author Wills Corp SARL
 */
public class CarteDaoImp implements CarteDaoInterface {

    private DaoFactory daoFactory;

    public CarteDaoImp(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public List<Carte> getListeCarte() {
        EntityManager entityManager = null;
        List<Carte> listCartes = new ArrayList<>();
        try {
            entityManager = daoFactory.getEntityManager();

            Query query = entityManager.createQuery("SELECT e FROM Carte e", Carte.class);
            listCartes = query.getResultList();
        } catch (Exception ex) {

            System.out.println("Erreur lister Cartes \n" + ex);

        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
        return listCartes;
    }

    @Override
    public Carte createCarte(Carte carte) {
        EntityManager entityManager = null;
        EntityTransaction transaction = null;
        try {
            entityManager = daoFactory.getEntityManager();
            transaction = entityManager.getTransaction();

            transaction.begin();
            entityManager.persist(carte);
            transaction.commit();
            System.out.println("<----------- Creation carte avec success ------->");
            System.out.println(carte);
            return carte;

        } catch (Exception ex) {
            transaction.rollback();
            System.out.println("Erreur creation carte \n");
            ex.printStackTrace();

        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
        return null;
    }
}
