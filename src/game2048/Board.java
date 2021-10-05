package game2048;

public class Board {
//Array of Tiles
//Score
	public Tile[][] board;

    int grids = 4;

    int border = 0;

    public int score = 0;
	
	//constructor
	public Board() {
		board = new Tile[4][4];
        for ( int i = 0; i < board.length; i++ )
        {
            for ( int j = 0; j < board[i].length; j++ )
            {
                board[i][j] = new Tile();
            }
        }
	}
	
	public Board( int grids )
    {
        this.grids = grids;
        board = new Tile[grids][grids];
        for ( int i = 0; i < board.length; i++ )
        {
            for ( int j = 0; j < board[i].length; j++ )
            {
                board[i][j] = new Tile();
            }
        }
    }
	
	public Board( int lose, int grids )
    {
        this.grids = grids;
        board = new Tile[grids][grids];
        for ( int i = 0; i < board.length; i++ )
        {
            for ( int j = 0; j < board[i].length; j++ )
            {
                board[i][j] = new Tile( ( lose + i + j ) * ( i + j ) );
            }
        }
    }
	
	//methods
	
	//getter method that returns the board
	public Tile[][] getBoard() {
		
		return board;
	}
	
	//getter method that returns the score
	public int getScore() {
		 return score;
	}
	
	//Finds the highest tile in the board and returns it.
	public int getHighTile() {
		
		int high = board[0][0].getValue();
        for ( int i = 0; i < board.length; i++ )
        {
            for ( int j = 0; j < board[i].length; j++ )
            {
                if ( board[i][j].getValue() > high )
                {
                    high = board[i][j].getValue();
                }
            }
        }
        return high;
	}
	
	//Prints the board to console.
	public void print() {
		for ( int i = 0; i < board.length; i++ )
        {
            for ( int j = 0; j < board[i].length; j++ )
            {
                String s = board[i][j].toString() + " ";
                System.out.print( s );
            }
            System.out.println( "" );
        }
        System.out.println( "Score: " + score );
	}
	
	//converts board to string for GUI.
	public String toString()
    {
        String s = "";
        for ( int i = 0; i < board.length; i++ )
        {
            for ( int j = 0; j < board[i].length; j++ )
            {
                s += board[i][j].toString() + " ";
            }
            s += "\n";
        }
        return s;
    }
	
	//Spawns a 2 or a 4 in an empty cell every time a move is made.
	public void spawn() {
		
		 boolean empty = true;
	        while ( empty )
	        {
	            int row = (int)( Math.random() * 4 );
	            int col = (int)( Math.random() * 4 );
	            double x = Math.random();
	            if ( board[row][col].getValue() == 0 )
	            {
	                if ( x < 0.2 )
	                {
	                    board[row][col] = new Tile( 4 );
	                    empty = false;
	                }
	                else
	                {
	                    board[row][col] = new Tile( 2 );
	                    empty = false;
	                }
	            }

	        }
	}
	
	//checks if board is completely blacked out.
	public boolean blackOut() {
		
		 int count = 0;
	        for ( int i = 0; i < board.length; i++ )
	        {
	            for ( int j = 0; j < board[i].length; j++ )
	            {
	                if ( board[i][j].getValue() > 0 )
	                {
	                    count++;
	                }
	            }
	        }
	        if ( count == 16 )
	        {
	            return true;
	        }
	        return false;
	}
	
