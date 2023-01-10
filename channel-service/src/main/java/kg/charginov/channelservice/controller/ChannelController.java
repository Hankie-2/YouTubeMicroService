package kg.charginov.channelservice.controller;

import kg.charginov.channelservice.model.dto.ChannelRequest;
import kg.charginov.channelservice.service.ChannelService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/channel")
@AllArgsConstructor
public class ChannelController {

    private final ChannelService service;

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") Long id){
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> findAll(){
        return new ResponseEntity<>(service.findAll(),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody ChannelRequest request){
        return new ResponseEntity<>(service.save(request),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        return new ResponseEntity<>(service.delete(id),HttpStatus.OK);
    }

}
