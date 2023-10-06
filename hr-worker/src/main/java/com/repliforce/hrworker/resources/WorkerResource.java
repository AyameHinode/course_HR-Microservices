package com.repliforce.hrworker.resources;

import com.repliforce.hrworker.entities.Worker;
import com.repliforce.hrworker.repositories.WorkerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RefreshScope
@RestController
@RequestMapping(value = "/workers")
public class WorkerResource {

    private static Logger printLogger = LoggerFactory.getLogger(WorkerResource.class);

    @Autowired
    private Environment enviroment;

    @Autowired
    private WorkerRepository workerRepository;

    @Autowired
    private WorkerRepository repository;

    @GetMapping(value = "/configs")
    public ResponseEntity<Void> getConfigs(){
        //printLogger.info("CONFIG = " + testConfig);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Worker>> findAll(){
        List<Worker> listAllWorkers = repository.findAll();
        return ResponseEntity.ok(listAllWorkers);
    }

    @GetMapping(value = "/{id}")
    public  ResponseEntity<Worker> findById(@PathVariable Long id){

        /*
        try{
            Thread.sleep(3000L);
        } catch (InterruptedException interruption){
            interruption.printStackTrace();
        }
         */

        printLogger.info("PORT = " + enviroment.getProperty("local.server.port"));

        Worker worker = repository.findById(id).get();
        return ResponseEntity.ok(worker);

    }

}
