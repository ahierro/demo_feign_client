package com.example.feign.demo;

import com.example.feign.demo.dto.Pet;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ClientService {
    private final PetApi petApi;

    public ClientService(PetApi petApi) {
        this.petApi = petApi;
    }

    public void call() {


        ResponseEntity<List<Pet>> response = this.petApi.findPetsByStatus(Arrays.asList("lig7xk9ouhae7pthzfh5sfhy5aizpptjofqxtp1nufeucpgdebsn9bpylugv7q8fsv8pqcdq3"));
        if(response!=null){
            response = null;
        }
    }
}
