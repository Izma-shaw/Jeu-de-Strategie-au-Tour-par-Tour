package entites;


public class Position implements Comparable<Position> {

    private int x;
    private int y;

    public Position(int x, int y){
        this.x=x;
        this.y=y;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    public void setX(int x){
        this.x = x;
    }

    public void setY(int y){
        this.y = y;
    }

    @Override
    public String toString(){
        return "x : "+this.x+
               "\ty : "+this.y;
    }

    @Override
    public int compareTo(Position p) {
        if(p.getX()==this.getY()){
            if(p.getY()==this.getY()){
                return 1;
            }
        }
        return 0;
    }
}
