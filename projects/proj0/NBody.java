import java.util.*;

public class NBody {

    public static double readRadius(String fileName) {

        In in = new In(fileName);

        int numberPlanets = in.readInt();
        double universeRadius = in.readDouble();

        return universeRadius;

    }

    public static Body[] readBodies(String fileName) {

        System.out.println("Reading " + fileName);

        In in = new In(fileName);

        ArrayList<Body> arraylist = new ArrayList<Body>();

        String numberPlanets = in.readString();
        String universeRadius = in.readString();

        while(!in.isEmpty()) {

            try {
                double xxPos = Double.parseDouble(in.readString());
                double yyPos = Double.parseDouble(in.readString());
                double xxVel = Double.parseDouble(in.readString());
                double yyVel = Double.parseDouble(in.readString());
                double mass = Double.parseDouble(in.readString());
                String img = in.readString();

                arraylist.add(new Body(xxPos, yyPos, xxVel, yyVel, mass, img));

            } catch (Exception e) {

                break;

            }

        }

        Body[] bodies = arraylist.toArray(new Body[arraylist.size()]);

        return bodies;

    }

    public static void main(String[] args) {

        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);

        String filename = args[2];

        double radius = readRadius(filename);
        Body[] allBodys = readBodies(filename);

        // Drawing stuff now

        String imageToDraw = "images/starfield.jpg";
        StdDraw.enableDoubleBuffering();

        /** Sets up the universe so it goes from
         * -100, -100 up to 100, 100 */
        StdDraw.setScale(-radius, radius);

        /* Clears the drawing window. */
        StdDraw.clear();

        /* Draws the background. */
        StdDraw.picture(0, 0, imageToDraw);

        /* Shows the drawing to the screen, and waits 2000 milliseconds. */
        StdDraw.show();
        StdDraw.pause(2000);

    }


}