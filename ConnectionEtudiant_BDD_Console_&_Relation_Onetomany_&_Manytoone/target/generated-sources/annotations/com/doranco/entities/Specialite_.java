package com.doranco.entities;

import com.doranco.entities.Etudiant;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2021-12-16T16:50:58", comments="EclipseLink-2.7.7.v20200504-rNA")
@StaticMetamodel(Specialite.class)
public class Specialite_ { 

    public static volatile ListAttribute<Specialite, Etudiant> listeEtudiants;
    public static volatile SingularAttribute<Specialite, String> titre;
    public static volatile SingularAttribute<Specialite, String> description;
    public static volatile SingularAttribute<Specialite, Integer> id;

}