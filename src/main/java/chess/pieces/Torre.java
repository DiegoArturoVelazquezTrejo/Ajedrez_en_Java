package chess.pieces;
import java.util.LinkedList;
import chess.items.*;

/* Clase para la pieza Torre que extiende de la clase abstracta Pieza*/
public class Torre extends Pieza{


  /* Constructor para la clase Torre*/
  public Torre(Posicion posicion, ColorEnum color){
    super(posicion, color);
    this.tipoPieza = EnumPieza.TORRE;
  }

  /* ALGORITMO PRINCIPAL PARA CADA PIEZA */
  public LinkedList<Posicion> obtenerMovimientosLegales() {
        Tablero tablero = Tablero.getInstance();
        if (this.movimientosLegales == null) {
            this.movimientosLegales = new LinkedList<Posicion>();

            // Moviéndose para adelante
            for(int i = this.posicion.getX()+1;i < 8; i++){
                Posicion siguientePosLegal = new Posicion(i, this.posicion.getY());
                if(!this.estaDentroTablero(siguientePosLegal)) break;
                Pieza pieza = tablero.getPieza(siguientePosLegal);
                if(pieza.getColor().equals(this.getColor()))break;
                if(!pieza.getColor().equals(ColorEnum.NONE)){
                    this.movimientosLegales.add(siguientePosLegal);
                    break;
                }
                this.movimientosLegales.add(siguientePosLegal);
            }
            // Moviéndose para atrás
            for(int i = this.posicion.getX()-1;i >= 0; i--){
                Posicion siguientePosLegal = new Posicion(i, this.posicion.getY());
                if(!this.estaDentroTablero(siguientePosLegal)) break;
                Pieza pieza = tablero.getPieza(siguientePosLegal);
                if(pieza.getColor().equals(this.getColor()))break;
                if(!pieza.getColor().equals(ColorEnum.NONE)){
                    this.movimientosLegales.add(siguientePosLegal);
                    break;
                }
                this.movimientosLegales.add(siguientePosLegal);
            }

            // Moviéndose para derecha
            for(int i = this.posicion.getY()+1;i < 8; i++){
                Posicion siguientePosLegal = new Posicion(this.posicion.getX(), i);
                if(!this.estaDentroTablero(siguientePosLegal)) break;
                Pieza pieza = tablero.getPieza(siguientePosLegal);
                if(pieza.getColor().equals(this.getColor()))break;
                if(!pieza.getColor().equals(ColorEnum.NONE)){
                    this.movimientosLegales.add(siguientePosLegal);
                    break;
                }
                this.movimientosLegales.add(siguientePosLegal);
            }

            // Moviéndose para izquierda
            for(int i = this.posicion.getY()-1;i >= 0; i--){
                Posicion siguientePosLegal = new Posicion(this.posicion.getX(), i);
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

  /** Método equals para la pieza de la torre
  * @param : Object Torre
  **/
  @Override
  public boolean equals(Object obj){
    if(!(obj instanceof Torre)) return false;
    @SuppressWarnings("unchecked") Torre torre = (Torre) obj;
    if(torre.getColor() == this.getColor() && this.getPosicion().equals(torre.getPosicion())) return true;
    else return false;
  }

}
