package com.gokdenizozkan.yalnizapi.layer.controller;

import com.gokdenizozkan.yalnizapi.config.response.StructuredResponse;
import com.gokdenizozkan.yalnizapi.dto.owner.request.OwnerSaveRequest;
import com.gokdenizozkan.yalnizapi.dto.owner.request.OwnerUpdateRequest;
import com.gokdenizozkan.yalnizapi.layer.responser.OwnerResponser;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v2/owners")
@RequiredArgsConstructor
public class OwnerController {
    private final OwnerResponser responser;

    @GetMapping
    public ResponseEntity<StructuredResponse> findAll() {
        return responser.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<StructuredResponse> findById(@PathVariable Long id) {
        return responser.findById(id);
    }

    @GetMapping("/search")
    public ResponseEntity<StructuredResponse> search(@RequestParam String name) {
        return responser.search(name);
    }

    @GetMapping("/{id}/pets")
    public ResponseEntity<StructuredResponse> findPetsById(@PathVariable Long id) {
        return responser.findPetsById(id);
    }

    @PostMapping
    public ResponseEntity<StructuredResponse> save(@RequestBody OwnerSaveRequest request) {
        return responser.save(request);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StructuredResponse> update(@PathVariable Long id, @RequestBody OwnerUpdateRequest request) {
        return responser.update(id, request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<StructuredResponse> deleteById(@PathVariable Long id) {
        return responser.deleteById(id);
    }
}