	//checks if game is over.
	public boolean gameOver() {
		int count = 0;
        for ( int i = 0; i < board.length; i++ )
        {
            for ( int j = 0; j < board[i].length; j++ )
            {
                if ( board[i][j].getValue() > 0 )
                {
                    if ( i == 0 && j == 0 )
                    {
                        if ( board[i][j].getValue() != board[i + 1][j].getValue()
                            && board[i][j].getValue() != board[i][j + 1].getValue() )
                        {
                            count++;
                        }
                    }
                    else if ( i == 0 && j == 3 )
                    {
                        if ( board[i][j].getValue() != board[i + 1][j].getValue()
                            && board[i][j].getValue() != board[i][j - 1].getValue() )
                        {
                            count++;
                        }
                    }
                    else if ( i == 3 && j == 3 )
                    {
                        if ( board[i][j].getValue() != board[i - 1][j].getValue()
                            && board[i][j].getValue() != board[i][j - 1].getValue() )
                        {
                            count++;
                        }
                    }
                    else if ( i == 3 && j == 0 )
                    {
                        if ( board[i][j].getValue() != board[i - 1][j].getValue()
                            && board[i][j].getValue() != board[i][j + 1].getValue() )
                        {
                            count++;
                        }
                    }
                    else if ( i == 0 && ( j == 1 || j == 2 ) )
                    {
                        if ( board[i][j].getValue() != board[i + 1][j].getValue()
                            && board[i][j].getValue() != board[i][j + 1].getValue()
                            && board[i][j].getValue() != board[i][j - 1].getValue() )
                        {
                            count++;
                        }
                    }
                    else if ( i == 3 && ( j == 1 || j == 2 ) )
                    {
                        if ( board[i][j].getValue() != board[i - 1][j].getValue()
                            && board[i][j].getValue() != board[i][j + 1].getValue()
                            && board[i][j].getValue() != board[i][j - 1].getValue() )
                        {
                            count++;
                        }
                    }
                    else if ( j == 0 && ( i == 1 || i == 2 ) )
                    {
                        if ( board[i][j].getValue() != board[i][j + 1].getValue()
                            && board[i][j].getValue() != board[i - 1][j].getValue()
                            && board[i][j].getValue() != board[i + 1][j].getValue() )
                        {
                            count++;
                        }
                    }
                    else if ( j == 3 && ( i == 1 || i == 2 ) )
                    {
                        if ( board[i][j].getValue() != board[i][j - 1].getValue()
                            && board[i][j].getValue() != board[i - 1][j].getValue()
                            && board[i][j].getValue() != board[i + 1][j].getValue() )
                        {
                            count++;
                        }
                    }
                    else
                    {
                        if ( board[i][j].getValue() != board[i][j - 1].getValue()
                            && board[i][j].getValue() != board[i][j + 1].getValue()
                            && board[i][j].getValue() != board[i - 1][j].getValue()
                            && board[i][j].getValue() != board[i + 1][j].getValue() )
                        {
                            count++;
                        }
                    }
                }
            }
        }
        if ( count == 16 )
        {
            return true;
        }
        return false;
	}
	
	//called when w key is presssed.
	public void up() {
		
		for ( int i = 0; i < grids; i++ )
        {
            border = 0;
            for ( int j = 0; j < grids; j++ )
            {
                if ( board[j][i].getValue() != 0 )
                {
                    if ( border <= j )
                    {
                        verticalMove( j, i, "up" );
                    }
                }
            }
        }
		
	}
	
	//called when s key is presssed.
	public void down() {
		
		for ( int i = 0; i < grids; i++ )
        {
            border = ( grids - 1 );
            for ( int j = grids - 1; j >= 0; j-- )
            {
                if ( board[j][i].getValue() != 0 )
                {
                    if ( border >= j )
                    {
                        verticalMove( j, i, "down" );
                    }
                }
            }
        }
	}
	
	//called when d key is presssed.
	
	public void right() {
		
		for ( int i = 0; i < grids; i++ )
        {
            border = ( grids - 1 );
            for ( int j = ( grids - 1 ); j >= 0; j-- )
            {
                if ( board[i][j].getValue() != 0 )
                {
                    if ( border >= j )
                    {
                        horizontalMove( i, j, "right" );
                    }
                }
            }
        }
	}
	
	//called when a key is presssed.
	public void left() {
		
		for ( int i = 0; i < grids; i++ )
        {
            border = 0;
            for ( int j = 0; j < grids; j++ )
            {
                if ( board[i][j].getValue() != 0 )
                {
                    if ( border <= j )
                    {
                        horizontalMove( i, j, "left" );
                    }
                }
            }
        }
	}
	
	/* Compares two tile's values together and if they are the same or if one is equal to 0 (plain tile) - their values are added (provided that the tiles we are comparing are two different tiles and they are moving towards the appropriate direction) - recursively moves through the column */
	public void horizontalMove(int row, int col, String direction) {
		
		Tile initial = board[row][border];
        Tile compare = board[row][col];
        if ( initial.getValue() == 0 || initial.getValue() == compare.getValue() )
        {
            if ( col > border || ( direction.equals( "right" ) && ( col < border ) ) )
            {
                int addScore = initial.getValue() + compare.getValue();
                if ( initial.getValue() != 0 )
                {
                    score += addScore;
                }
                initial.setValue( addScore );
                compare.setValue( 0 );
            }
        }
        else
        {
            if ( direction.equals( "right" ) )
            {
                border--;
            }
            else
            {
                border++;
            }
            horizontalMove( row, col, direction );
        }
	}
	
	public void verticalMove(int row, int col, String direction) {
		
		Tile initial = board[border][col];
        Tile compare = board[row][col];
        if ( initial.getValue() == 0 || initial.getValue() == compare.getValue() )
        {
            if ( row > border || ( direction.equals( "down" ) && ( row < border ) ) )
            {
                int addScore = initial.getValue() + compare.getValue();
                if ( initial.getValue() != 0 )
                {
                    score += addScore;
                }
                initial.setValue( addScore );
                compare.setValue( 0 );
            }
        }
        else
        {
            if ( direction.equals( "down" ) )
            {
                border--;
            }
            else
            {
                border++;
            }
            verticalMove( row, col, direction );
        }
        
	}
	
	
	
	
	
	
	
	
	
}
