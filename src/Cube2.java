public class Cube2 {

    // Properties
    private Cube basicCube;
    private String color;

    //Constructors
    public Cube2() {
        basicCube = new Cube();
        this.basicCube = new Cube(1);
        this.color = "black";
    }

    public Cube2(int side) {
        this();
        this.basicCube = new Cube(side);
        this.color = "black";
    }

    public Cube2(int side, String color) {
        this();
        //this.basicCube.setSide(side); // this will not work because side is private in Cube.java
        this.basicCube = new Cube(side);
        this.color = color;
    }

    // Behaviours
    public int getSide() {
        return basicCube.getSide();
    }

    public void setSide(int side){
        if (side < 1) {
            throw new IllegalArgumentException("A cube's side length cannot be less than 1!");
        }
        basicCube.setSide(side);
    }

    public String getColor(){
        return color;
    }

    public void setColor(String color){
        this.color = color;
    }

    public int calculateSurfaceArea(){
        return basicCube.calculateSurfaceArea();
    }

    public int calculateVolume(){
        return basicCube.calculateVolume();
    }

    public boolean equals(Cube2 otherCube){
        if((this.basicCube.getSide() == otherCube.basicCube.getSide()) && (this.color.equals(otherCube.color))){
            return true;
        } else {
            return false;
        }
    }

    //the following methods have been started for you, but need to be completed
    //public int calculateVolume() { return 0;}
    //public int calculateSurfaceArea() { return 0;}

    public Cube2 add(Cube2 otherCube){
        Cube2 newCube = new Cube2();    // Creation of new Cube2

        int cube1Side = this.getSide();
        int cube2Side = otherCube.getSide();

        //Pythagorean theorem = (a*a) + (b*b) = (c*c)
        // x = c*c
        // side of new Cube2 (ie: c) = square root of x
        // Math.sqrt(x) is the syntax in Java for square root
        int newCubeSide = (int) Math.sqrt((cube1Side * cube1Side)+(cube2Side * cube2Side));

        if((cube1Side * cube1Side) + (cube2Side * cube2Side) == (newCubeSide * newCubeSide)){
            newCube.setSide(newCubeSide);
            newCube.color = this.color;
            return newCube;
        } else {
            throw new IllegalArgumentException("Not a Pythagorean triple!");
        }
    }

    public Cube2 minus(Cube2 otherCube) {
        Cube2 newCube = new Cube2();    // Creation of new Cube2

        int cube1SurfaceArea = this.calculateSurfaceArea();
        int cube2SurfaceArea = otherCube.calculateSurfaceArea();
        int diffSurfaceArea = cube1SurfaceArea - cube2SurfaceArea;
        if (diffSurfaceArea < 0) {
            diffSurfaceArea = diffSurfaceArea * -1; // Make positive number
        }

        // To determine the side for diffSurfaceArea
        // side * side * 6 = Surface Area
        // side * side = Surface Area / 6
        // side = square root of (Surface Area / 6)
        // side must be an integer to satisfy Pythagorean theorem given Cube.side is an integer type
        // ie: cannot be a double.
        // Pythagorean theorem = (a*a) + (b*b) = (c*c)
        int newDiffCubeSide = (int) Math.sqrt(diffSurfaceArea / 6);

        // the theory is:
        // if newDiffCubeSide is an integer (not just because it's rounded up/down from square root),
        // then (newDiffCubeSide * newDiffCubeSide * 6) = diffSurfaceArea
        if (newDiffCubeSide * newDiffCubeSide * 6 == diffSurfaceArea) {
            // Set values for new Cube2
            newCube.setSide(newDiffCubeSide);
            newCube.color = this.color;
            return newCube;
        } else {
            throw new IllegalArgumentException("Not a Pythagorean triple!");
        }
    }

    public String toString() {
        // Note to self: This will overwrite toString in Cube class. Cube has no color also.
        return "Cube{side=" + getSide() + ", color=\"" + color + "\"}";
    }
}
