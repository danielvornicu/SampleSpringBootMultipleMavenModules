package tech.dev.db;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import tech.dev.entities.Client;

import java.util.Arrays;
import java.util.List;

/**
 * Description de la classe
 * <p>
 * Date: 03/03/2020
 *
 * @author d.vornicu
 * @version 1.0 $Revision$ $Date$
 */

@Component
public class DbSeeder implements CommandLineRunner {

    private ClientRepository clientRepository;

    //must add @Autowired annotation if Spring Boot <= 1.3
    public DbSeeder(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public void run(String... strings) throws Exception {
        Client client1 = new Client(
                "DANIEL",
                "VORNICU"
//                new Adresse("127 Avenue Jean Jaures", "Appt 101", 92140, "CLAMART"),
//                Arrays.asList(
//                        new Commande(2, 150L, new Date()),
//                        new Commande(3, 200L, new Date())
//                )
        );

        Client client2 = new Client(
                "ALINA",
                "VORNICU"
//                new Adresse("127 Avenue Jean Jaures", "Appt 101", 92140, "CLAMART"),
//                Arrays.asList(
//                        new Commande(1, 100L, new Date())
//                )
        );

        Client client3 = new Client(
                "LUCA",
                "VORNICU"
//                new Adresse("127 Avenue Jean Jaures", "Appt 101", 92140, "CLAMART")
        );

        Client client4 = new Client(
                "SOFIA",
                "VORNICU"
//                new Adresse("127 Avenue Jean Jaures", "Appt 101", 92140, "CLAMART")
        );

        Client client5 = new Client(
                "ERIC",
                "SIBER"
//                new Adresse("16 rue des lilas d''Espagne", "Appartement 12", 92400, "Courbevoie")
        );

        // supprime tous les clients
        this.clientRepository.deleteAll();

        //ajout les clients dans la base de données
        List<Client> clients = Arrays.asList(client1, client2, client3, client4, client5);
        this.clientRepository.saveAll(clients);
    }
}
