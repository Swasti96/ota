package ar.edu.unahur.obj2;

import ar.edu.unahur.obj2.proveedores.Proveedor;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DistribuidorDeTrafico {

    private Random random = new Random();
    private List<Proveedor>provedores = new ArrayList<>();

    public DistribuidorDeTrafico(List<Proveedor> provedores) {
        this.provedores = provedores;
    }

    public void addProvedores(Proveedor proveedor){
        provedores.add(proveedor);
    }

    public Proveedor proveedor() {
        return provedores.get(random.nextInt(provedores.size()));
    }
}
