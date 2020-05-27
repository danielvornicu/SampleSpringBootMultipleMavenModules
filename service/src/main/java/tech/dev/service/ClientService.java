package tech.dev.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tech.dev.commons.service.base.AbstractCRUDServiceBase;
import tech.dev.commons.to.base.convertor.TOConvertor;
import tech.dev.db.ClientRepository;
import tech.dev.entities.Client;
import tech.dev.to.ClientTO;
import tech.dev.to.convertor.ClientTOConvertor;

import java.util.List;
import java.util.Optional;

/**
 * Description de la classe
 * <p>
 * Date: 04/03/2020
 *
 * @author d.vornicu
 * @version 1.0 $Revision$ $Date$
 */

@Service
public class ClientService extends AbstractCRUDServiceBase<Client, ClientTO> {
    private ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    protected TOConvertor<Client, ClientTO> getConvertor() {
        if (convertor == null) {
            convertor = new ClientTOConvertor();
        }
        return (ClientTOConvertor) convertor;
    }


    public List<Client> findAll() {
        return this.clientRepository.findAll();
    }

    public List<ClientTO> findAllFillTO() {
        List<Client> entityList = this.clientRepository.findAll();

        //convertor
        List<ClientTO> TOlist = getConvertor().entityList2TOList(entityList, false);

        return TOlist;
    }

    @Transactional(readOnly = true)
    public Client findById(Long id) {
        Optional<Client> client = this.clientRepository.findById(id);
        if (client.isPresent()) {
            return client.get();
        } else {
            return null;
        }
    }

    @Transactional(readOnly = true)
    public ClientTO findByIdFillTO(Long id) {
        Optional<Client> client = this.clientRepository.findById(id);
        if (client.isPresent()) {
            //convertor
            ClientTO to = getConvertor().entity2TO(client.get(), false);
            return to;
        } else {
            return null;
        }
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void save(Client client, boolean isCreation) {
        if (isCreation) {
            this.clientRepository.save(client);
        } else{
            this.clientRepository.save(client);
        }
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void saveTO(ClientTO to, boolean isCreation) {
        Client client = null;
        // On récupère les données de la base avant de merger pour modifier uniquement ce qui provient du TO
        if (!isCreation) {
            client = findById(to.getId());
        }

        try{
            //convertor
            client = getConvertor().fillEntity(to, client);
        } catch (Exception e) {}

        if (isCreation) {
            this.clientRepository.save(client);
        } else{
            this.clientRepository.save(client);
        }
    }

    @Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NullPointerException.class)
    public void deleteClientByClientId(Long id){
        this.clientRepository.deleteById(id);
    }

}
