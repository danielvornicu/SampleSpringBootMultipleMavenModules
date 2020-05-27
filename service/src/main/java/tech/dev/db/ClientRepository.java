package tech.dev.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.dev.entities.Client;

/**
 * Client repository
 * <p>
 * Date: 03/03/2020
 *
 * @author d.vornicu
 * @version 1.0 $Revision$ $Date$
 */

@Repository
public interface ClientRepository extends JpaRepository<Client,Long> {
}
