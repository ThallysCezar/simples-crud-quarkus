package de.thallys.repository;

import de.thallys.entity.Fruta;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class FrutaRepository implements PanacheRepository<Fruta> {
}