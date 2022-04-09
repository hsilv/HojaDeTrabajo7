/**
 *
 */
package binarytree;

import java.util.ArrayList;

/**
 * @author Herber Sebastián Silva Muñoz
 *
 */
public class DictTraversal implements ITreeTraversal<String> {
    
    

    private ArrayList<String> traducciones;

    public DictTraversal() {
        this.traducciones = new ArrayList<String>();
    }
    
    
    @Override
    public void Walk(String value) {
        traducciones.add(value);
    }

    public ArrayList<String> getTraducciones() {
        return traducciones;
    }

}
