package com.cacuware.warehouse.api;

import com.cacuware.warehouse.api.dto.PpeDto;
import com.cacuware.warehouse.model.Car;
import com.cacuware.warehouse.model.PPE;
import com.cacuware.warehouse.service.PpeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/api/warehouse/ppes")
public class PpeController {
    @Autowired
    private PpeService ppeService;

    @GetMapping("/{id}")
    public PPE findPpe(@PathVariable("id") UUID id) {
        return ppeService.getOneById(id);
    }

    @GetMapping
    public ResponseEntity<List<PPE>> getAllPpes(Pageable pageable) {
        List<PPE> ppes = ppeService.findAllPpes(pageable.getSort());
        return ResponseEntity.ok().body(ppes);
    }

    @PostMapping
    public ResponseEntity<PPE> create(@RequestBody PpeDto ppeDto) throws URISyntaxException {
        PPE ppe = ppeService.savePpe(ppeDto);
        return ResponseEntity.created(new URI("/api/" + ppe.getId()))
                .body(ppe);
    }

    @DeleteMapping(value = "/{uuid}")
    public ResponseEntity<?> delete(@PathVariable UUID uuid) {
        ppeService.deletePpe(uuid);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/archive")
    public ResponseEntity<List<PPE>> archive() {
        List<PPE> ppes = ppeService.findAllDeletedPpes();
        return ResponseEntity.ok().body(ppes);
    }
}
