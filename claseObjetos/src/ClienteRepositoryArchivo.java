import java.util.ArrayList;
import java.util.List;

public class ClienteRepositoryArchivo implements ClienteRepository {

    public List<Cliente> clientes = new ArrayList<>();

    public ClienteRepositoryArchivo(){
        clientes.add(new Cliente());
        clientes.add(new Cliente());
        clientes.add(new Cliente());
        clientes.get(0).nombre = "Juan";
        clientes.get(1).nombre = "Marcos";
        clientes.get(2).nombre = "Evans";
    }

    @Override
    public Cliente obtenerClientPorNombre(String nombre) {
        for(int i = 0; i<clientes.size(); i ++){
            if (clientes.get(i).nombre.equals(nombre)){
                return clientes.get(i);
            }
        }
        return null;
    }
}
