package diplom.ex.dbcrud.controllers;

import diplom.ex.dbcrud.dto.client.ClientCreateDto;
import diplom.ex.dbcrud.dto.client.ClientDto;
import diplom.ex.dbcrud.dto.client.ClientUpdateDto;
import diplom.ex.dbcrud.dto.product.ProductCreateDto;
import diplom.ex.dbcrud.dto.product.ProductDto;
import diplom.ex.dbcrud.dto.product.ProductUpdateDto;
import diplom.ex.dbcrud.mapper.ClientMapper;
import diplom.ex.dbcrud.models.Client;
import diplom.ex.dbcrud.repositories.ClientRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collections;
import java.util.List;

@Tag(name="Client Controller", description = "CRUD Client Controller")
@RestController
@RequestMapping("/clients")
public class ClientController {
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ClientMapper clientMapper;

    @Operation(
            summary = "Создание клиента",
            description = "Позволяет регистрировать клиента"
    )
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClientDto create(@RequestBody ClientCreateDto clientData){
        var client=clientMapper.map(clientData);
        clientRepository.save(client);
        var clientDto=clientMapper.map(client);
        return clientDto;
    }

    @Operation(
            summary = "Получение конкретного клиента",
            description = "Позволяет выбрать клиента"
    )
    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public ClientDto getById(@PathVariable Long id){
        var client=clientRepository.findById(id).get();
        var clientDto=clientMapper.map(client);
        return clientDto;
    }

    @Operation(
            summary = "Изменение клиента",
            description = "Позволяет изменять данные клиента (ФИО, E-mail, номер телефона)"
    )
    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public ClientDto update(@RequestBody ClientUpdateDto clientData, @PathVariable Long id){
        var client=clientRepository.findById(id).get();
        clientMapper.update(clientData,client);
        clientRepository.save(client);
        var clientDto=clientMapper.map(client);
        return clientDto;
    }

//    @GetMapping
//    @ResponseStatus(HttpStatus.OK)
//    public List<ClientDto> getAll(){
//        var clients=clientRepository.findAll();
//        var clietnDto=clientMapper.all((List)clients);
//        return clietnDto;
//    }

    @Operation(
            summary = "Удаление клиента",
            description = "Позволяет удалить аккаунт клиента"
    )
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public String delete(@PathVariable Long id){
        clientRepository.deleteById(id);
        return "Client "+id+" success deleted";
    }

//    private ClientRepository clientRepository;
//    @Autowired
//    public ClientController(ClientRepository clientRepository){
//        this.clientRepository=clientRepository;
//    }
//
//    @PostMapping(value = "/clients")
//    public ResponseEntity<?> create(@RequestBody Client client){
//        clientRepository.save(client);
//        return new ResponseEntity<>(HttpStatus.CREATED);
//    }
//
//    @GetMapping(value = "/clients")
//    public ResponseEntity<List<Client>> read(){
//         final List<Client> clients= (List<Client>) clientRepository.findAll();
//         return clients!=null && !clients.isEmpty()
//                 ? new ResponseEntity<>(clients,HttpStatus.OK)
//                 :new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }
//
//    @GetMapping(value = "/clients/{id}")
//    public ResponseEntity<Client> read(@PathVariable(name="id") int id){
//        final Client client=clientRepository.findById(id);
//        return client!=null
//                ? new ResponseEntity<>(client,HttpStatus.OK)
//                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }
//
//    @PutMapping(value = "/clients/{id}")
//    public ResponseEntity<Client> update(@PathVariable(name="id") int id, @RequestBody Client client){
//        final Client updatebleClient=clientRepository.findById(id);
//        updatebleClient.setFio(client.getFio());
//        updatebleClient.setEmail(client.getEmail());
//        updatebleClient.setPhone(client.getPhone());
//        clientRepository.save(updatebleClient);
//        return updatebleClient!=null
//                ? new ResponseEntity<>(updatebleClient,HttpStatus.OK)
//                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
//    }
//
//    @DeleteMapping(value = "/clients/delete/{id}")
//    public ResponseEntity<?> delete(@PathVariable(name="id") long id){
//        final Client deletebleClient=clientRepository.findById(id);
//        clientRepository.delete(deletebleClient);
//        return deletebleClient!=null
//                ? new ResponseEntity<>(HttpStatus.OK)
//                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }
}
