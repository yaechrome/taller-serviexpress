package cl.taller.serviexpress.dao;

import cl.taller.serviexpress.domain.TipoProducto;
import java.util.List;

public interface TipoProductoDao {

    List<TipoProducto> findAllActive();

    List<TipoProducto> findByFamilia(long idFamilia);

    TipoProducto findById(long idTipo);

}
