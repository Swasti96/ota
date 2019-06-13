package ar.edu.unahur.obj2.adapters;

import ar.edu.unahur.obj2.Boleto;
import ar.edu.unahur.obj2.Pasajero;
import ar.edu.unahur.obj2.Vuelo;
import ar.edu.unahur.obj2.proveedores.Amadeus;
import ar.edu.unahur.obj2.proveedores.Proveedor;
import org.joda.time.DateTime;

import java.util.List;
import java.util.Set;

public class AmadeusAdapter implements Proveedor {

    public Amadeus amadeus;

    public AmadeusAdapter(Amadeus amadeus){
        this.amadeus = amadeus;
    }

    @Override
    public List<Vuelo> buscarVuelo(DateTime fecha, String origen, String destino) {
        return amadeus.executeSearch(fecha, origen, destino);
    }

    @Override
    public Boleto reservarVuelo(Vuelo vuelo, Set<Pasajero> pasajeros) {
        return amadeus.executeBook(vuelo, pasajeros);
    }
}
