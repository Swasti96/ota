package ar.edu.unahur.obj2;

import ar.edu.unahur.obj2.adapters.AmadeusAdapter;
import ar.edu.unahur.obj2.adapters.SabreAdapter;
import ar.edu.unahur.obj2.adapters.WorldspanAdapter;
import ar.edu.unahur.obj2.proveedores.Amadeus;
import ar.edu.unahur.obj2.proveedores.Proveedor;
import ar.edu.unahur.obj2.proveedores.Sabre;
import ar.edu.unahur.obj2.proveedores.Worldspan;
import org.joda.time.DateTime;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.testng.Assert.*;

public class OtaTest {

    /*@Test
    public void testBuscarVuelos() {
        DistribuidorDeTrafico distribuidorDeTrafico = new DistribuidorDeTrafico();
        Ota ota = new Ota(distribuidorDeTrafico);

        DateTime fecha = new DateTime("2019-12-13");


        List<Vuelo> vuelos = ota.buscarVuelos(fecha, "BUE", "MIA");


    }

    @Test
    public void testReservar() {
        DistribuidorDeTrafico distribuidorDeTrafico = new DistribuidorDeTrafico();
        Ota ota = new Ota(distribuidorDeTrafico);

        DateTime fecha = new DateTime("2019-12-13");


        List<Vuelo> vuelos = ota.buscarVuelos(fecha, "BUE", "MIA");

        Vuelo elegido =  vuelos.get(0);
        Set<Pasajero> pasajeros = Stream.of(new Pasajero("Juan", "Pérez", 40)).collect(Collectors.toSet());

        Boleto boleto = ota.reservar(elegido, pasajeros );

        assertEquals(boleto.getVuelo(), elegido);


    }*/

    @Test
    public void testVuelo(){

        Amadeus amadeus = new Amadeus();
        AmadeusAdapter amadeusAdapter = new AmadeusAdapter(amadeus);


        List<Proveedor> proveedors = Stream.of(amadeusAdapter).collect(Collectors.toList());
        DistribuidorDeTrafico distribuidorDeTrafico = new DistribuidorDeTrafico(proveedors);

        Ota ota = new Ota(distribuidorDeTrafico);

        DateTime fecha = new DateTime("2019-12-13");

        List<Vuelo> vueloAdaptado = ota.buscarVuelos(fecha,"BUE","MIA");

        List<Vuelo> vueloAmadues = amadeus.executeSearch(fecha,"BUE","MIA");

        Assert.assertEquals(vueloAdaptado,vueloAmadues);

    }

    @Test
    public void TestBoleto(){
        Amadeus amadeus = new Amadeus();
        AmadeusAdapter amadeusAdapter = new AmadeusAdapter(amadeus);

        List<Proveedor> proveedors = Stream.of(amadeusAdapter).collect(Collectors.toList());
        DistribuidorDeTrafico distribuidorDeTrafico = new DistribuidorDeTrafico(proveedors);
        Ota ota = new Ota(distribuidorDeTrafico);
        DateTime fecha = new DateTime("2019-12-13");

        List<Vuelo> vueloList = ota.buscarVuelos(fecha,"BUE","MIA");

        Vuelo elegido = vueloList.get(0);
        Set<Pasajero> pasajero = Stream.of(new Pasajero("Pedro","Diaz",32))
                .collect(Collectors.toSet());

        Boleto boleto = ota.reservar(elegido,pasajero);

        Assert.assertEquals(boleto.getVuelo(),elegido);


    }
}