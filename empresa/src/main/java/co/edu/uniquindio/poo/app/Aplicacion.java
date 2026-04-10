package co.edu.uniquindio.poo.app;

import co.edu.uniquindio.poo.model.Empleado;
import co.edu.uniquindio.poo.model.Empresa;

import javax.swing.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Optional;

public class Aplicacion {
    public static void main(String[] args) {
        Empresa empresa = new Empresa("Miguel's factory");
        boolean salida = false;
        while(!salida){
        int numeroEscogigo = Integer.valueOf(JOptionPane.showInputDialog(null,"Ingrese el numero de lo que desea realizar" +
                "\n(1).Verificar los empleados que llegaron tarde"+
                "\n(2).Registrar empleado"+
                "\n(3).Ingresar hora empleado por nombre"+
                "\n(4).Salir"));

            switch (numeroEscogigo){

                case 1: boolean flag = false;
                        LocalTime horaEntradaEmpresa = null;
                    while(!flag){
                        try{
                             horaEntradaEmpresa = LocalTime.parse(JOptionPane.showInputDialog(null,"Ingrese la hora de entrada de la empresa (Hora:Minutos)"));
                            flag = true;
                        }
                        catch (Exception e){
                            JOptionPane.showMessageDialog(null,"Ingrese en el formato correcto hora:minutos");
                        }
                    }
                    ArrayList<Empleado> listaEmpleadosTardios = empresa.listaEmpleadosTardios(horaEntradaEmpresa);
                    String mensaje = empresa.mostrarEmpleadosTardios(listaEmpleadosTardios);
                    JOptionPane.showMessageDialog(null,mensaje);
                    break;
                case 2: String nombreEmpleado = JOptionPane.showInputDialog(null,"Ingrese el nombre del empleado : ");
                         mensaje = empresa.registrarEmpleado(nombreEmpleado);
                         JOptionPane.showMessageDialog(null,mensaje);
                         break;
                case 3:   nombreEmpleado = JOptionPane.showInputDialog(null,"Ingrese el nombre del empleado : ");
                           mensaje= empresa.ingresarHoraEntradaEmpleado(nombreEmpleado);
                           JOptionPane.showMessageDialog(null,mensaje);
                           break;
                case 4: salida = true;
            }
        }

    }
}
