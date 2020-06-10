package chess.items;

/* Clase posición para determinar la posición de las piezas dentro de la matriz del tablero*/
public class Posicion{
  /* Componente x de la matriz*/
  protected int x;
  /* Componente y de la matriz*/
  protected int y;
  
  /* Constructor de la clase Posicion */
  public Posicion(int x, int y){
    this.x = x;
    this.y = y;
  }
  /**
  * Método para comparar dos posiciones
  * @param : Object posicion
  **/
  @Override
  public boolean equals(Object obj){
    if(!(obj instanceof Posicion)) return false;
    @SuppressWarnings("unchecked") Posicion pos = (Posicion) obj;
    if(pos.getX() == this.getX() && this.getY() == pos.getY()) return true;
    return false;
  }
  /* Getter para el atributo x*/
  public int getX(){ return this.x; }
  /* Getter para el atrobuto y*/
  public int getY(){ return this. y; }

  /** Método para saber si una posición está fuera del tablero o no.
  * @param : int tamaño del tablero
  * @return : <code>true</code> si la posición está dentro del tablero
  * <code>false</code> si la posición no está en el tablero
  ***/
  public boolean estaFueraDelTablero(int tamano_tablero){
    if(this.y>=tamano_tablero || this.x >= tamano_tablero) return false;
    if(this.y < 0 || this.x < 0 ) return false;
    return true;
  }

  /**
  * Método toString del objeto Posicion
  * @return : String
  **/
  @Override
  public String toString(){
    return "Posición [ " + this.x + ", "+this.y+" ]\n";
  }
}
