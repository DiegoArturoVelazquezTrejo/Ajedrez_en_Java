package chess.pieces;
import chess.items.*;
import java.util.LinkedList;

/* Clase para la pieza Reina que extiende de la clase abstracta Pieza*/
public class Reina extends Torre{

  /* Constructor para la clase Reina*/
  public Reina(Posicion posicion, ColorEnum color){
    super(posicion, color);
    this.tipoPieza = EnumPieza.REINA;
  }

  /* ALGORITMO PRINCIPAL PARA CADA PIEZA */
  public LinkedList<Posicion> obtenerMovimientosLegales(){
    Tablero tablero = Tablero.getInstance();
    if(this.movimientosLegales == null){
      LinkedList<Posicion> movimientosLegales = super.obtenerMovimientosLegales();
      /* Recorriendo los posibles movimientos de la pieza */

      int posY  = this.posicion.getY()+1;
      for(int i = this.posicion.getX()+1; i < 8; i++){
        Posicion siguientePosLegal = new Posicion(i, posY++);
        if(!this.estaDentroTablero(siguientePosLegal)) break;
        Pieza pieza = tablero.getPieza(siguientePosLegal);
        if(pieza.getColor().equals(this.getColor()))break;
        if(!pieza.getColor().equals(ColorEnum.NONE)){
            this.movimientosLegales.add(siguientePosLegal);
            break;
        }
        this.movimientosLegales.add(siguientePosLegal);
      }
      /* Moviendo sobre la diagonal derecha hacia abajo */
      posY = this.posicion.getY();
      for(int i = this.posicion.getX()+1; i < 8; i++){
        Posicion siguientePosLegal = new Posicion(i, --posY);
        if(!this.estaDentroTablero(siguientePosLegal)) break;
        Pieza pieza = tablero.getPieza(siguientePosLegal);
        if(pieza.getColor().equals(this.getColor()))break;
        if(!pieza.getColor().equals(ColorEnum.NONE)){
            this.movimientosLegales.add(siguientePosLegal);
            break;
        }
        this.movimientosLegales.add(siguientePosLegal);
      }
      /* Moviendo sobre la diagonal izquierda hacia arriba */
      posY = this.posicion.getY() - 1;
      for(int i = this.posicion.getX()-1; i >= 0; i--){
        Posicion siguientePosLegal = new Posicion(i, posY--);
        if(!this.estaDentroTablero(siguientePosLegal)) break;
        Pieza pieza = tablero.getPieza(siguientePosLegal);
        if(pieza.getColor().equals(this.getColor()))break;
        if(!pieza.getColor().equals(ColorEnum.NONE)){
            this.movimientosLegales.add(siguientePosLegal);
            break;
        }
        this.movimientosLegales.add(siguientePosLegal);
      }
      /* Moviendo sobre la diagonal hacia abajo */
      posY = this.posicion.getY() + 1;
      for(int i = this.posicion.getX()-1; i >= 0; i--){
        Posicion siguientePosLegal = new Posicion(i, posY++);
        if(!this.estaDentroTablero(siguientePosLegal)) break;
        Pieza pieza = tablero.getPieza(siguientePosLegal);
        if(pieza.getColor().equals(this.getColor()))break;
        if(!pieza.getColor().equals(ColorEnum.NONE)){
            this.movimientosLegales.add(siguientePosLegal);
            break;
        }
        this.movimientosLegales.add(siguientePosLegal);
      }
    }
    return this.movimientosLegales;
  }

  /** Método equals para la pieza de la Reina
  * @param : Object Reina
  **/
  @Override
  public boolean equals(Object obj){
    if(!(obj instanceof Reina)) return false;
    @SuppressWarnings("unchecked") Reina pieza = (Reina) obj;
    if(pieza.getColor() == this.getColor() && this.getPosicion().equals(pieza.getPosicion())) return true;
    else return false;
  }

}
