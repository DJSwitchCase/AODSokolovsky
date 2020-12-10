public class main {
    public static void main(String[] args) {
        //Инициализируем матрицы
        int[][] A = {{1,1,1},{1,1,1},{1,1,1}};
        int [][] B = {{2,2},{2,2},{2,2}};
        int [][] C = {{3, 3,3},{3,3,3}};
        int [][]D  = {{4,4,4},{4,4,4},{4,4,4}};

        MatrixMultiplier AxB = new MatrixMultiplier(3,3,3,2,A,B,0);
        MatrixMultiplier AxBxC = new MatrixMultiplier(AxB.nc, AxB.mc, 2,3, AxB.c,C,AxB.counter);
        MatrixMultiplier AxBxCxD = new MatrixMultiplier(AxBxC.nc,AxBxC.mc,3,3,AxBxC.c,D,AxBxC.counter);

        MatrixMultiplier AxD = new MatrixMultiplier(3,3,3,3,A,D,0);
        MatrixMultiplier AxDxB = new MatrixMultiplier(AxD.nc,AxD.mc, 3, 2, AxD.c,B, AxD.counter);
        MatrixMultiplier AxDxBxC = new MatrixMultiplier(AxDxB.nc,AxDxB.mc, 2, 3, AxDxB.c,C, AxDxB.counter);

        if (AxBxCxD.counter>AxDxBxC.counter)
            System.out.println("Первый способ оптимальнее");
        else if (AxBxCxD.counter<AxDxBxC.counter)
        System.out.println("Второй способ оптимальнее");
        else
        System.out.println("Оба способа дают одинаковый результат");


    }
}
