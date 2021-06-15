package com.example;

import com.example.UserResponse;
import com.example.Pets;
import com.example.PetsRepository;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;

@EnableScheduling
@Configuration
public class SchedulerConfig {
	
	

    @Autowired
    SimpMessagingTemplate template;
    
    @Autowired
	private PetsRepository repository;
	@Autowired
	RestTemplate restTemplate;

    @Scheduled(fixedDelay = 5000)
    public void sendAdhocMessages() {
    	int id = repository.findAll().size();
		//System.out.println(id);
		Pets pets = repository.findByid((id));
		
		String sl = pets.getSl();
		String sw = pets.getSw();
		String pl = pets.getPl();
		String pw = pets.getPw();
		//repository.save(pets);
		//System.out.println(repository.save(pets));
		HttpHeaders headers = new HttpHeaders();
	    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	    HttpEntity<Pets> entity = new HttpEntity<Pets>(pets,headers);
	    String data = restTemplate.exchange("https://secure-plateau-14220.herokuapp.com/clasifica", HttpMethod.POST, entity, String.class).getBody();
	    System.out.println(data);
	    //System.out.println(entity.getClass().getSimpleName());
        template.convertAndSend("/topic/user", new UserResponse(data));
    }
}
