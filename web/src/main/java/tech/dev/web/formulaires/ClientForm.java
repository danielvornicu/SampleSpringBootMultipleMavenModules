package tech.dev.web.formulaires;

import tech.dev.to.ClientTO;
import tech.dev.web.commons.base.BaseForm;

import javax.validation.Valid;

/**
 * Description de la classe
 * <p>
 * Date: 11/12/2018
 *
 * @author d.vornicu
 * @version 1.0 $Revision$ $Date$
 */

public class ClientForm extends BaseForm<ClientTO> {

    //validation by annotation @Valid (in ClientForm) vs manual validation with ValidationUtil.validData(to);
    @Valid
    private ClientTO client;

    @Override
    public void initForm(ClientTO client) {
        if(client == null)
            client = new ClientTO();
        this.client = client;
    }

    @Override
    public ClientTO saveForm() {
        return client;
    }

    public ClientTO getClient() {
        return client;
    }

    public void setClient(ClientTO client) {
        this.client = client;
    }
}
