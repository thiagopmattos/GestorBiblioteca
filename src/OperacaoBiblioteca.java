
import java.util.List;

public abstract class OperacaoBiblioteca {
    public abstract void registrarItem(ItemBiblioteca item);
    public abstract List<ItemBiblioteca> listarItens();
}
