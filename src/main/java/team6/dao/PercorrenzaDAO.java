package team6.dao;

import team6.entities.Percorrenza;
import java.time.LocalDate;
import java.util.List;

public class PercorrenzaDAO {

    public void save(Percorrenza percorrenza) {}

    public Percorrenza findById(String id) { return null; }

    public List<Percorrenza> findAll() { return null; }

    public void update(Percorrenza percorrenza) {}

    public void delete(String id) {}

    public List<Percorrenza> findByIdMezzo(String idMezzo) { return null; }

    public List<Percorrenza> findByIdTratta(String idTratta) { return null; }

    public List<Percorrenza> findByDataPartenza(LocalDate dataPartenza) { return null; }

    public List<Percorrenza> findByDateRange(LocalDate startDate, LocalDate endDate) { return null; }
}