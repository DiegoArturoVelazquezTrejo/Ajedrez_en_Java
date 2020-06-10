package chess.pieces;

import java.util.LinkedList;
import chess.items.*;
/**
* Clase para la pieza vacía
**/
public class Empty extends Pieza{
  /* Constructor por omisión */
  public Empty(Posicion posicion, ColorEnum color){
    super(posicion, color);
    this.tipoPieza = EnumPieza.NONE;
  }
 
  public Empty(){
    super(new Posicion(0,0), ColorEnum.NONE);
  }
  /* método para obtener los métodos legales */
  @Override
  public LinkedList<Posicion> obtenerMovimientosLegales(){
    return new LinkedList<>();
  }
  /** Método equals
  * @param : Object
  * @return : true si son iguales, false si no son iguales
  ***/
  @Override
  public boolean equals(Object obj){
    return (obj instanceof Empty) ? true: false;
  }
}
