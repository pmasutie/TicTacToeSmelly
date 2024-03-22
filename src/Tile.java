
public class Tile
{
    public int X;
    public int Y;
    public char Symbol;

    public Tile(char Symbol, int X, int Y) {
        this.X = X;
        this.Y = Y;
        this.Symbol = Symbol;
    }

    public Tile(int X, int Y) {
        this.X = X;
        this.Y = Y;
        this.Symbol = ' ';
    }

    public void paintWithNewSymbol(char symbol) {
        Symbol = symbol;
    }

    public boolean isPaintedWith(char symbol) {
        return Symbol == symbol;
    }
}