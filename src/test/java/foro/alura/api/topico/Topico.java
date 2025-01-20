package foro.alura.api.topico;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name="Topico")
@Entity(name = "topico")
@Getter
@AllArgsConstructor
@EqualsAndHashCode(of ="id")
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    private String fecha_creacion;
    private String status;
    private String autor;
    private String curso;
    public Topico() {
        // Constructor vacío necesario para JPA
    }
    public Topico(DatosRegistroTopico datosRegistroTopico) {
    this.titulo = datosRegistroTopico.titulo();
    this.mensaje = datosRegistroTopico.mensaje();
    this.fecha_creacion = String.valueOf(LocalDateTime.now());
    this.status = datosRegistroTopico.status();
    this.autor = datosRegistroTopico.autor();
    this.curso = datosRegistroTopico.curso();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(String fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void actualizarDatos(DatosActualizarTopico datosActualizarTopico) {
        if(datosActualizarTopico.titulo()  != null)
        {
        this.titulo = datosActualizarTopico.titulo();
        }
        if(datosActualizarTopico.mensaje()  != null)
        {
            this.mensaje = datosActualizarTopico.mensaje();
        }
        if(datosActualizarTopico.fecha_creacion()  != null)
        {
            this.fecha_creacion = datosActualizarTopico.fecha_creacion();}
        }

    }

