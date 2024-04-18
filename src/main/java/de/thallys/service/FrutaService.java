package de.thallys.service;

import de.thallys.dto.FrutaDTO;
import de.thallys.entity.Fruta;
import de.thallys.mapper.FrutaMapper;
import de.thallys.repository.FrutaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import static jakarta.ws.rs.core.Response.Status.BAD_REQUEST;
import static jakarta.ws.rs.core.Response.Status.NOT_FOUND;

@ApplicationScoped
public class FrutaService {

    @Inject
    FrutaRepository frutaRepository;

    @Inject
    FrutaMapper frutaMapper;

    public List<Fruta> findAll() {
        return frutaRepository.listAll();
    }

    public Response getAll() {
        List<FrutaDTO> frutas =
                frutaRepository.listAll().stream()
                        .map(fruta -> frutaMapper.toDTO(fruta))
                        .collect(Collectors.toList());
        return Response.ok(frutas).build();
    }

    public Response getById(Long id) {
        return frutaRepository
                .findByIdOptional(id)
                .map(fruta -> Response.ok(frutaMapper.toDTO(fruta)).build())
                .orElse(Response.status(NOT_FOUND).build());
    }

    public Response createFruta(FrutaDTO dto) {
        Fruta fruta = frutaMapper.toEntity(dto);
        frutaRepository.persist(fruta);
        if (frutaRepository.isPersistent(fruta)) {
            return Response.created(URI.create("/frutas/" + fruta.getId())).build();
        }
        return Response.status(NOT_FOUND).build();
    }

    public Response updateFruta(FrutaDTO dto) {
        return frutaRepository
                .findByIdOptional(dto.getId())
                .map(
                        frutaToUpdate -> {
                            Fruta frutaUpdated = frutaMapper.toEntity(dto);
                            frutaToUpdate.setNome(frutaUpdated.getNome());
                            frutaToUpdate.setQtd(frutaUpdated.getQtd());
                            frutaRepository.persist(frutaToUpdate);
                            return Response.ok(frutaMapper.toDTO(frutaUpdated)).build(); // Corrigido para retornar frutaUpdated
                        })
                .orElse(Response.status(NOT_FOUND).build());
    }

    public Response deleteById(Long id) {
        boolean deleted = frutaRepository.deleteById(id);
        return deleted ? Response.noContent().build() : Response.status(BAD_REQUEST).build();
    }

}