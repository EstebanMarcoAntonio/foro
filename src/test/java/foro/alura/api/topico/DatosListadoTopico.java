package foro.alura.api.topico;

public record DatosListadoTopico(Long id, String titulo, String mensaje, String fecha_creacion) {
    public DatosListadoTopico(Topico topico) {
        this(topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFecha_creacion());
    }
}
