import java.util.Scanner;

public class MatrixMultiplier {
    private int[][] a;
    private int na;
    private int ma;
    private int[][] b;
    private int nb;
    private int mb;
    public int[][] c;
    public int nc;
    public int mc;
    public int counter;
    private boolean flag;
    Scanner scanner = new Scanner(System.in);
    MatrixMultiplier()
    {}
    MatrixMultiplier(int na, int ma, int nb, int mb, int[][]a, int[][]b, int counter)
    {
    this.na = na;
    this.ma = ma;
    this.nb = nb;
    this.mb = mb;
    this.a = a;
    this.b = b;
    Multiply(counter);
    }

    public void Multiply(int count)
    {
        counter = count;
        flag = false;
        /*a = new int[na][ma];
        for (int i = 0; i < na; i++) {
            for (int j = 0; j < ma; j++) {
                a[i][j] = scanner.nextInt();
            }
        }*/
        if (ma != nb) {
            flag=true;
            return;
        }
        /*b = new int[nb][mb];
        for (int i = 0; i < nb; i++) {
            for (int j = 0; j < mb; j++) {
                b[i][j] = scanner.nextInt();
            }
        }*/
        c = new int[na][mb];
        for (int i = 0; i < na; i++)
        {
            for (int j = 0; j < mb; j++)
            {
                counter++;
                for (int r = 0; r < ma; r++)
                {
                    c[i][j] += a[i][r] * b[r][j];
                }
            }
        }
        nc=na;
        mc = mb;
    }
    public boolean soutResult()
    {
        if (flag) {
            System.out.println("Умножение матриц невозможно, т.к. кол-во столбцов первой матрицы не равно кол-ву строк второй!");
            return true;
        }
        System.out.print(na + " " + mb + "\n");
        for (int i = 0; i < na; i++)
        {

            for (int j = 0; j < mb; j++)
            {
                System.out.print(c[i][j]);
                if (j + 1 != mb) System.out.print(" ");
            }
            System.out.print("\n");
        }
        return false;
    }
    public void soutcounter()
    {
        if (flag) {
            System.out.println("Умножение матриц невозможно, т.к. кол-во столбцов первой матрицы не равно кол-ву строк второй!");
            return;
        }
        System.out.println(counter);
    }

}