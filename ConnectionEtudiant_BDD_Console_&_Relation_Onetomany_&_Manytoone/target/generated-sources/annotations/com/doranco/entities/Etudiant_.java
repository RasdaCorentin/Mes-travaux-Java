package com.doranco.entities;

import com.doranco.entities.Carte;
import com.doranco.entities.Specialite;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2021-12-16T16:50:58", comments="EclipseLink-2.7.7.v20200504-rNA")
@StaticMetamodel(Etudiant.class)
public class Etudiant_ { 

    public static volatile SingularAttribute<Etudiant, Specialite> specialite;
    public static volatile SingularAttribute<Etudiant, Carte> carte;
    public static volatile SingularAttribute<Etudiant, Integer> id;
    public static volatile SingularAttribute<Etudiant, String> nom;
    public static volatile SingularAttribute<Etudiant, String> prenom;

}