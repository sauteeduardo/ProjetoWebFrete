/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.entity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author OWS-NEWHP
 */
@Stateless
public class CaminhaoFacade extends AbstractFacade<Caminhao> {

    @PersistenceContext(unitName = "ProjetoWebFretePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CaminhaoFacade() {
        super(Caminhao.class);
    }
    
}
