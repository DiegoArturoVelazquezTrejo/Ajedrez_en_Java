package chess.pieces;
import chess.items.*;
import java.util.LinkedList;

/* Clase para la pieza Alfil que extiende de la clase abstracta Pieza*/
public class Alfil extends Pieza{

  /* Constructor para la clase Alfil*/
  public Alfil(Posicion posicion, ColorEnum color){
    super(posicion, color);
    this.tipoPieza = EnumPieza.ALFIL;
  }

  /* ALGORITMO PRINCIPAL PARA CADA PIEZA */
  public LinkedList<Posicion> obtenerMovimientosLegales(){
    Tablero tablero = Tablero.getInstance();
    if(this.movimientosLegales == null){
      this.movimientosLegales = new LinkedList<Posicion>();
      /* Recorriendo los posibles movimientos de la pieza */

      /* Moviendo sobre la diagonal derecha hacia arriba*/
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
      posY = this.posicion.getY()-1;
      for(int i = this.posicion.getX()+1; i < 8; i++){
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

  /** Método equals para la pieza de la Alfil
  * @param : Object Alfil
  **/
  @Override
  public boolean equals(Object obj){
    if(!(obj instanceof Alfil)) return false;
    @SuppressWarnings("unchecked") Alfil pieza = (Alfil) obj;
    if(pieza.getColor() == this.getColor() && this.getPosicion().equals(pieza.getPosicion())) return true;
    else return false;
  }

}
