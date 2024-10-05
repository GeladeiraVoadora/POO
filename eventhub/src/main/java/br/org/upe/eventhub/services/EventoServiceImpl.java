package br.org.upe.eventhub.services;

import br.org.upe.eventhub.entities.Evento;
import br.org.upe.eventhub.repositories.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventoServiceImpl implements EventoService{

    @Autowired
    EventoRepository eventoRepository;

    @Override
    public Evento cadastrarEvento(Evento evento) {
        return eventoRepository.save(evento);
    }

    @Override
    public List<Evento> listarEventos() {
        return eventoRepository.findAll();
    }

    @Override
    public Evento buscarEvento(Evento evento) {
        return eventoRepository.findById(evento.getId()).orElse(null);
    }

    @Override
    public List<Evento> buscarEventoPorTituloContaining(String titulo) {
        return eventoRepository.findByTituloContaining(titulo);
    }

    @Override
    public List<Evento> buscarEventoPorInicio(String titulo) {
        return eventoRepository.findByTituloLike(titulo+'%');
    }
}
