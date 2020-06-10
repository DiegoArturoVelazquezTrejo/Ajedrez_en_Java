package gui;

import java.util.LinkedList;
import java.util.List;
import chess.items.Tablero;
import chess.items.Posicion;
import chess.items.ColorEnum;
import chess.pieces.EnumPieza;
import chess.pieces.Pieza;
import processing.core.PApplet;
import processing.core.PImage;

public class ChessGUI extends PApplet{
    int PIXEL_SIZE = 70;
    Tablero board = Tablero.getInstance();
    PImage torre_negra, torre_blanca;
    PImage alfil_negro, alfil_blanco;
    PImage peon_blanco, peon_negro;
    PImage caballo_negro, caballo_blanco;
    PImage rey_blanco, rey_negro;
    PImage reina_negro, reina_blanco;

    ColorEnum turn = ColorEnum.BLANCO;
    Posicion selected = null;
    List<Posicion> movimientosLegales = new LinkedList<>();


    public static void main(String[] args) {
        PApplet.main("gui.ChessGUI");
    }

    @Override
    public void settings(){
        size(550,550);
    }

    @Override
    public void setup(){
        System.out.println(board.toString());
        indicaTurno();
        torre_blanca   = loadImage(getClass().getResource("/white-rook-50.png").getPath());
        torre_negra    = loadImage(getClass().getResource("/black-rook-50.png").getPath());
        caballo_blanco = loadImage(getClass().getResource("/white-knight-50.png").getPath());
        caballo_negro= loadImage(getClass().getResource("/black-knight-50.png").getPath());
        alfil_negro  = loadImage(getClass().getResource("/black-bishop-50.png").getPath());
        alfil_blanco = loadImage(getClass().getResource("/white-bishop-50.png").getPath());
        reina_negro  = loadImage(getClass().getResource("/black-queen-50.png").getPath());
        reina_blanco = loadImage(getClass().getResource("/white-queen-50.png").getPath());
        rey_negro    = loadImage(getClass().getResource("/black-king-50.png").getPath());
        rey_blanco   = loadImage(getClass().getResource("/white-king-50.png").getPath());
        peon_negro   = loadImage(getClass().getResource("/black-pawn-50.png").getPath());
        peon_blanco  = loadImage(getClass().getResource("/white-pawn-50.png").getPath());
        dibujaTablero();
    }

    @Override
    public void draw(){
      dibujaTablero();
      dibujaMovimientosPosibles();
    }

    /* Método que dibuja el tablero */
    public void dibujaTablero(){
        for (int i = 0; i < board.getSize();i++) {
            for (int j = 0; j < board.getSize(); j++) {
                if(i%2==0){
                    if(j%2==0)fill(45,45,45);
                    else fill(255,255,255);
                }else{
                    if(j%2==0)fill(255,255,255);
                    else fill(45,45,45);
                }
                rect(i*PIXEL_SIZE,j*PIXEL_SIZE,PIXEL_SIZE,PIXEL_SIZE);
                Pieza p = board.getPieza(new Posicion(i, j), 0);
                drawPiece(p);
            }
        }
    }
    /**
    * Método que dibuja una pieza en el tablero
    * @param : Pieza
    **/
    public void drawPiece(Pieza p){
        int x = p.getPosicion().getY();
        int y = p.getPosicion().getX();
        switch (p.getTipo()){
            case TORRE:
                if(p.getColor().equals(ColorEnum.BLANCO))
                    image(torre_blanca,x*PIXEL_SIZE,y*PIXEL_SIZE);
                if(p.getColor().equals(ColorEnum.NEGRO))
                    image(torre_negra,x*PIXEL_SIZE,y*PIXEL_SIZE);
                break;

            case CABALLO:
              if(p.getColor().equals(ColorEnum.BLANCO))
                  image(caballo_blanco,x*PIXEL_SIZE,y*PIXEL_SIZE);
              if(p.getColor().equals(ColorEnum.NEGRO))
                  image(caballo_negro,x*PIXEL_SIZE,y*PIXEL_SIZE);
                  break;

            case ALFIL:
              if(p.getColor().equals(ColorEnum.BLANCO))
                  image(alfil_blanco,x*PIXEL_SIZE,y*PIXEL_SIZE);
              if(p.getColor().equals(ColorEnum.NEGRO))
                  image(alfil_negro,x*PIXEL_SIZE,y*PIXEL_SIZE);
              break;

            case REINA:
              if(p.getColor().equals(ColorEnum.BLANCO))
                  image(reina_blanco,x*PIXEL_SIZE,y*PIXEL_SIZE);
              if(p.getColor().equals(ColorEnum.NEGRO))
                  image(reina_negro,x*PIXEL_SIZE,y*PIXEL_SIZE);
              break;

            case REY:
              if(p.getColor().equals(ColorEnum.BLANCO))
                  image(rey_blanco,x*PIXEL_SIZE,y*PIXEL_SIZE);
              if(p.getColor().equals(ColorEnum.NEGRO))
                  image(rey_negro,x*PIXEL_SIZE,y*PIXEL_SIZE);
              break;

            case PEON:
              if(p.getColor().equals(ColorEnum.BLANCO))
                  image(peon_blanco,x*PIXEL_SIZE,y*PIXEL_SIZE);
              if(p.getColor().equals(ColorEnum.NEGRO))
                  image(peon_negro,x*PIXEL_SIZE,y*PIXEL_SIZE);
              break;

            default:
                break;
        }
    }
    /* Método que realiza una acción al recibir el click del mouse
    va a seleccionar la pieza en caso de no tenerla seleccionada y en caso de ya tenerla
    seleccionada, moverá la pieza a la posición que se seleccionó por segunda vez */
    @Override
    public void mouseClicked() {
        dibujaTablero();
        int x = mouseX / PIXEL_SIZE;
        int y = mouseY / PIXEL_SIZE;
        Posicion p = new Posicion(y,x);
        if(selected == null){
          selected = p;
          Pieza pieza = board.getPieza(p);
          this.movimientosLegales = pieza.obtenerMovimientosLegales();
          return;
        }else if(board.getPieza(p).getColor().equals(turn)){
          selected = p;
          Pieza pieza = board.getPieza(p);
          this.movimientosLegales = pieza.obtenerMovimientosLegales();
          return;
        }else{
          Pieza pieza2 = board.getPieza(p);
          if(board.getPieza(selected).getColor().equals(turn))
            if(this.board.move(selected, p)){
              if (turn.equals(ColorEnum.BLANCO))
                turn = ColorEnum.NEGRO;
              else
                turn = ColorEnum.BLANCO;
              selected = null;
              this.movimientosLegales = new LinkedList<>();
              indicaTurno();
              return;
            }
          this.movimientosLegales = new LinkedList<>();
        }

    }
    /* Método que dibuja los movimientos posibles de una pieza seleccionada */
    public void dibujaMovimientosPosibles() {
        stroke(255, 0, 0);
        fill(0, 0, 0, 100);
        for (Posicion g : movimientosLegales) {
            int y = g.getX();
            int x = g.getY();
            rect(x * PIXEL_SIZE, y * PIXEL_SIZE, PIXEL_SIZE, PIXEL_SIZE);
        }
        stroke(0, 0, 0);
    }
    /* Método que indica el turno del jugador */
    public void indicaTurno() {
        System.out.println("************************************************");
        System.out.println("-- -- -- -- -- -- -- TURNO -- -- -- -- -- -- -- --");
        System.out.println("Es el turno de: "+turn.toString().toLowerCase());
        System.out.println("************************************************");
    }

}
