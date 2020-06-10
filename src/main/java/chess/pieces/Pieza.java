package chess.pieces;
import chess.items.*;
import java.util.LinkedList;

/* Gradle path: export PATH=$PATH:/opt/gradle/gradle-5.6.3/bin */
/**
* Clase Abstracta para las piezas de ajedrez
**/
public abstract class Pieza{
  /* Posición de la pieza*/
  protected Posicion posicion;
  /* Tipo de pieza*/
  protected EnumPieza tipoPieza;
  /* Color de la pieza */
  protected ColorEnum colorPieza;
  /* Lista con los movimientos legales para las piezas*/
  protected LinkedList<Posicion> movimientosLegales;
  /* Todas las piezas tienen el mismo tablero */



  /** Constructor para la pieza
  * @param : int[][] posicion de la pieza
  * @param : EnumPieza tipo de pieza que es
  * @param : ColorEnum color de la pieza
  **/
  public Pieza(Posicion posicion, ColorEnum color){
    this.posicion = posicion;
    this.colorPieza = color;
  }

  /* Método para mover la pieza */
  public void moverPieza(Posicion p){
    if(this.esMovimientoLegal(p)){
      this.posicion = p;
      this.movimientosLegales = null;
    }
    return;
  }

  /* Método para validar el movimiento de la pieza */
  public boolean esMovimientoLegal(Posicion movimiento){
    if(this.movimientosLegales == null){
      this.movimientosLegales = new LinkedList<>(); 
    }
    return movimientosLegales.contains(movimiento) ? true : false;
  }
  /* Método que compara piezas */
  @Override
  public boolean equals(Object o){
    if((o instanceof Pieza)) return false;
    @SuppressWarnings("unchecked") Pieza pieza = (Pieza) o;
    if(pieza.getPosicion() != this.posicion || pieza.getTipo() != this.tipoPieza) return false;
    return true;
  }
  /* Método para obtener la posición de la pieza */
  public Posicion getPosicion(){
    return this.posicion;
  }
  /* Método para obtener los métodos legales que tiene la pieza*/
  public abstract LinkedList<Posicion> obtenerMovimientosLegales();
  /* Método para obtener el tipo de pieza*/
  public EnumPieza getTipo(){
    return this.tipoPieza;
  }
  /* Método para obtener el color de la pieza*/
  public ColorEnum getColor(){
    return this.colorPieza;
  }

  /* Método toString */
  @Override
  public String toString(){
    return this.tipoPieza.toString();
  }

  /* Método para ver si el movimiento de una pieza está fuera del tablero o no*/
  public boolean estaDentroTablero(Posicion posicion){
    return posicion.getX()<8 && posicion.getX()>= 0 && posicion.getY() >= 0 && posicion.getY()<8;
  }

}
