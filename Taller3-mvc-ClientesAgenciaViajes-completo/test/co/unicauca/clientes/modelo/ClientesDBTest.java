
package co.unicauca.clientes.modelo;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author libardo Pantoja, Ricardo Zambrano
 */
public class ClientesDBTest {

    public ClientesDBTest() {
    }

    /**
     * Test of integración
     */
    @Test
    public void testClientesPorProfesion() {
        System.out.println("Clientes por profesión");
        ClientesDB instance = new ClientesDB();

        instance.borrarClientes();
        instance.agregarCliente("Andres Perez", "Ingeniero(a)", "M");
        instance.agregarCliente("Andrea Ruiz", "Ingeniero(a)", "F");
        instance.agregarCliente("Carlos Andrade", "Ingeniero(a)", "M");
        instance.agregarCliente("Maria Sotelo", "Medico(a)", "F");

        instance.buscarClientesPorProfesion("Medico(a)");
        ArrayList<Cliente> result = instance.getClientesPorProfesion();

        assertEquals(1, result.size()); //Medicos un solo registro
        assertEquals("Maria Sotelo", result.get(0).getNombres());
        assertEquals("Medico(a)", result.get(0).getProfesion());
        assertEquals("F", result.get(0).getSexo());
        assertEquals(1, instance.getTotalMujeres());
        assertEquals(0, instance.getTotalHombres());

        instance.buscarClientesPorProfesion("Ingeniero(a)");
        result = instance.getClientesPorProfesion();

        assertEquals(3, result.size()); //Ingenieros tres
        assertEquals("Andres Perez", result.get(0).getNombres());
        assertEquals("Ingeniero(a)", result.get(0).getProfesion());
        assertEquals("M", result.get(0).getSexo());
        
        assertEquals("Andrea Ruiz", result.get(1).getNombres());
        assertEquals("Ingeniero(a)", result.get(1).getProfesion());
        assertEquals("F", result.get(1).getSexo());
        
        assertEquals(1, instance.getTotalMujeres());
        assertEquals(2, instance.getTotalHombres());
        
    }

}
