package br.org.upe.eventhub.services;

import br.org.upe.eventhub.entities.Evento;

import java.util.List;

public interface EventoService {

    public Evento cadastrarEvento(Evento evento);
    public List<Evento> listarEventos();
    public Evento buscarEvento(Evento evento);
    public List<Evento> buscarEventoPorTituloContaining(String titulo);
    public List<Evento> buscarEventoPorInicio(String titulo);

}
