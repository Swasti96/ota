package ar.edu.unahur.obj2.adapters;

import ar.edu.unahur.obj2.Vuelo;
import ar.edu.unahur.obj2.proveedores.Proveedor;
import ar.edu.unahur.obj2.proveedores.Worldspan;
import org.joda.time.DateTime;

import java.util.List;

public class WorldspanAdapter implements Proveedor {

    public Worldspan worldspan;

    public WorldspanAdapter(Worldspan worldspan){
        this.worldspan = worldspan;
    }

    @Override
    public List<Vuelo>buscarVuelo(DateTime fecha, String origen, String destino) {
        return worldspan.searchFlights(fecha.getDayOfMonth(),fecha.getYear(),fecha.getMonthOfYear(),origen,destino);
    }
}
