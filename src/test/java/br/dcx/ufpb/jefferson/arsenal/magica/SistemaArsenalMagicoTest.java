package br.dcx.ufpb.jefferson.arsenal.magica;

import br.dcx.ufpb.jefferson.arsenal.magico.entities.Magia;
import br.dcx.ufpb.jefferson.arsenal.magico.entities.TipoElementar;
import br.dcx.ufpb.jefferson.arsenal.magico.exception.MagiaInexistenteException;
import br.dcx.ufpb.jefferson.arsenal.magico.exception.MagiaJaExisteException;
import br.dcx.ufpb.jefferson.arsenal.magico.system.SistemaArsenalMagico;
import org.junit.jupiter.api.Test;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

public class SistemaArsenalMagicoTest {
    @Test
    public void TestaArsenalMagico(){
        try {
            SistemaArsenalMagico sistema = new SistemaArsenalMagico();
            sistema.cadastrarMagia(001,"Esfera Carmesin", TipoElementar.FOGO,120.0,50);
            Collection<Magia> magiasPorElemento = sistema.getMagiasPorTipoElementar(TipoElementar.FOGO);
            assertEquals(1,magiasPorElemento.size());
            sistema.cadastrarMagia(002,"Sopro gélido",TipoElementar.GELO,40.0, 30);
            Collection<Magia> todasAsMagias = sistema.todasAsMagias();
            assertTrue(todasAsMagias.size() == 2);
            Magia m = sistema.getMagia(002);
            assertEquals(TipoElementar.GELO, m.getTipo());
            sistema.removerMagia(002);
            assertTrue(todasAsMagias.size() == 1);
            sistema.removerMagia(001);
            assertEquals(0, todasAsMagias.size());
        } catch (MagiaInexistenteException | MagiaJaExisteException e){
            e.printStackTrace();
            fail();
        }


    }
}