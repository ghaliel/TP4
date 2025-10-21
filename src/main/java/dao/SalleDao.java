package dao;

import entities.Salle;

public class SalleDao extends DaoImpl<Salle> {
    @Override
    protected Class<?> getEntityClass() {
        return Salle.class;
    }
}

