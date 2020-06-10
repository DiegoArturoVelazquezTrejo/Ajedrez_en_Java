package chess.items;
import chess.pieces.*;
/**
* Clase  Tablero para el tablero del juego ajedrez.
* @author : Diego Arturo Velázquez Trejo
* @version : 1.0
**/
public class Tablero{

  /* Tamaño del tablero 8 */
  public int SIZE = 8;
  /* Matriz de piezas */
  public Pieza[][] matriz;
  /* Atributo de la clase  */
  private static Tablero instance = null;

  /* Constructor privado por omisión */
  private Tablero(){
    this.matriz = new Pieza[SIZE][SIZE];
    /* Colocando las torres en el tablero */
    this.matriz[0][0]           = new Torre(new Posicion(0,0), ColorEnum.NEGRO);
    this.matriz[0][7]           = new Torre(new Posicion(0,7), ColorEnum.NEGRO);
    this.matriz[7][0]           = new Torre(new Posicion(7,0), ColorEnum.BLANCO);
    this.matriz[7][7]           = new Torre(new Posicion(7,7), ColorEnum.BLANCO);

    /* Colocando los caballos en el tablero */
    this.matriz[0][1]           = new Caballo(new Posicion(0,1), ColorEnum.NEGRO);
    this.matriz[0][6]           = new Caballo(new Posicion(0,6), ColorEnum.NEGRO);
    this.matriz[7][1]           = new Caballo(new Posicion(7,1), ColorEnum.BLANCO);
    this.matriz[7][6]           = new Caballo(new Posicion(7,6), ColorEnum.BLANCO);

    /* Colocando los alfiles en el tablero */
    this.matriz[0][2]           = new Alfil(new Posicion(0,2), ColorEnum.NEGRO);
    this.matriz[0][5]           = new Alfil(new Posicion(0,5), ColorEnum.NEGRO);
    this.matriz[7][2]           = new Alfil(new Posicion(7,2), ColorEnum.BLANCO);
    this.matriz[7][5]           = new Alfil(new Posicion(7,5), ColorEnum.BLANCO);

    /* Colocando los reyes y reinas en el tablero */
    this.matriz[0][3]           = new Rey(new Posicion(0,3), ColorEnum.NEGRO);
    this.matriz[0][4]      = new Reina(new Posicion(0,4), ColorEnum.NEGRO);
    this.matriz[7][4]      = new Reina(new Posicion(7,4), ColorEnum.BLANCO);
    this.matriz[7][3]      = new Rey(new Posicion(7,3), ColorEnum.BLANCO);


    /* Colocando los peones en el tablero */
    for(int i = 0; i < 8; i++){
      this.matriz[1][i]      = new Peon(new Posicion(1,i), ColorEnum.NEGRO);
      this.matriz[6][i]      = new Peon(new Posicion(6,i), ColorEnum.BLANCO);
    }

    /* Colocando piezas vacías en las demás casillas */
    for(int i = 2; i < 6; i++){
      for(int j = 0; j < 8; j++){
        this.matriz[i][j]      = new Empty(new Posicion(i,j), ColorEnum.NONE);
      }
    }

  }
  /* Método para que nos regrese siempre la instancia del mismo tablero */
  public static Tablero getInstance(){
    if(instance == null)
      instance = new Tablero();
    return instance;
  }
  /* Método toString de la clase Tablero */
  @Override
  public String toString(){
    String result = "";
    for(int i = 0; i < SIZE; i++){
      for(int j = 0; j <SIZE; j++){
        result += " "+ matriz[i][j] +" ";
      }
      result+= "\n";
    }
    return result;
  }
  /** Método para obtener una pieza del tablero y dibujarla en la interfaz gráfica
  * @param : coordenada en x
  * @param : coordenada en y
  * @return : Pieza
  **/
  public Pieza getPieza(Posicion posicion, int i){
    return this.matriz[posicion.getY()][posicion.getX()];
  }
  /** Método para obtener una pieza del tablero sin alternar las coordenadas
  * @param : coordenada en x
  * @param : coordenada en y
  * @return : Pieza
  **/
  public Pieza getPieza(Posicion posicion){
    return this.matriz[posicion.getX()][posicion.getY()];
  }

  /* Getter del tamaño del tablero*/
  public int getSize(){return this.SIZE;}

  /**
  * Método para mover las piezas dentro del tablero
  * @param : Posicion p (antigua posicion)
  * @param : Posicion q (nueva posición)
  * @return : bool true si se pudo mover la pieza, false de lo contrario
  **/
  public boolean move(Posicion p, Posicion q){
      if(!(p.estaFueraDelTablero(8)) || !(q.estaFueraDelTablero(8)))return false;
      Pieza piece = this.getPieza(p);
      piece.obtenerMovimientosLegales();
      if(!piece.esMovimientoLegal(q))return false;
      piece.moverPieza(q);
      this.matriz[p.getX()][p.getY()] = new Empty(p,ColorEnum.NONE);
      this.matriz[q.getX()][q.getY()] = piece;
      return true;
  }

}
