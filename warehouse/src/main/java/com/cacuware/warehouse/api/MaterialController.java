package com.cacuware.warehouse.api;

import com.cacuware.warehouse.api.dto.MaterialDto;
import com.cacuware.warehouse.model.Material;
import com.cacuware.warehouse.service.MaterialService;
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
@RequestMapping("/api/warehouse/materials")
public class MaterialController {
    @Autowired
    private MaterialService materialService;

    @GetMapping("/{id}")
    public Material findMaterial(@PathVariable("id") UUID id) {
        return materialService.getOneById(id);
    }

    @GetMapping
    public ResponseEntity<List<Material>> getAllMaterials(Pageable pageable) {
        List<Material> materials = materialService.findAllMaterials(pageable.getSort());
        return ResponseEntity.ok().body(materials);
    }

    @PostMapping
    public ResponseEntity<Material> create(@RequestBody MaterialDto materialDto) throws URISyntaxException {
        Material Material = materialService.saveMaterial(materialDto);
        return ResponseEntity.created(new URI("/api/" + Material.getId()))
                .body(Material);
    }

    @DeleteMapping(value = "/{uuid}")
    public ResponseEntity<?> delete(@PathVariable UUID uuid) {
        materialService.deleteMaterial(uuid);
        return ResponseEntity.noContent().build();
    }
}