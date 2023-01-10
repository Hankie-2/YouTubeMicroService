package kg.charginov.userservice.controller;

import kg.charginov.userservice.model.dto.UserRequest;
import kg.charginov.userservice.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService service;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody UserRequest request){
        return new ResponseEntity<>(service.save(request), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> findAll(){
        return new ResponseEntity<>(service.findAll(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") Long id){
        return new ResponseEntity<>(service.findUserById(id),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        return new ResponseEntity<>(service.delete(id),HttpStatus.OK);
    }
}
