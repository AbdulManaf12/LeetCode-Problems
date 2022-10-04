class Solution_1 {
    public int[] kWeakestRows(int[][] mat, int k) {
        if(isSizeOkay(mat, k)){
            int m = mat.length;
            int sizearray[][] = new int[m][2];
            for(int i=0; i<m; i++){
                int n = mat[i].length;
                int Count_one = 0;
                for(int j=0; j<n; j++){
                    if(mat[i][j] == 1){
                        Count_one++;
                    }
                    else{
                        break;
                    }
                }
                sizearray[i][0] = i;
                sizearray[i][1] = Count_one;
            }
            for(int i=0; i<m; i++){
                for(int j=i; j<m-1; j++){
                    if(sizearray[j][1] > sizearray[j+1][1]){
                        int temp = sizearray[j][1];
                        sizearray[j][1] = sizearray[j+1][1];
                        sizearray[j+1][1] = temp;
                        
                        temp = sizearray[j][0];
                        sizearray[j][0] = sizearray[j+1][0];
                        sizearray[j+1][0] = temp;
                    }
                }
            }
            int finalArray[] = new int[k];
            for(int i=0; i<k; k++){
                finalArray[i] = sizearray[i][0];
            }
            return finalArray;
        }
        return null;
    }
    private boolean isSizeOkay(int[][] arr, int k){
        int m = arr.length;
        if(m <= 100 && k >= 1 && k <= m){
               for(int i=0; i<m; i++){
                   int n = arr[i].length;
                   if(n < 2){
                       return false;
                   }
                   for(int j=0; j<n; j++){
                       if(arr[i][j] == 1 || arr[i][j] == 0){
                           continue;
                       }else{
                           return false;
                       }
                   }
               }
            return true;
        }
        return false;
    }
}