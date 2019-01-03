/**
 * 回溯法
 * 通常回溯法适合用递归实现的代码。
 * 题目：设计一个函数，用来判断在一个矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。
 * 如果一条路径经过了矩阵的某一格，那么该路径不能进入再次进入该格子。
 */
public class Demo12 {
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {

        if (matrix == null || rows < 1 || cols < 1 || str == null){
            return false;
        }

        boolean[] visited = new boolean[matrix.length];

        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                if (searchFromHere(matrix, rows, cols, i, j, 0, str, visited))
                    return true;
            }
        }
        return false;

    }

    private boolean searchFromHere(char[] matrix, int rows, int cols, int r,
                                   int c, int index, char[] str, boolean[] visited) {

        if (r < 0 || r >= rows || c < 0 || c >= cols ||
                matrix[r * cols + c] != str[index] || visited[r * cols + c]){
            return false;
        }

        if (index == str.length - 1)
            return true;

        visited[r * cols + c] = true;
        if(searchFromHere(matrix,rows, cols, r - 1, c, index + 1, str, visited) ||
                searchFromHere(matrix, rows, cols, r, c - 1, index + 1, str, visited) ||
                searchFromHere(matrix, rows, cols, r + 1, c, index + 1, str, visited) ||
                searchFromHere(matrix, rows, cols, r, c + 1, index + 1, str, visited)){
            return true;
        }
        visited[r * cols + c] =false;
        return false;

    }
}
