package ar.edu.unahur.obj2.adapters;

import ar.edu.unahur.obj2.Vuelo;
import ar.edu.unahur.obj2.proveedores.Proveedor;
import ar.edu.unahur.obj2.proveedores.Sabre;
import org.joda.time.DateTime;

import java.util.List;

public class SabreAdapter  implements Proveedor {

    public Sabre sabre;

    public SabreAdapter(Sabre sabre) {
        this.sabre = sabre;
    }

    @Override
    public List<Vuelo> buscarVuelo(DateTime fecha, String origen, String destino) {
        return sabre.buscar(fecha, origen, destino);
    }
}
