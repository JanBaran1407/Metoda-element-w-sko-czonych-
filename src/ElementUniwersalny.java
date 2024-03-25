import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.function.Function;

public class ElementUniwersalny {
    ElementUniwersalny(int n) {
        ksi = new double[n * n][4];
        eta = new double[n * n][4];
        this.n = n;
        fun();
    }

    double[][] ksi;
    double[][] eta;

    int n;

    void importData(int n) {

        if (n == 2) {
            double p1 = -1.0 * Math.sqrt(1.0 / 3.0);
            double p2 = Math.sqrt(1.0 / 3.0);
            double[] p = {p1, p2};
            for (int j = 0; j < n * n; j++) {
                for (int i = 0; i < 4; i++) {
//                    if (j < 2)
//                        eta[j][i] = fun_eta[i].apply(p[0]);
//                    else
//                        eta[j][i] = fun_eta[i].apply(p[1]);

                    ksi[j][i] = fun_ksi[i].apply(p[j % 2]);
                    eta[j][i] = fun_eta[i].apply(p[j % 2]);
                }
            }
            Arrays.sort(ksi, (a, b) -> Double.compare(a[0], b[0]));
        }

        if (n == 3) {
            double p1 = -1.0 * Math.sqrt(3.0 / 5.0);
            double p2 = 0.0;
            double p3 = Math.sqrt(3.0 / 5.0);
            double[] p = {p1, p2, p3};
            for (int j = 0; j < n * n; j++) {
                for (int i = 0; i < 4; i++) {
                    ksi[j][i] = fun_ksi[i].apply(p[j % 3]);
                    eta[j][i] = fun_eta[i].apply(p[j % 3]);
//
//                    if (j < 3)
//                        eta[j][i] = fun_eta[i].apply(p[0]);
//                    else if (j < 6)
//                        eta[j][i] = fun_eta[i].apply(p[1]);
//                    else
//                        eta[j][i] = fun_eta[i].apply(p[2]);
                }
            }
            Arrays.sort(ksi, (a, b) -> Double.compare(a[0], b[0]));
        }
        if (n == 4) {
            double p1 = -1.0 * Math.sqrt((3.0 / 7.0) - ((2.0 / 7.0) * Math.sqrt(6.0 / 5.0)));
            double p2 = -1.0 * Math.sqrt((3.0 / 7.0) + ((2.0 / 7.0) * Math.sqrt(6.0 / 5.0)));
            double p3 = Math.sqrt((3.0 / 7.0) - ((2.0 / 7.0) * Math.sqrt(6.0 / 5.0)));
            double p4 = Math.sqrt((3.0 / 7.0) + ((2.0 / 7.0) * Math.sqrt(6.0 / 5.0)));
            double[] p = {p1, p2, p3, p4};
            for (int j = 0; j < n * n; j++) {
                for (int i = 0; i < 4; i++) {

                    ksi[j][i] = fun_ksi[i].apply(p[j % 4]);
                    eta[j][i] = fun_eta[i].apply(p[j % 4]);
//                    if (j < 4)
//                        eta[j][i] = fun_eta[i].apply(p[0]);
//                    else if (j < 8)
//                        eta[j][i] = fun_eta[i].apply(p[1]);
//                    else if (j < 12)
//                        eta[j][i] = fun_eta[i].apply(p[2]);
//                    else
//                        eta[j][i] = fun_eta[i].apply(p[3]);

                }
            }
            Arrays.sort(ksi, (a, b) -> Double.compare(a[0], b[0]));
        }
    }

    Function<Double, Double>[] fun_ksi = new Function[4];
    Function<Double, Double>[] fun_eta = new Function[4];

    void fun() {
        fun_eta[0] = x -> -0.25 * (1 - x);
        fun_eta[1] = x -> -0.25 * (1 + x);
        fun_eta[2] = x -> 0.25 * (1 + x);
        fun_eta[3] = x -> 0.25 * (1 - x);

        fun_ksi[0] = x -> -0.25 * (1 - x);
        fun_ksi[1] = x -> 0.25 * (1 - x);
        fun_ksi[2] = x -> 0.25 * (1 + x);
        fun_ksi[3] = x -> -0.25 * (1 + x);
    }

    void print(double[][] tab) {
        for (int i = 0; i < n * n; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.printf("%.6f" + " ", tab[i][j]);
            }
            System.out.println();
        }
    }

}



