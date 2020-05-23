import static java.lang.Math.pow;
import static java.lang.Math.sqrt;


public class Body {

    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;

    public String imgFileName;

    public Body(double xP, double yP, double xV, double yV, double m, String img) {

        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;

        imgFileName = img;

    }

    public Body(Body b) {

        this.xxPos = b.xxPos;
        this.yyPos = b.yyPos;
        this.xxVel = b.xxVel;
        this.yyVel = b.yyVel;
        this.mass  = b.mass;

        this.imgFileName = b.imgFileName;

    }

    public double calcDistance(Body otherBody) {


        double xSq = pow(otherBody.xxPos - this.xxPos, 2);
        double ySq = pow(otherBody.yyPos - this.yyPos, 2);

        double r = sqrt(xSq + ySq);

        return r;

    }

    public double calcForceExertedBy(Body otherBody) {

        double G = 6.67e-11;

        double F = (G * this.mass * otherBody.mass) / pow(calcDistance(otherBody), 2);

        return F;

    }

    public double calcNetForceExertedByX(Body[] allBodys) {

        double xNetForce = 0;

        for (Body b : allBodys) {

            if (this.equals(b)) {
                continue;
            } else {
                xNetForce += calcForceExertedBy(b) * (b.xxPos - this.xxPos) / calcDistance(b);
            }
        }

        return xNetForce;


    }


    public double calcNetForceExertedByY(Body[] allBodys) {

        double yNetForce = 0;

        for (Body b : allBodys) {

            if (this.equals(b)) {
                continue;
            } else {
                yNetForce += calcForceExertedBy(b) * (b.yyPos - this.yyPos) / this.calcDistance(b);
            }
        }

        return yNetForce;

    }


    public void update(double t, double xF, double yF) {

        double xa = xF/this.mass;
        double ya = yF/this.mass;

        this.xxVel = this.xxVel + t*xa;
        this.yyVel = this.yyVel + t*ya;

        this.xxPos = this.xxPos + t*this.xxVel;
        this.yyPos = this.yyPos + t*this.yyVel;

    }


}