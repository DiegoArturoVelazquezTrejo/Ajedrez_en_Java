package chess.pieces;

/* Enumeración para el tipo de piezas del ajedrez*/
public enum EnumPieza{

  PEON, // Peón del ajedrez

  ALFIL, // Alfil del ajedrez

  REINA, // Reina del ajedrez

  REY, // Rey del ajedrez

  TORRE, // Torre del ajedrez

  CABALLO, // Caballo del ajedrez

  NONE;

  /* toString de enum */
  @Override public String toString() {
        switch(this){
          case PEON: return "♟";
          case ALFIL: return "♗";
          case REINA : return "♕";
          case REY: return "♔";
          case TORRE : return "♖";
          case CABALLO: return "♘";
          case NONE : return " ";
          default: throw new IllegalArgumentException();
        }
    }

}
