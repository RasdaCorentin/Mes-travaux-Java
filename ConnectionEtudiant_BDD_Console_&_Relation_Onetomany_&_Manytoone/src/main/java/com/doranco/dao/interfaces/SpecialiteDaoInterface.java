/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.doranco.dao.interfaces;

import com.doranco.entities.Specialite;
import java.util.List;

/**
 *
 * @author samha
 */
public interface SpecialiteDaoInterface {

    List<Specialite> getListeSpecialites();

    Specialite createSpecialite(Specialite specialite);

    Specialite readSpecialite(int id);

    boolean updateSpecialite(Specialite specialite, int id);

    boolean deleteSpecialite(int id);

}
