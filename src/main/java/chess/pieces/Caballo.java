package chess.pieces;
import chess.items.*;
import java.util.LinkedList;

/* Clase para la pieza Caballo que extiende de la clase abstracta Pieza*/
public class Caballo extends Pieza{

  /* Constructor para la clase Caballo*/
  public Caballo(Posicion posicion, ColorEnum color){
    super(posicion, color);
    this.tipoPieza = EnumPieza.CABALLO;
  }
  /* Método para verificar si una pieza se agrega a la lista o no*/
  public void verificar(Posicion posicion, LinkedList<Posicion> lista){
    Tablero tablero = Tablero.getInstance();
    if(this.estaDentroTablero(posicion)){
      Pieza pieza = tablero.getPieza(posicion);
      if(pieza.getColor().equals(this.getColor())) return;
      else if(pieza.getColor().equals(ColorEnum.NONE) || !pieza.getColor().equals(this.getColor())) lista.add(posicion);
    }
    return;
  }

  /* ALGORITMO PRINCIPAL PARA CADA PIEZA */
  public LinkedList<Posicion> obtenerMovimientosLegales(){
    if(this.movimientosLegales == null){

      this.movimientosLegales = new LinkedList<Posicion>();
      Posicion uno = new Posicion(this.posicion.getX()-2, this.posicion.getY()+1);
      this.verificar(uno, movimientosLegales);

      Posicion dos = new Posicion(this.posicion.getX()-2, this.posicion.getY()-1);
      this.verificar(dos, movimientosLegales);

      Posicion tres = new Posicion(this.posicion.getX()-1, this.posicion.getY()-2);
      this.verificar(tres, movimientosLegales);

      Posicion cuatro = new Posicion(this.posicion.getX()+1, this.posicion.getY()-2);
      this.verificar(cuatro, movimientosLegales);

      Posicion cinco = new Posicion(this.posicion.getX()+2, this.posicion.getY()-1);
      this.verificar(cinco, movimientosLegales);

      Posicion seis = new Posicion(this.posicion.getX()+2, this.posicion.getY()+1);
      this.verificar(seis, movimientosLegales);

      Posicion siete = new Posicion(this.posicion.getX()-1, this.posicion.getY()+2);
      this.verificar(siete, movimientosLegales);

      Posicion ocho = new Posicion(this.posicion.getX()+1, this.posicion.getY()+2);
      this.verificar(ocho, movimientosLegales);


    }
    return this.movimientosLegales;
  }


  /** Método equals para la pieza de la caballo
  * @param : Object Caballo
  **/
  @Override
  public boolean equals(Object obj){
    if(!(obj instanceof Caballo)) return false;
    @SuppressWarnings("unchecked") Caballo pieza = (Caballo) obj;
    if(pieza.getColor() == this.getColor() && this.getPosicion().equals(pieza.getPosicion())) return true;
    else return false;
  }

}
