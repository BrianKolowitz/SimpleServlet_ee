/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infsci2560.simpleServlet.persistence;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author kolowitzbj
 */
@Local
public interface SsMessageFacadeLocal {

    void create(SsMessage ssMessage);

    void edit(SsMessage ssMessage);

    void remove(SsMessage ssMessage);

    SsMessage find(Object id);

    List<SsMessage> findAll();

    List<SsMessage> findRange(int[] range);

    int count();
    
}
