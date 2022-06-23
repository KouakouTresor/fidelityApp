package com.webApp.clientsService;

import com.webApp.model.Clients;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;



public interface ClientsService {
    public Mono<Clients> SelectClient(String id);
    public Flux<Clients> SelectAll();
    public Mono<Clients> SaveClient(Clients client);
    public Mono<Void> DeleteClient(String id);
    public Mono<Clients> FindByFidelityCode(String code);
    public Flux<Clients> FindByName(String name);
    public Flux<Clients> FindByPoint(int points);
}
