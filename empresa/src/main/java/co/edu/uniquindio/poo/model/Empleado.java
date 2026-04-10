package co.edu.uniquindio.poo.model;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;

public class Empleado {

    //Atributos
    private String nombre;
    private String apellido;
    private LocalTime horaEntrada;
    private LocalTime horaSalida;

    //Relaciones
    private Empresa ownedByEmpresa;

    //Constructor
    public Empleado(String nombre, String apellido,
                    LocalTime horaEntrada, LocalTime horaSalida) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.horaEntrada = horaEntrada;
        this.horaSalida = horaSalida;
        this.ownedByEmpresa = ownedByEmpresa;
    }
    public Empleado(String nombre){
        this.nombre = nombre;
    }

    //Getters y setters
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Empresa getOwnedByEmpresa() {
        return ownedByEmpresa;
    }
    public void setOwnedByEmpresa(Empresa ownedByEmpresa) {
        this.ownedByEmpresa = ownedByEmpresa;
    }

    public LocalTime getHoraSalida() {
        return horaSalida;
    }
    public void setHoraSalida(LocalTime horaSalida) {
        this.horaSalida = horaSalida;
    }

    public LocalTime getHoraEntrada() {
        return horaEntrada;
    }
    public void setHoraEntrada(LocalTime horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    //ToString


    @Override
    public String toString() {
        return "Empleado{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", horaEntrada=" + horaEntrada +
                ", horaSalida=" + horaSalida +
                ", ownedByEmpresa=" + ownedByEmpresa +
                '}';
    }

    //Metodo que verifica si el empleado llego tarde
    public boolean saberSiLLegoTarde(LocalTime horaEntradaEmpresa){
        if(horaEntrada == null){
            return false;
        }
        if(horaEntrada.isAfter(horaEntradaEmpresa)){
            return true;
        }
        return false;
    }
    //Ingresar hora enttada
    public String ingresarHoraIngreso(){
       String mensaje = "";
        try{
            LocalTime horaEntrada= LocalTime.parse(JOptionPane.showInputDialog(null,"Ingrese la hora actual (hora:minutos): "));
            mensaje = "Hora ingresada correctamente";
            this.horaEntrada = horaEntrada;
        } catch (DateTimeParseException e) {
            mensaje = "La hora no fue ingresada correctamente";
        }
        return mensaje;
    }
    //Ingresar hora salida
    public String ingresarHoraSalida(){
        String mensaje = "";
        try{
            LocalTime horaEntrada= LocalTime.parse(JOptionPane.showInputDialog(null,"Ingrese la hora actual (hora:minutos): "));
            mensaje = "Hora ingresada correctamente";
        } catch (DateTimeParseException e) {
            mensaje = "La hora no fue ingresada correctamente";
        }
        return mensaje;
    }
}
