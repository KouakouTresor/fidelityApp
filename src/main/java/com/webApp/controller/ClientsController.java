package com.webApp.controller;

import com.webApp.clientsService.ClientsService;
import com.webApp.clientsService.ClientsServiceImpl;
import com.webApp.model.Clients;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/clients")

@RestController
@Slf4j
public class ClientsController {

    @Autowired
    ClientsServiceImpl clientsServiceImpl;

    @PostMapping(value="/insert", produces ="application/json")
    public ResponseEntity<Mono<Clients>> insertCli(@RequestBody Clients newClient) {
        log.info("******* INSERT A CLIENT *******");
        Mono<Clients> client = clientsServiceImpl.SaveClient(newClient);
        return new ResponseEntity<Mono<Clients>>(client, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/delete/{id}", produces = "application/json")
   public ResponseEntity<Mono<Void>> deleteClient(@PathVariable("id") String id){
        log.info("******* DELETE A CLIENT *******");
        return new ResponseEntity<Mono<Void>> (clientsServiceImpl.DeleteClient(id), HttpStatus.OK);
    }


    @RequestMapping(value="/search_all", method = RequestMethod.GET, produces ="application/json")

    public  ResponseEntity<Flux<Clients>>  selectAll(){
        log.info("******* GET ALL CLIENTS *******");
        Flux<Clients> clients = clientsServiceImpl.SelectAll()
            .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND, "Clients not found")));
        return new ResponseEntity<Flux<Clients>>(clients, HttpStatus.OK);
    }

    @RequestMapping(value = "/search_id/{id}", method = RequestMethod.GET, produces ="application/json")
    public ResponseEntity<Mono<Clients>> selectClient(@PathVariable("id") String id ){
        log.info("******* GET USER BY ID *******");
        Mono<Clients> client = clientsServiceImpl.SelectClient(id);
        return new ResponseEntity<Mono<Clients>>(client, HttpStatus.OK);

    }

    @RequestMapping(value="/search_fcode/{code}", method = RequestMethod.GET, produces ="application/json")
    public ResponseEntity<Mono<Clients>> selectByFidelityCode(@PathVariable("code") String code){
        log.info("******* GET USER BY CODE FIDELITY"+ code + "*******");
        Mono<Clients> client = clientsServiceImpl.FindByFidelityCode(code)
         .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND, "Clients not found")));
        return new ResponseEntity<Mono<Clients>>(client,  HttpStatus.OK);
    }

    @RequestMapping(value = "/search_byname/{filter}", method = RequestMethod.GET, produces ="application/json")
    public ResponseEntity<Flux<Clients>> selectClientByName(@PathVariable("filter") String name ){
        log.info("******* GET USER BY NAME *******");
        Flux<Clients> clients = clientsServiceImpl.FindByName(name)
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND, "Clients not found")));
        return new ResponseEntity<Flux<Clients>>(clients, HttpStatus.OK);
    }

    @GetMapping(value = "/search_bypoints/{filter}", produces ="application/json")
    public ResponseEntity<Flux<Clients>>  selectClientByPoints(@PathVariable("filter") int points){
        log.info("******* GET USER BY FIDELITY POINTS *******");
        Flux<Clients> clients = clientsServiceImpl.FindByPoint(points)
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND, "Clients not found")));
        return new ResponseEntity<Flux<Clients>>(clients, HttpStatus.OK);
    }



}
