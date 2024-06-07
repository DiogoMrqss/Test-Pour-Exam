g/************************/
//NE PAS MODIFIER !!
/************************/

public class Coord
{
        private int x;
        private int y;

        public Coord(int x, int y)
        {
            this.x = x;
            this.y = y;
        }

        public int distanceAvec(Coord autrePosition)
        {
            return Math.abs(x-autrePosition.x)+Math.abs(y-autrePosition.y);
        }


        public String toString()
        {
            return "("+x+", "+y+")";
        }

}
