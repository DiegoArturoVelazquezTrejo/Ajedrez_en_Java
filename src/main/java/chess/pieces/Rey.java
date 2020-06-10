package chess.pieces;
import chess.items.*;
import java.util.LinkedList;

/* Clase para la pieza Rey que extiende de la clase abstracta Pieza*/
public class Rey extends Pieza{

  /* Constructor para la clase Rey*/
  public Rey(Posicion posicion, ColorEnum color){
    super(posicion, color);
    this.tipoPieza = EnumPieza.REY;
  }

  /* ALGORITMO PRINCIPAL PARA CADA PIEZA */
  public LinkedList<Posicion> obtenerMovimientosLegales(){
    Tablero tablero = Tablero.getInstance();
    if(this.movimientosLegales == null){
      this.movimientosLegales = new LinkedList<Posicion> ();
      /* Recorriendo los posibles movimientos de la pieza */

      int x = this.posicion.getX() -1;
      int y = this.posicion.getY() -1;
      for(int i = 0; i <3; i++){
        for(int j = 0; j < 3; j++){
          Posicion siguientePosLegal = new Posicion(x,y+j);
          if(this.estaDentroTablero(siguientePosLegal)) {
            Pieza pieza = tablero.getPieza(siguientePosLegal);
            if(!pieza.getColor().equals(this.getColor()))
              movimientosLegales.add(siguientePosLegal);
          }
        }
        x++;
      }
    }
    return this.movimientosLegales;
  }

  /** Método equals para la pieza de la rey
  * @param : Object rey
  **/
  @Override
  public boolean equals(Object obj){
    if(!(obj instanceof Rey)) return false;
    @SuppressWarnings("unchecked") Rey pieza = (Rey) obj;
    if(pieza.getColor() == this.getColor() && this.getPosicion().equals(pieza.getPosicion())) return true;
    else return false;
  }

}
