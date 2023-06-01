public class Matrix {
    /**
     * these parameters set the height and width of the matrix, and data is an array of numbers that are contained in the matrix
     */
    int n, m;
    Complex[][] data;
    Matrix (int first, int second) {
        n = first;
        m = second;
        data = new Complex[n][m];
    }

    /**
     * this function fill the matrix with complex numbers
     * @param masOfComplex massive of complex numbers
     */
    public void FillMatrix (Complex[][] masOfComplex) {
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                data[i][j] = new Complex(masOfComplex[i][j].a, masOfComplex[i][j].b);
    }

    /**
     * adds this matrix with another
     * @param other another matrix
     * @return the sum of two matrix as new matrix
     */
    public Matrix AddMatrix(Matrix other) {
        Matrix new_matrix = new Matrix(n, m);
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                new_matrix.data[i][j] = data[i][j].AddComplex(other.data[i][j]);
        return new_matrix;
    }

    /**
     * counts the difference of this matrix with another
     * @param other another matrix
     * @return the difference of two matrix as new matrix
     */
    public Matrix MultiplyMatrix(Matrix other) throws Exception {
        if (m != other.n) {
            throw new Exception("The boundaries of the arrays doesn't match!!");
        }
        Matrix new_matrix = new Matrix(n, other.m);
        for (int i = 0; i < n; i++)
            for (int j = 0; j < other.m; j++) {
                Complex new_complex = new Complex(0, 0);
                for (int x = 0; x < m; x++)
                    new_complex = new_complex.AddComplex(data[i][x].MultiplyComplex(other.data[x][j]));
                new_matrix.data[i][j] = new_complex;
            }
        return new_matrix;
    }

    /**
     * this function just transpose matrix
     * @return transposed matrix as new matrix
     */
    public Matrix TransposeMatrix() {
        Matrix new_matrix = new Matrix(m, n);
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                new_matrix.data[i][j] = new Complex(data[j][i].a, data[j][i].b);
        return new_matrix;
    }

    /**
     * counts the determinant of two-dimensional matrix
     * @return complex number - determinant of this matrix
     */
    public Complex CalcDetOf2DemMatrix() {
        return data[0][0].MultiplyComplex(data[1][1]).SubComplex(data[0][1].MultiplyComplex(data[1][0]));
    }

    /**
     * A recursive function that splits the matrix into smaller-order minors and causes the determinant to be counted for each minor.
     * If the minor is two-dimensional, it calls a function that returns its determinant
     * @return complex number - the determinant of this matrix
     */
    public Complex CalcDet() {
        if (n == 2)
            return CalcDetOf2DemMatrix();
        else {
            Complex det = new Complex(0, 0);
            for (int i = 0; i < n; i++) {
                Matrix new_matrix = new Matrix(n - 1, n - 1);
                Complex[][] new_data = new Complex[n - 1][n - 1];
                for (int x = 1; x < n; x++)
                    for (int y = 0; y < m; y++)
                        if (y != i) {
                            if (y < i)
                                new_data[x - 1][y] = new Complex(data[x][y].a, data[x][y].b);
                            else {
                                new_data[x - 1][y - 1] = new Complex(data[x][y].a, data[x][y].b);
                            }
                        }
                new_matrix.FillMatrix(new_data);
                det = det.AddComplex(new Complex(Math.pow(-1, i), 0).MultiplyComplex(data[0][i]).MultiplyComplex(new_matrix.CalcDet()));
            }
            return det;
        }
    }

    /**
     * this function just print matrix on screen
     */
    public void printMatrix() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                data[i][j].PrintComplex();
                System.out.print("\t");
            }
            System.out.println();
        }
        System.out.println("\n");
    }
}
