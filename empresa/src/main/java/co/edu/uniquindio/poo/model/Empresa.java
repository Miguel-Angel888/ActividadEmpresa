package co.edu.uniquindio.poo.model;

import java.lang.reflect.Array;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Optional;

public class Empresa {

    //Atributos
    private String nombre;

    //Relaciones
    private ArrayList<Empleado> listaEmpleados;

    //Constructor
    public Empresa(String nombre){
        this.nombre = nombre;
        this.listaEmpleados = new ArrayList<>();
    }

    //Getters y setters

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Empleado> getListaEmpleados() {
        return listaEmpleados;
    }
    public void setListaEmpleados(ArrayList<Empleado> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }

    //ToString

    @Override
    public String toString() {
        return "Empresa{" +
                "nombre='" + nombre + '\'' +
                ", listaEmpleados=" + listaEmpleados +
                '}';
    }

    //Lista de empleados que llegaron tarde
    public ArrayList<Empleado> listaEmpleadosTardios(LocalTime horaEntradaEmpresa){

         ArrayList<Empleado> listaEmpleadosTardios = new ArrayList<>();
         for(Empleado empleadoAux: listaEmpleados){
             if(empleadoAux.saberSiLLegoTarde(horaEntradaEmpresa)){
                 listaEmpleadosTardios.add(empleadoAux);
             }
         }
         return listaEmpleadosTardios;
    }
    //Mensaje de empleados tardios
    public String mostrarEmpleadosTardios(ArrayList<Empleado> empleados){
        String mensaje = "Empleados tardios\n";

        if(empleados.isEmpty()){
            return  "No hay empleados registrados ";
        }
        for(Empleado empleado: empleados){
            mensaje += "*"+empleado.getNombre() + "\n";
        }
        return mensaje;
    }
    //Registrar empleados
    public String registrarEmpleado(String nombre){
        String resultado = "";
        Optional<Empleado> empleadoAux = buscarEmpleado(nombre);
        if(empleadoAux.isPresent()){
            resultado = "El empleado ya esta registrado";
        }
        else{
            Empleado empleado = new Empleado(nombre);
            listaEmpleados.add(empleado);
            resultado = "El empleado fue registrado exitosamente";
        }
        return resultado;
    }

    //Buscar Empleado
    public Optional<Empleado> buscarEmpleado (String nombre){
        return listaEmpleados.stream().filter(
                empleado1 -> empleado1.getNombre().equalsIgnoreCase(nombre)).findAny();
    }
    //Ingresar hora entrada empleado
    public String ingresarHoraEntradaEmpleado(String nombre){
        Optional<Empleado> empleadoAux = buscarEmpleado(nombre);
        if(empleadoAux.isPresent()){
            for(Empleado empleado:listaEmpleados){
                if(empleado.getNombre().equalsIgnoreCase(nombre)){
                    empleado.ingresarHoraIngreso();
                    break;
                }
            }
        }else{
            return "El empleado no esta registrado";
        }
        return "Hora registrada exitosamente";
    }
}
