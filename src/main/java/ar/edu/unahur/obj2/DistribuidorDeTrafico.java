package ar.edu.unahur.obj2;

import ar.edu.unahur.obj2.proveedores.Proveedor;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DistribuidorDeTrafico {

    private Random random = new Random();
    private List<Proveedor>proveedores = new ArrayList<>();

    public DistribuidorDeTrafico(List<Proveedor> proveedores) {
        this.proveedores = proveedores;
    }

    public void addProveedores(Proveedor proveedor){
        proveedores.add(proveedor);
    }

    public Proveedor proveedor() {
        return proveedores.get(random.nextInt(proveedores.size()));
    }
}
