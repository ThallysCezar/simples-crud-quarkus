package de.thallys.mapper;

import de.thallys.dto.FrutaDTO;
import de.thallys.entity.Fruta;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
        componentModel = "cdi",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface FrutaMapper {
    // --- Entity to DTO
    @Mapping(target = "id", expression = "java(fruta.getId())")
    FrutaDTO toDTO(Fruta fruta);

    // -- DTO to Entity
    @Mapping(target = "id", ignore = true)
    Fruta toEntity(FrutaDTO frutaDTO);

    // -- MERGE
    @Mapping(target = "id", ignore = true)
    void merge(@MappingTarget Fruta target, Fruta source);
}
