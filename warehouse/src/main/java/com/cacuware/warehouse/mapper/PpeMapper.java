package com.cacuware.warehouse.mapper;

import com.cacuware.warehouse.api.dto.PpeDto;
import com.cacuware.warehouse.model.Material;
import com.cacuware.warehouse.model.PPE;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class PpeMapper {
    public static PPE toEntity(PpeDto ppeDto, Material material) {
        PPE ppe = PPE.builder()
                //.type(PPEType.getByText(ppeDto.getType()))
                .person_id(ppeDto.getPeople())
                .size(ppeDto.getSize())
                .material(material)
                .build();
        if (Objects.nonNull(ppeDto.getId())) {
            ppe.setId(ppeDto.getId());
        }
        return ppe;
    }

    public static PpeDto toDto(PPE ppe) {
        return PpeDto.builder()
                .id(ppe.getId())
               // .type(ppe.getType().getText())
                .people(ppe.getPerson_id())
                .size(ppe.getSize())
                .material(MaterialMapper.toDto(ppe.getMaterial()))
                .build();
    }
}
