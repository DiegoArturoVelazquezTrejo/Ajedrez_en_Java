package chess.pieces;
import chess.items.*;
import java.util.LinkedList;
/* Clase Peón que extiende de la clase Pieza*/
public class Peon extends Pieza{

  /* Constructor para la clase peón */
  public Peon(Posicion posicion, ColorEnum color){
    super(posicion, color);
    this.tipoPieza = EnumPieza.PEON;
  }
  /**
  * Método verificar
  * @param : Posicion
  * @param : LinkedList<Posicion>
  **/
  public void verificar(Posicion posicion, LinkedList<Posicion> lista){
    Tablero tablero = Tablero.getInstance();
    if(this.estaDentroTablero(posicion)) {
      Pieza pieza = tablero.getPieza(posicion);
      if(pieza.getColor().equals(ColorEnum.NONE)){
        lista.add(posicion);
      }
    }
    return;
  }
  /**
  * Método verificarAtaque
  * @param : Posicion
  * @param : LinkedList<Posicion>
  **/
  public void verificarAtaque(Posicion posicion, LinkedList<Posicion> lista){
    Tablero tablero = Tablero.getInstance();
    if(this.estaDentroTablero(posicion)){
      Pieza pieza = tablero.getPieza(posicion);
      if(!pieza.getColor().equals(ColorEnum.NONE))
        if(!(pieza.getColor().equals(this.getColor())))
          lista.add(posicion);
        else
          return;
      else
        return;
    }
    return;
  }

  /* ALGORITMO PRINCIPAL PARA CADA PIEZA */
  public LinkedList<Posicion> obtenerMovimientosLegales(){
    Tablero tablero = Tablero.getInstance();
    if (this.movimientosLegales == null) {
        this.movimientosLegales = new LinkedList<Posicion>();
        // Moviéndose para adelante



        switch(this.getColor()){
          case NEGRO:
            Posicion siguientePosLegal = new Posicion(this.posicion.getX()+1, this.posicion.getY());
            verificar(siguientePosLegal, this.movimientosLegales);
            if(this.posicion.getX() == 1){
              Pieza pieza = tablero.getPieza(new Posicion(2,this.posicion.getY()));
              Pieza pieza2 = tablero.getPieza(new Posicion(3,this.posicion.getY()));
              if(pieza.getColor().equals(ColorEnum.NONE) && pieza2.getColor().equals(ColorEnum.NONE))
                verificar(new Posicion(this.posicion.getX()+2, this.posicion.getY()), this.movimientosLegales);
            }
            // Movimiento para atacar piezas
            verificarAtaque(new Posicion(this.posicion.getX()+1, this.posicion.getY()-1), this.movimientosLegales);
            verificarAtaque(new Posicion(this.posicion.getX()+1, this.posicion.getY()+1), this.movimientosLegales);
            break;

          case BLANCO:
            siguientePosLegal = new Posicion(this.posicion.getX()-1, this.posicion.getY());
            verificar(siguientePosLegal, this.movimientosLegales);
            if(this.posicion.getX() == 6){
              Pieza pieza = tablero.getPieza(new Posicion(5,this.posicion.getY()));
              Pieza pieza2 = tablero.getPieza(new Posicion(4,this.posicion.getY()));
              if(pieza.getColor().equals(ColorEnum.NONE) && pieza2.getColor().equals(ColorEnum.NONE))
                verificar(new Posicion(this.posicion.getX()-2, this.posicion.getY()), this.movimientosLegales);
            }

            // Movimiento para atacar piezas
            verificarAtaque(new Posicion(this.posicion.getX()-1, this.posicion.getY()-1), this.movimientosLegales);
            verificarAtaque(new Posicion(this.posicion.getX()-1, this.posicion.getY()+1), this.movimientosLegales);
            break;
        }





    }
    return this.movimientosLegales;
  }


  /** Método equals para la pieza de la Peon
  * @param : Object Peon
  **/
  @Override
  public boolean equals(Object obj){
    if(!(obj instanceof Peon)) return false;
    @SuppressWarnings("unchecked") Peon pieza = (Peon) obj;
    if(pieza.getColor() == this.getColor() && this.getPosicion().equals(pieza.getPosicion())) return true;
    else return false;
  }
}
