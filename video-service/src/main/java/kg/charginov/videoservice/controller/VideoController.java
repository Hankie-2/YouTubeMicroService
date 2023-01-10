package kg.charginov.videoservice.controller;

import kg.charginov.videoservice.model.dto.VideoRequest;
import kg.charginov.videoservice.service.VideoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/video")
public class VideoController {

    private final VideoService service;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody VideoRequest request){
        return new ResponseEntity<>(service.save(request), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> findAll(){
        return new ResponseEntity<>(service.findAll(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findVideoById(@PathVariable("id")Long id){
        return new ResponseEntity<>(service.findVideoById(id),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")Long id){
        return new ResponseEntity<>(service.delete(id),HttpStatus.OK);
    }

}
