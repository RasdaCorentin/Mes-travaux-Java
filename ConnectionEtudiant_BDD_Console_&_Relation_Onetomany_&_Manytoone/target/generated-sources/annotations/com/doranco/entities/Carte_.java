package com.doranco.entities;

import com.doranco.entities.Etudiant;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2021-12-16T16:50:58", comments="EclipseLink-2.7.7.v20200504-rNA")
@StaticMetamodel(Carte.class)
public class Carte_ { 

    public static volatile SingularAttribute<Carte, Integer> code;
    public static volatile SingularAttribute<Carte, Integer> id;
    public static volatile SingularAttribute<Carte, Etudiant> etudiant;

}