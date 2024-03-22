public class Game {
    private char _lastSymbol = ' ';
    private Board _board = new Board();

    public void Play(char symbol, int x, int y) throws Exception {
        handleInvalidPlays(symbol, x, y);

        _lastSymbol = symbol;
        _board.AddTileAt(symbol, x, y);
    }

    private void handleInvalidPlays(char symbol, int x, int y) throws Exception {
        if (isFirstMove() && isPlayerO(symbol)) {
            throw new Exception("Invalid first player");
        }
        if (repeatedPlayer(symbol)) {
            throw new Exception("Invalid next player");
        }
        if (isTileTaken(x, y)) {
            throw new Exception("Invalid position");
        }
    }

    private boolean isTileTaken(int x, int y) {
        return _board.TileAt(x, y).Symbol != ' ';
    }

    private boolean repeatedPlayer(char symbol) {
        return symbol == _lastSymbol;
    }

    private static boolean isPlayerO(char symbol) {
        return symbol == 'O';
    }

    private boolean isFirstMove() {
        return _lastSymbol == ' ';
    }

    public char Winner() {
        //if the positions in first row are taken
        if (_board.TileAt(0, 0).Symbol != ' ' &&
                _board.TileAt(0, 1).Symbol != ' ' &&
                _board.TileAt(0, 2).Symbol != ' ') {
            //if first row is full with same symbol
            if (_board.TileAt(0, 0).Symbol ==
                    _board.TileAt(0, 1).Symbol &&
                    _board.TileAt(0, 2).Symbol == _board.TileAt(0, 1).Symbol) {
                return _board.TileAt(0, 0).Symbol;
            }
        }

        //if the positions in first row are taken
        if (_board.TileAt(1, 0).Symbol != ' ' &&
                _board.TileAt(1, 1).Symbol != ' ' &&
                _board.TileAt(1, 2).Symbol != ' ') {
            //if middle row is full with same symbol
            if (_board.TileAt(1, 0).Symbol ==
                    _board.TileAt(1, 1).Symbol &&
                    _board.TileAt(1, 2).Symbol ==
                            _board.TileAt(1, 1).Symbol) {
                return _board.TileAt(1, 0).Symbol;
            }
        }

        //if the positions in first row are taken
        if (_board.TileAt(2, 0).Symbol != ' ' &&
                _board.TileAt(2, 1).Symbol != ' ' &&
                _board.TileAt(2, 2).Symbol != ' ') {
            //if middle row is full with same symbol
            if (_board.TileAt(2, 0).Symbol ==
                    _board.TileAt(2, 1).Symbol &&
                    _board.TileAt(2, 2).Symbol ==
                            _board.TileAt(2, 1).Symbol) {
                return _board.TileAt(2, 0).Symbol;
            }
        }

        return ' ';
    }
}

