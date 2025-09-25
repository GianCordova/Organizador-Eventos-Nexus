package org.nexus.proyecto_fn_nexus.web.jsf;

import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import org.nexus.proyecto_fn_nexus.dominio.CategoriaRecurso;
import org.nexus.proyecto_fn_nexus.dominio.dto.ModificarRecursoDto;
import org.nexus.proyecto_fn_nexus.dominio.dto.RecursoDto;
import org.nexus.proyecto_fn_nexus.dominio.service.RecursoService;
import org.nexus.proyecto_fn_nexus.web.jsf.dto.RecursoJsfDto;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@Named("recursoJsfController")
@ViewScoped
public class RecursoJsf implements Serializable {

    private final RecursoService recursoService;
    private RecursoJsfDto nuevoRecurso;
    private List<RecursoJsfDto> listaRecursos;
    private Integer idRecurso;



    @Autowired
    public RecursoJsf(RecursoService recursoService) {
        this.recursoService = recursoService;
    }

    @PostConstruct
    public void init() {
        this.nuevoRecurso = new RecursoJsfDto();
        this.listaRecursos = mapToJsfDto(this.recursoService.obtenerTodo());
    }

    private List<RecursoJsfDto> mapToJsfDto(List<RecursoDto> recursos) {
        return recursos.stream().map(r -> {
            RecursoJsfDto dto = new RecursoJsfDto();
            dto.setIdRecurso(r.idRecurso());
            dto.setResourceName(r.resourceName());
            dto.setCategory(r.category());
            dto.setStock(r.stock());
            dto.setRentalPrice(r.rentalPrice());
            return dto;
        }).collect(Collectors.toList());
    }

    public void guardarOActualizar() {
        if (this.nuevoRecurso.getIdRecurso() == null) {
            guardarRecurso();
        } else {
            actualizarRecurso();
        }
    }


    public void guardarRecurso() {
        System.out.println(">>> guardarRecurso() llamado"); // <--- para verificar que entra al método

        try {
            System.out.println(">>> Datos del recurso a guardar:");
            System.out.println("Nombre: " + this.nuevoRecurso.getResourceName());
            System.out.println("Categoría: " + this.nuevoRecurso.getCategory());
            System.out.println("Stock: " + this.nuevoRecurso.getStock());
            System.out.println("Precio: " + this.nuevoRecurso.getRentalPrice());

            RecursoDto recursoDto = new RecursoDto(
                    this.nuevoRecurso.getIdRecurso(),  // ahora sí usas el id
                    this.nuevoRecurso.getResourceName(),
                    this.nuevoRecurso.getCategory(),
                    this.nuevoRecurso.getStock(),
                    this.nuevoRecurso.getRentalPrice()
            );


            this.recursoService.guardarRecurso(recursoDto);
            this.nuevoRecurso = new RecursoJsfDto();
            this.listaRecursos = mapToJsfDto(this.recursoService.obtenerTodo());

            System.out.println(">>> Recurso guardado correctamente"); // <--- confirmación de ejecución

            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Éxito", "Recurso guardado exitosamente"));
        } catch (Exception e) {
            System.out.println(">>> ERROR en guardarRecurso(): " + e.getMessage());
            e.printStackTrace();

            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al guardar", e.getMessage()));
        }
    }

    public void actualizarRecurso() {
        try {
            ModificarRecursoDto modificarRecursoDto = new ModificarRecursoDto(
                    this.nuevoRecurso.getResourceName(),
                    this.nuevoRecurso.getCategory(),
                    this.nuevoRecurso.getStock(),
                    this.nuevoRecurso.getRentalPrice()
            );

            this.recursoService.modificarRecurso(this.nuevoRecurso.getIdRecurso(), modificarRecursoDto);
            this.nuevoRecurso = new RecursoJsfDto();
            this.listaRecursos = mapToJsfDto(this.recursoService.obtenerTodo());

            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Éxito", "Recurso actualizado con éxito"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al actualizar", e.getMessage()));
        }
    }

    public void seleccionarRecurso(RecursoJsfDto recursoDto) {
        this.nuevoRecurso = recursoDto;
    }

    public void eliminarRecurso() {
        try {
            this.recursoService.eliminarRecurso(this.idRecurso);
            this.listaRecursos = mapToJsfDto(this.recursoService.obtenerTodo());

            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Éxito", "Recurso eliminado con éxito"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al eliminar", e.getMessage()));
        }
    }



    public Integer getIdRecurso() { return idRecurso;}

    public void setIdRecurso(Integer idRecurso) {this.idRecurso = idRecurso;}

    public CategoriaRecurso[] getCategorias() {
        return CategoriaRecurso.values();
    }

    public RecursoJsfDto getNuevoRecurso() {
        return nuevoRecurso;
    }

    public void setNuevoRecurso(RecursoJsfDto nuevoRecurso) {
        this.nuevoRecurso = nuevoRecurso;
    }

    public List<RecursoJsfDto> getListaRecursos() {
        return listaRecursos;
    }
}
