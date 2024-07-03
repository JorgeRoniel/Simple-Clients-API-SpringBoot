package shr.company.api_client_cep.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import shr.company.api_client_cep.models.Adress;

@FeignClient(name = "viacep", url = "https://viacep.com.br/ws")
public interface viaCEPService {
    
    @GetMapping("/{cep}/json/")
    public Adress getCEP(@PathVariable("cep") String cep);
}
